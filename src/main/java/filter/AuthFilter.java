package filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Instant start = Instant.now();
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpSession session = request.getSession();
            String loginURI = request.getContextPath() + "/login";

            boolean loggedIn = session.getAttribute("user") != null;
            boolean loginRequest = request.getRequestURI().equals(loginURI);

            if (loggedIn || loginRequest) {
                filterChain.doFilter(request, response);
                System.out.println("after do filter");
            } else {
                response.sendRedirect(loginURI);
            }
        } finally {
            System.out.println("finally");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}