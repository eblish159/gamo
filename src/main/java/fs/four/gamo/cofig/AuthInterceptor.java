package fs.four.gamo.cofig;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        if (uri.equals("/login") || uri.startsWith("/css") || uri.startsWith("/js") || uri.startsWith("/img")) {
            return true;
        }

        Object user = request.getSession().getAttribute("loginVO");
        if (user == null) {
            response.sendRedirect("/login");  // 로그인 안 된 경우 /login 페이지로 리디렉션
            return false;
        }
        return true;
    }
}
