package shixin.aopdemo.aspect_filed;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Field切入
 */
@Aspect
public class AspectJFiled {
    private static final String TAG = AspectJFiled.class.getSimpleName();

    /**
     * 切入方法
     */
    @Pointcut("get(String shixin.aopdemo.aspect_filed.FiledHelper.name)")
    public void getMethod() {
    }

    @Pointcut("set(int shixin.aopdemo.aspect_filed.FiledHelper.age)")
    public void setMethod() {
    }

    @Around("getMethod()")
    public String testGetAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.d(TAG, "testGetAround before");
        //采用proceed来调用方法的执行,得到返回String的字段
        String proceedStr = (String) proceedingJoinPoint.proceed();
        //修改返回字段
        String returnStr = proceedStr + "老大";
        Log.d(TAG, "testGetAround after");
        return returnStr;
    }

    @Around("setMethod()")
    public void testSetAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Log.d(TAG, "testSetAround before");
        //采用getArgs方法获取设置的参数String的字段
        Integer argsAge = (Integer) proceedingJoinPoint.getArgs()[0];
        //修改设置字段,将年龄改小两岁
        int modifyAge = argsAge - 2;
        proceedingJoinPoint.proceed(new Integer[]{modifyAge});
        Log.d(TAG, "testSetAround after");
    }
}