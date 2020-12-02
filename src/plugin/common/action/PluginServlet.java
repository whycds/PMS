package plugin.common.action;

import plugin.common.action.impl.PluginServiceImpl;
import plugin.common.bean.plugin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * servlet控制器
 * 插件的servlet类
 * 用于判断前端执行动作
 */
public class PluginServlet extends HttpServlet {
//    private List<plugin> plugins;
//    private PluginRep pluginRep;
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String p = req.getParameter("page");
//        int page;
//        try {
//            //当前页数
//            page = Integer.parseInt(p);
//        } catch (NumberFormatException e) {
//            page = 1;
//        }
//        //用户总数
//        int totalPlugins = plugins.size();
//        //每页用户数
//        int pluginsPerPage = 10;
//        //总页数
//        int totalPages = totalPlugins % pluginsPerPage == 0 ? totalPlugins / pluginsPerPage : totalPlugins / pluginsPerPage + 1;
//        //本页起始序号
//        int beginIndex = (page - 1) * pluginsPerPage;
//        //本页末尾序号下一个
//        int endIndex = beginIndex + pluginsPerPage;
//        if (endIndex > totalPlugins) {
//            endIndex = totalPlugins;
//        }
//        req.setAttribute("totalPlugins", totalPages);
//        req.setAttribute("pluginsPerPage", pluginsPerPage);
//        req.setAttribute("totalPages", totalPages);
//        req.setAttribute("beginIndex", beginIndex);
//        req.setAttribute("endIndex", endIndex);
//        req.setAttribute("page", page);
//        req.setAttribute("plugins", plugins);
//        req.getRequestDispatcher("/pages/plugin-find.jsp").forward(req,resp);
//
//    }
//
//    @Override
//    public void init() throws ServletException {
//        pluginRep = new listAll();
//        plugins = pluginRep.listAll();
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        try {
            if ("find".equals(method)) {
                doFind(request, response);
            }
            if ("add".equals(method)) {
                doAdd(request, response);
            }
            if ("drop".equals(method)) {
                doDrop(request, response);
            }
            if ("findChange".equals(method)) {
                doFindChange(request, response);
            }
            if ("find2".equals(method)) {
                doFind2(response);
            }
            if ("showAll".equals(method)) {
                showAll(response);
            }
            if ("change".equals(method)) {
                change(request, response);
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
     * 增加插件方法
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    public void doAdd(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String changeDate = dateFormat.format(now);
        String author = request.getParameter("author");
        boolean bool = new PluginServiceImpl().addPlugin(name, type, changeDate, price, author);
        response.setContentType("text/html");
        if (bool) {
            response.getWriter().println("<script>alert('插件添加成功')</script>");
        } else {
            response.getWriter().println("<script>alert('已存在此插件')</script>");
        }
        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-add.jsp'</script>");
    }

    /**
     * 增加删除方法
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    public void doDrop(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        boolean bool = new PluginServiceImpl().dropPlugin(name);
        response.setContentType("text/html");
        if (bool) {
            response.getWriter().println("<script>alert('插件删除成功')</script>");
        } else {
            response.getWriter().println("<script>alert('找不到此插件')</script>");
        }
        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-drop.jsp'</script>");
    }

    /**
     * 增加查找方法
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    public void doFind(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String name = request.getParameter("name");
        plugin plugin = new PluginServiceImpl().findPlugin(name);
        this.getServletContext().setAttribute("plugin", plugin);
        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-show.jsp'</script>");
    }

    /**
     * 增加插件方法
     * 查找了一个固定的插件
     * 用户初始化change.jsp页面的数据
     *
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    private void doFind2(HttpServletResponse response) throws ClassNotFoundException, IOException {
        String name = "插件1";
        plugin plugin = new PluginServiceImpl().findPlugin(name);
        this.getServletContext().setAttribute("plugin", plugin);
        int click = 0;
        this.getServletContext().setAttribute("click", click);
        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-change.jsp'</script>");
    }

    /**
     * 更新插件时的查找方法
     * 为更新插件做准备
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    private void doFindChange(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        String name = request.getParameter("name");
        plugin plugin = new PluginServiceImpl().findPlugin(name);
        this.getServletContext().setAttribute("plugin", plugin);
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        response.getWriter().println("<script>");
        response.getWriter().println("window.location.href='/PMS_war_exploded/pages/plugin-change.jsp';");
        response.getWriter().print("</script>");
        int click = 1;
        this.getServletContext().setAttribute("click", click);
    }

    /**
     * 更新插件方法
     *
     * @param request  形参
     * @param response 形参
     * @throws ClassNotFoundException 类空异常
     * @throws IOException            流异常
     */
    private void change(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        String author = request.getParameter("author");
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String changeDate = dateFormat.format(now);
        HttpSession session = request.getSession();
        String oldName = (String) session.getAttribute("name");
        boolean bool = new PluginServiceImpl().changePlugin(oldName, name, type, changeDate, price, author);

        response.setContentType("text/html");
        if (bool) {
            response.getWriter().println("<script>alert('插件更新成功')</script>");
            plugin plugin = new PluginServiceImpl().findPlugin(name);
            this.getServletContext().setAttribute("plugin", plugin);
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-show.jsp'</script>");
        } else {
            response.getWriter().println("<script>alert('插件更新失败')</script>");
            response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-change.jsp'</script>");
        }
    }

    /**
     * 查看所有插件方法
     *
     * @param response 形参
     * @throws IOException            流异常
     * @throws ClassNotFoundException 类空异常
     */
    public void showAll(HttpServletResponse response) throws IOException, ClassNotFoundException {
        List<plugin> plugins = new PluginServiceImpl().showAll();
        this.getServletContext().setAttribute("plugins", plugins);
        response.getWriter().println("<script>window.location.href='/PMS_war_exploded/pages/plugin-showAll.jsp'</script>");
    }
}
