package com.github.paicoding.filter;

import com.github.paicoding.forum.core.context.ReqInfoContext;
import com.github.paicoding.forum.core.util.IpUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ReqContextGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        ReqInfoContext.ReqInfo reqInfo = new ReqInfoContext.ReqInfo();
//        reqInfo.setHost(request.getHeader("host"));
//        reqInfo.setPath(request.getPathInfo());
        if (reqInfo.getPath() == null) {
//            String url = request.getRequestURI();
//            int index = url.indexOf("?");
//            if (index > 0) {
//                url = url.substring(0, index);
//            }
//            reqInfo.setPath(url);
        }
//        reqInfo.setReferer(request.getHeader("referer"));
//        reqInfo.setClientIp(IpUtil.getClientIp(request));
//        reqInfo.setUserAgent(request.getHeader("User-Agent"));
//        reqInfo.setDeviceId(getOrInitDeviceId(request, response));
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
