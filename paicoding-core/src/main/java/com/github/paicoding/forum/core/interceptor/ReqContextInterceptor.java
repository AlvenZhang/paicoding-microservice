package com.github.paicoding.forum.core.interceptor;

import com.github.paicoding.forum.core.context.ReqInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
public class ReqContextInterceptor implements HandlerInterceptor {
    @Value("")
    private String appkey;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置上下文信息
        ReqInfoContext.addReqInfo(this.createReqContext(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.error("gateway postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.error("gateway afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private ReqInfoContext.ReqInfo createReqContext(HttpServletRequest request){
        ReqInfoContext.ReqInfo reqInfo = new ReqInfoContext.ReqInfo();
        reqInfo.setAppKey(appkey);
        reqInfo.setPath(request.getRequestURI());
        reqInfo.setUserId(Long.valueOf(Optional.ofNullable(request.getHeader("user-id")).orElse("0")));
        return reqInfo;
    }
}
