package sym.inspur.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * 设置字符编码集过滤器
 *
 * @author why
 */
public class CharacterEncodingFilter implements Filter {
    private String encoding = null;

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            servletRequest.setCharacterEncoding(encoding);
            servletResponse.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //初始化
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }
}
