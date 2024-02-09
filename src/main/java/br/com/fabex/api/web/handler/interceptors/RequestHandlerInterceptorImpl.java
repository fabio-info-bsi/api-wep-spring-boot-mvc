package br.com.fabex.api.web.handler.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

public class RequestHandlerInterceptorImpl implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) {
        String traceId = request.getHeader("traceid");
        MDC.put("traceId", traceId);
        return true;
    }
}
