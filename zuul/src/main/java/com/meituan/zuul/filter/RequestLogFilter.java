package com.meituan.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class RequestLogFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send [{}] request to [{}]", request.getMethod(), request.getRequestURL().toString());
        return null;
    }

}
