package shixin.aopdemo.aspect_around;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * around
 */
@Aspect
public class AspectJAround {
    private static final String TAG = AspectJAround.class.getSimpleName();
    /**
     * 切入方法
     */
    @Pointcut("call(* shixin.aopdemo.aspect_around.AroundTestHelper.aspectjTest(..))")
    public void callWith() {
    }
    @Around("callWith()")
    public void testCallAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.d(TAG, "testCallAround before");
        //采用proceed来调用方法的执行
        proceedingJoinPoint.proceed();

        //如果方法是有参数的话，可以采用调用参数方式来执行
//        Object[] args = proceedingJoinPoint.getArgs();
//        proceedingJoinPoint.proceed(args);
        Log.d(TAG, "testCallAround after");
    }
}
