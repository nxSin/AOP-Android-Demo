package shixin.aopdemo.logh;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * 日志插入
 *
 * @author shixin
 * @date 20181226
 */
@Aspect
public class LogAspect {
    /*下面是使用注解自定义方式*/
    @Pointcut("execution(@shixin.aopdemo.logh.AnnoExeTimeLogAspect * *(..))")
    public void testExeMethodTime() {
    }

    @Around("testExeMethodTime()")
    public void timeEva(ProceedingJoinPoint joinPoint) throws Throwable {
        long timeBefore = SystemClock.currentThreadTimeMillis();
        Object[] args = joinPoint.getArgs();
        /*分带参数执行和无参数执行*/
        if (args != null && args.length > 0) {
            Log.d("timeEva", "have args:" + Arrays.toString(args));
            joinPoint.proceed(args);
        } else {
            Log.d("timeEva", "have no args");
            joinPoint.proceed();
        }
        long timeAfter = SystemClock.currentThreadTimeMillis();
        long time = timeAfter - timeBefore;
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalStateException("LoginFilter 注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Log.i(methodSignature.getDeclaringType().getSimpleName(), joinPoint.getSignature().getName() + "，花费时间:" + time);
    }
}
