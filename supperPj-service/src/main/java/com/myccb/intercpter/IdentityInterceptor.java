package com.myccb.intercpter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 拦截器方式（一）
 * @author 黄弋峰
 */
@Component
    public class IdentityInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdentityInterceptor.class);
    private List<String> whiteList = Arrays.asList(
            "放不拦截的链接"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        LOGGER.debug("进入拦截器IdentityInterceptor：{}", request.getServletPath());
        String servletPath = request.getServletPath().replaceFirst("/", "");
        LOGGER.debug("进入拦截器拦截的url", servletPath);
        String bestMatchingPattern = request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingPattern").toString();
        if (this.inWhiteList(servletPath, bestMatchingPattern)) {
            return true;
        }
        String token = "这里放token";
        if (token == null){
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            response.getWriter().println("xxxxx");
        }
        return true;
    }

    public boolean inWhiteList(String servletPath, String bestMatchingPattern) {
        return this.whiteList.contains(servletPath) || this.whiteList.contains(bestMatchingPattern.replaceFirst("/", ""));
    }
}
