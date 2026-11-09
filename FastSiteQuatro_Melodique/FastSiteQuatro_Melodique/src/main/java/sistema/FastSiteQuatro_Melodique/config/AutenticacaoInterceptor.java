//package sistema.FastSiteQuatro_Melodique.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import java.io.IOException;
//
//public class AutenticacaoInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws IOException {
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute(LoginCliente.SESSAO_CLIENTE) != null) {
//            return true;
//        }
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"erro\":\"Sessão expirada. Faça login novamente.\"}");
//        return false;
//    }
//}
