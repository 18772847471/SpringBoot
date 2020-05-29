package com.example.aop.aspect;

import com.example.aop.annotation.SystemControllerLog;
import com.example.aop.annotation.SystemServiceLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {
    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    //Controller层切点
    @Pointcut("@annotation(com.example.aop.annotation.SystemControllerLog)")
    public void controllerAspect(){
        System.out.println("Controller层切点");
    }

    //Service层切点
    @Pointcut("@annotation(com.example.aop.annotation.SystemServiceLog)")
    public void serviceAspect(){
        System.out.println("Service层切点");
    }



    /**
     * @Description  前置通知
     * @date 2018年9月3日 10:38
     */

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        try {
            //*========控制台输出=========*//
            System.out.println("==============前置通知开始==============");
        }catch (Exception e){
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息：{}",e.getMessage());
        }
    }

    /**
     * @Description  后置通知
     * @date 2018年9月3日 10:38
     */

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint){
        try {
            //*========控制台输出=========*//
            System.out.println("==============后置通知开始==============");
        }catch (Exception e){
            //记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息：{}",e.getMessage());
        }
    }

    /**
     * @Description  环绕
     * @date 2018年9月3日 10:38
     */

    @Around("controllerAspect()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try {
            //*========控制台输出=========*//
            System.out.println("==============Around通知开始==============");
            proceedingJoinPoint.proceed();
            System.out.println("==============Around通知结束==============");
        }catch (Exception e){
            //记录本地异常日志
            logger.error("==环绕通知异常==");
            logger.error("异常信息：{}",e.getMessage());
        }
    }

    /**
     * @Description  异常通知 用于拦截service层记录异常日志
     * @date 2018年9月3日 下午5:43
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable e){
        try{
            /*========控制台输出=========*/
            System.out.println("=====异常通知开始=====");
        }catch (Exception ex){
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
    }

    /**
     * @Description  获取注解中对方法的描述信息 用于Controller层注解
     * @date 2018年9月3日 上午12:01
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();//目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


    /**
     * @Description  获取注解中对方法的描述信息 用于service层注解
     * @date 2018年9月3日 下午5:05
     */
    public static String getServiceMethodDescription(JoinPoint joinPoint)throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods) {
            if (method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
