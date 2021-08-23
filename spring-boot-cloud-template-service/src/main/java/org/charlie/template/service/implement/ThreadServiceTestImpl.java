package org.charlie.template.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.charlie.template.framework.utils.bean.SessionContext;
import org.charlie.template.framework.utils.thread.ThreadUtil;
import org.charlie.template.service.ThreadServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ThreadServiceTestImpl implements ThreadServiceTest {

    ThreadUtil threadUtil;

    @Autowired
    public void setThreadUtil(ThreadUtil threadUtil) {
        this.threadUtil = threadUtil;
    }

    @Override
    public void childThreadLog() {
        threadUtil.execute(() -> log.debug("Just test trace id."));
        threadUtil.execute(() -> log.debug("Session trace id:" + SessionContext.getSession().getGlobalTraceId()));
    }
}
