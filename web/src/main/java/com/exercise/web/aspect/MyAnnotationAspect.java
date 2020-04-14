package com.exercise.web.aspect;

import com.exercise.web.annotation.MyAnnotation;
import com.exercise.web.model.DemoModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author : cg.Zhou
 * @date : 2020/4/14 0014 15:14
 * @Description : TODO
 * @Order 配置切面优先级，越低越先执行
 */
@Order(1)
@Aspect
@Component
public class MyAnnotationAspect {

    /**
     * 环绕通知
     * 1. 方法的返回值必须是Object
     * 2. 方法的参数必须有一个ProceedingJoinPoint
     * 3. 方法必须抛出Throwable
     * 4. 执行目标方法：proceedingJoinPoint.proceed(args)
     */
    @Around("@annotation(com.exercise.web.annotation.MyAnnotation)")
    public Object myAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{

        Object result = null;

        //获取方法上的注解
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        //获取注解中prefix的属性值
        String value = annotation.value();
        String prefix = annotation.prefix();
        System.out.println(String.format("注解的方法名: %s ,value值: %s ,prefix值: %s ",signature.getMethod().getName(),value,prefix));

        System.out.println("注解业务");

        //执行目标方法
        result = joinPoint.proceed(joinPoint.getArgs());

        return result;
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before(value="execution(public * com.exercise.web.service.DemoService.*(..))")
    public void aspectBefore(JoinPoint joinPoint){
        System.out.println("【前置通知】");
        System.out.println("切入点："+joinPoint.getSignature().getName());
        System.out.println("参数个数："+joinPoint.getArgs().length);
    }

    @After(value="execution(public * com.exercise.web.service.DemoService.*(..))")
    public void aspectAfter(JoinPoint joinPoint){
        System.out.println("【后置通知】");
    }

    /**
     * 返回通知
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value="execution(public * com.exercise.web.service.DemoService.*(..))",returning = "result")
    public Object aspectAfterReturn(JoinPoint joinPoint,Object result){
        System.out.println("【返回通知】");
        System.out.println("返回结果："+result);
        //返回结果处理
        ((DemoModel)result).setMsg("修改了返回结果");
        return result;
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value="execution(public * com.exercise.web.service.DemoService.*(..))",throwing = "exception")
    public void aspectAfterThrow(JoinPoint joinPoint,Exception exception){
        System.out.println("【异常通知】");
        System.out.println("异常对象"+exception);
    }
}
