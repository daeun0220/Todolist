package com.example.todolist.interceptor;

import com.example.todolist.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        // String accessToken = req.getHeader("Authorization");
        // if (accessToken == null) {
        // 	throw new IllegalArgumentException("토큰을 찾을 수 없습니다.");
        // }

        String accessToken = Optional.ofNullable(req.getHeader("Authorization"))
                .orElseThrow(() -> new IllegalArgumentException("토큰을 찾을 수 없습니다."));
        String parsedAccessToken = accessToken.substring("Bearer ".length());

        try {
            boolean result = authService.validAccessToken(parsedAccessToken);
            if (!result) {
                throw new IllegalArgumentException("잘못된 토큰입니다.");
            }
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("잘못된 토큰입니다.", ex);
        }

        return HandlerInterceptor.super.preHandle(req, res, handler);
    }

}
