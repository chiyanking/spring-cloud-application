package com.dagemen.ribbon.com.dagemen.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sun.security.util.SecurityConstants;

import static org.springframework.cloud.netflix.zuul.filters.support.;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return  FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.addZuulRequestHeader(SecurityConstants.USER_HEADER, authentication.getName());
            requestContext.addZuulRequestHeader(SecurityConstants.ROLE_HEADER,  CollectionUtil.join(authentication.getAuthorities(),","));

        }
        return null;
    }
}
