package com.common.action;

import com.common.action.impl.ManagerLoginServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet控制器
 * 管理员的servlet类
 * 用于判断前端执行动作
 */
public class ManagerLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String method = request.getParameter("method");
            if ("login".equals(method)) {
                doLogin(request, response);
            }
            if ("register".equals(method)) {
                doRegister(response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    /**
     * 管理员登录方法
     *
     * @param request  形参
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        int key = Integer.parseInt(request.getParameter("key"));

        boolean bool = new ManagerLoginServiceImpl().findManager(key);

        if (bool) {
            response.sendRedirect("pages/manager.jsp");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('密钥错误')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/manager-login.jsp'</script>");
        }
    }

    /**
     * 管理员注册方法
     *
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void doRegister(HttpServletResponse response) throws IOException, ClassNotFoundException {

        int key = (int) (Math.random() * 1000000);

        boolean bool = new ManagerLoginServiceImpl().findManager(key);
        boolean bool1 = new ManagerLoginServiceImpl().addManager(key);

        if (bool) {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('用户名已存在')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/manager-register.jsp'</script>");
        } else {
            if (bool1) {
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('注册成功,以进入管理员系统')</script>");
                response.getWriter().println("<script>alert('您的管理员登录密钥为:' + " + key + ")</script>");
                response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/manager.jsp'</script>");
            }
        }
    }
}
