package aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectj {

    @Pointcut("execution(* aspectj.dao.*.*(..))")
    private void myPointCut() {

    }

    @Before("myPointCut()")
    public void before(JoinPoint jp) {
        System.out.print("前置通知：模拟权限控制");
        System.out.println(",目标类对象:" + jp.getTarget() + ",被增强处理的方法：" + jp.getSignature().getName());
    }

    @AfterReturning("myPointCut()")
    public void afterReturning(JoinPoint jp) {
        System.out.print("后置返回通知：模拟删除临时文件");
        System.out.println(",被增强处理的方法：" + jp.getSignature().getName());
    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕开始：执行目标方法前，模拟开启事务");
        Object obj = pjp.proceed();
        System.out.println("环绕结束：执行目标方法后，模拟关闭事务");
        return obj;
    }

    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void except(Throwable e) {
        System.out.println("异常通知：程序执行异常" + e.getMessage());
    }

    @After("myPointCut()")
    public void after() {
        System.out.println("最终通知：模拟释放资源");
    }
}
