package com.test.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Li xingbo
 * @date 2021-01-10 16:29
 * @Version 1.0
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser{
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serviceName = httpServletRequest.getParameter("serviceName");
        return serviceName;
    }
}