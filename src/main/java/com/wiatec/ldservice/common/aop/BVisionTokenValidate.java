package com.wiatec.ldservice.common.aop;

import com.wiatec.ldservice.common.result.EnumResult;
import com.wiatec.ldservice.common.result.XException;
import com.wiatec.ldservice.common.utils.AESUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.xa.XAException;

/**
 * @author patrick
 */
@Aspect
@Component
public class BVisionTokenValidate {

    private final Logger logger = LoggerFactory.getLogger(BVisionTokenValidate.class);

    @Pointcut("execution(public * com.wiatec.ldservice.api.BVision.*(..))")
    public void httpRequestPointCut(){}

    @Before("httpRequestPointCut()")
    public void before(JoinPoint joinPoint){
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        if(parameterNames != null && parameterNames.length > 0){
            for(int i =0; i < parameterNames.length; i ++){
                if("token".equals(parameterNames[i])){
                    String token = (String) paramValues[i];
                    String mac = AESUtil.decrypt(token, AESUtil.KEY);
                    if(!mac.startsWith("5c:41:e7")){
                        throw new XException(EnumResult.ERROR_UNAUTHORIZED);
                    }
                }
            }
        }
    }

    @AfterReturning(returning = "object", pointcut = "httpRequestPointCut()")
    public void afterReturning(Object object){

    }
}
