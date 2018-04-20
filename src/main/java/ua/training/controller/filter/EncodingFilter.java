/*
 * EncodingFilter
 *
 * Description: This filter is a part of the Knight web app.
 *
 * By: Alyona Korzhakova
 *
 * Created: 2018/04/10
 *
 * Updated: 2018/04/20
 */
package ua.training.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

        private String encoding;

        public void init(FilterConfig fConfig) {

            encoding = fConfig.getInitParameter("encoding");
        }

        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            String codeRequest = request.getCharacterEncoding();

            if (encoding != null && !encoding.equalsIgnoreCase(codeRequest)) {
                request.setCharacterEncoding(encoding);
                response.setCharacterEncoding(encoding);
            }
            chain.doFilter(request, response);
        }

        public void destroy() {
            encoding = null;
        }
}
