package org.charlie.template.framework.interceptors.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.charlie.template.framework.constants.TemplateConstants;
import org.charlie.template.framework.utils.bean.Session;
import org.charlie.template.framework.utils.bean.SessionContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class GlobalTraceIdRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        Session session = SessionContext.getSession();
        if (Objects.nonNull(session)) {
            String globalTraceId = session.getGlobalTraceId();
            if (Objects.nonNull(globalTraceId)) {
                template.header(TemplateConstants.TRACE_ID_HEADER_KEY, globalTraceId);
            }
        }
    }
}