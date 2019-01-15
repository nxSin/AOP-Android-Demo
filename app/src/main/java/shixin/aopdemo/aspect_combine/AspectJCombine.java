package shixin.aopdemo.aspect_combine;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 逻辑切入
 */
@Aspect
public class AspectJCombine {
    private static final String TAG = AspectJCombine.class.getSimpleName();

    /**
     * 切入方法aspectJ
     */
    @Pointcut("call(void shixin.aopdemo.aspect_combine.CombineHelper.aspectJ())")
    public void exeMethod() {
    }

    /**
     * !withincode  代表不是指定方法内
     */
    @Pointcut("!withincode(void shixin.aopdemo.aspect_combine.CombineHelper.test2())")
    public void notPickedOut1(){
    }

    /**
     * before 其中带 && 也就是说两个都满足才进行插入
     */
    @Before("exeMethod()&&notPickedOut1()")
    public void testExeAround() throws Throwable {
        Log.d(TAG, "testCombination before");
    }
}