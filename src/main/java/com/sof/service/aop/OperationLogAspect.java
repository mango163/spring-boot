/**
 * 
 */
package com.sof.service.aop;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Aaron
 *在@Before中优先执行@Order(5)的内容，再执行@Order(10)的内容
 *在@After和@AfterReturning中优先执行@Order(10)的内容，再执行@Order(5)的内容
 *在切入点前的操作，按order的值由小到大执行
 *在切入点后的操作，按order的值由大到小执行
 */
@Aspect
@Order(5)
@Component
public class OperationLogAspect {
	
	private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.sof.service.controller..*.*(..))")
    public void operationLog(){}

    @Before("operationLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
