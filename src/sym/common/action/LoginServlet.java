package sym.common.action;

import sym.common.action.impl.LoginServiceImpl;
import sym.common.bean.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * servlet控制器
 * 用户的servlet类
 * 用于判断前端执行动作
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //判断执行动作
            String method = request.getParameter("method");
            if ("login".equals(method)) {
                doLogin(request, response);
            }
            if ("register".equals(method)) {
                doRegister(request, response);
            }
            if ("drop".equals(method)) {
                doDrop(request, response);
            }
            if ("showAll".equals(method)) {
                showAll(response);
            }
            if ("change".equals(method)) {
                changeUser(request, response);
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
     * 登录用户方法
     *
     * @param request  形参
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean bool = new LoginServiceImpl().findUser(username, password);
        User user = new LoginServiceImpl().showMessage(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        if (bool) {
            response.sendRedirect("pages/welcome.jsp");
            this.getServletContext().setAttribute("user", user);
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('用户名或密码错误')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded'</script>");
        }
    }

    /**
     * 注册用户方法
     *
     * @param request  形参
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("year");
        String age = request.getParameter("age");

        boolean bool = new LoginServiceImpl().findUser(username, password);

        if (bool) {
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('用户名已存在')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/register.jsp'</script>");
        } else {

            boolean bool1 = new LoginServiceImpl().addUser(username, password, phone, sex, birthday, age);

            if (bool1) {
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('注册成功')</script>");
                response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/login.jsp'</script>");
            }
        }
    }

    /**
     * 删除用户方法
     *
     * @param request  形参
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void doDrop(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        boolean bool = new LoginServiceImpl().findUser(username);

        if (bool) {

            boolean bool1 = new LoginServiceImpl().dropUser(username);

            response.setContentType("text/html");

            if (bool1) {
                response.getWriter().println("<script>alert('账户已注销')</script>");
                response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/login.jsp'</script>");
            } else {
                response.getWriter().println("<script>alert('账户注销失败')</script>");
                response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/setting.jsp'</script>");
            }
        }
    }

    /**
     * 更改用户信息方法
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    public void changeUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String age = request.getParameter("age");

        session.setAttribute("password", password);
        session.setAttribute("phone", phone);
        session.setAttribute("sex", sex);
        session.setAttribute("birthday", birthday);
        session.setAttribute("age", age);

        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAge(Integer.parseInt(age));


        boolean bool = new LoginServiceImpl().changeUser(username, password, phone, sex, birthday, age);

        response.setContentType("text/html");
        if (bool) {
            response.getWriter().println("<script>alert('用户信息已更改')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/setting.jsp'</script>");
            this.getServletContext().setAttribute("user", user);
        } else {
            response.getWriter().println("<script>alert('用户信息更新失败')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-change.jsp'</script>");
        }

    }


    /**
     * 展示所有用户方法
     *
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void showAll(HttpServletResponse response) throws IOException, ClassNotFoundException {
        List<User> users = new LoginServiceImpl().showAll();
        this.getServletContext().setAttribute("users", users);

        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/user-manager.jsp'</script>");
    }
}
