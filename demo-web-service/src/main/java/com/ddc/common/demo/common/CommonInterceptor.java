package com.ddc.common.demo.common;

import com.ddc.common.demo.util.IpUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Log4j2
public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long start = System.currentTimeMillis();
        request.setAttribute("_start", start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long start = (long) request.getAttribute("_start");
        String actionName = request.getRequestURI();
        String clientIp = IpUtil.getIpAddr(request);
        StringBuilder logString = new StringBuilder();
        logString.append(clientIp).append("|").append(actionName).append("|");
        Map<String, String[]> params = request.getParameterMap();
        params.forEach((key, value) -> {
            logString.append(key);
            logString.append("=");
            for (String paramString : value) {
                logString.append(paramString);
            }
            logString.append("|");
        });
        long executionTime = System.currentTimeMillis() - start;
        logString.append("excitation=").append(executionTime).append("ms");
        log.info(logString.toString());
    }
}
