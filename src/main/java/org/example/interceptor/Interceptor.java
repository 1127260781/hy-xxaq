package org.example.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    private static final String[] USER_ACCESS_PATHS = {"/course/.*"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("jwtoken");
        if (token == null) {
            response.setStatus(401);
            return false;
        }
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            if (claims == null) {
                response.setStatus(401);
                return false;
            }
            Object roleObj = claims.get("role");
            if (roleObj instanceof String) {
                String role = (String) roleObj;
                if ("admin_role".equals(role)) {
                    ThreadLocalUtil.set(claims);
                    return true;
                } else {
                    String requestURI = request.getRequestURI();
                    for (String pathRegex : USER_ACCESS_PATHS) {
                        if (requestURI.matches(pathRegex)) {
                            ThreadLocalUtil.set(claims);
                            return true;
                        }
                    }
                    response.setStatus(403);
                    return false;
                }
            } else {
                String requestURI = request.getRequestURI();
                for (String pathRegex : USER_ACCESS_PATHS) {
                    if (requestURI.matches(pathRegex)) {
                        ThreadLocalUtil.set(claims);
                        return true;
                    }
                }
                response.setStatus(403);
                return false;
            }
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}