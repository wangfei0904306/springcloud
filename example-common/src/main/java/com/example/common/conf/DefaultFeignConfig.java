package com.example.common.conf;

import com.example.common.aspect.SysContext;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import static com.example.common.constant.HeaderConstants.*;

@Configuration
@ConditionalOnClass(Feign.class)
public class DefaultFeignConfig implements RequestInterceptor {

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        String trace = MDC.get(X_TRACE);
        if(StringUtils.isNotEmpty(trace)){
            requestTemplate.header(X_TRACE, trace);
        }
        String user = SysContext.getUser();
        if(StringUtils.isNotEmpty(user)){
            requestTemplate.header(X_USER, user);
        }
        String version = SysContext.getVersion();
        if(StringUtils.isNotEmpty(version)){
            requestTemplate.header(X_VERSION, version);
        }
    }

}