package com.leno.config;

import com.leno.common.NoAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XianGuo
 * Date: 2017-10-12 17:13
 */
@Slf4j
public class DomoIntercept extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.error("拦截成功！",request.getServerName());
        if (!(handler instanceof HandlerMethod)) return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NoAuth noAuth = handlerMethod.getMethodAnnotation(NoAuth.class);
        if (noAuth != null) return true;
        // TODO: 12/10/17 需要登录

        return super.preHandle(request, response, handler);

    }
}
