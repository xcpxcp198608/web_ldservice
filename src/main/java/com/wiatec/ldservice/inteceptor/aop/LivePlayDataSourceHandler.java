package com.wiatec.ldservice.inteceptor.aop;

import com.wiatec.ldservice.oxm.data_source.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author patrick
 */
@Component
@Aspect
public class LivePlayDataSourceHandler {


    private final Logger logger = LoggerFactory.getLogger(LivePlayDataSourceHandler.class);

    @Pointcut("execution(public * com.wiatec.ldservice.service.liveplay.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        DataSourceHolder.setDataSources("livePlayDataSource");
        logger.debug("LivePlayDataSourceHandler");
    }

}
