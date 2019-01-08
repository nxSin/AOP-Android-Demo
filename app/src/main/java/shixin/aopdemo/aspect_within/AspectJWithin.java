package shixin.aopdemo.aspect_within;

import android.util.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJWithin {
    private static final String TAG = AspectJWithin.class.getSimpleName();

    /**
     * 切入方法
     */
    @Pointcut("call(* shixin.aopdemo.aspect_within.WithInTestHelper.*(..))")
    public void callWith() {
    }

    @After("callWith()")
    public void testCallAft() {
        Log.d(TAG, "testCall after");
    }

    @Before("callWith()")
    public void testCallBef() {
        Log.d(TAG, "testCall before");
    }
}
