package com.moxi.mogublog.admin.annotion.TimeCalculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 方法时间统计, 切面实现
 *
 * @author: zWX1038562
 * @create: 2021-05-30 16:40
 **/
@Aspect
@Component
@Slf4j
public class TimeCalculatorAspect {

    @Pointcut(value = "@annotation(timeCalculator)")
    public void pointcut(TimeCalculator timeCalculator) {
        System.out.println("2021年5月30日17:06:37");
    }

    @Around(value = "pointcut(timeCalculator)")
    public Object around(ProceedingJoinPoint pjp, TimeCalculator timeCalculator) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object obj = pjp.proceed(pjp.getArgs());
        stopWatch.stop();
        long cost = stopWatch.getTotalTimeMillis();
        if(cost > 10) {
            MethodSignature signature = (MethodSignature) pjp.getSignature();
            String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
            System.out.println("----------- 执行" + methodName + "方法, 用时: " + cost + "ms -----------");
        }
        return obj;
    }

}
