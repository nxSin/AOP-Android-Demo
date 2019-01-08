package shixin.aopdemo.aspect_afterbefore;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * afterreturn切入代码
 */
@Aspect
public class AspectJAfterBefore {
    private static final String TAG = AspectJAfterBefore.class.getSimpleName();
    /**
     * 切入方法
     */
    @Pointcut("call(* shixin.aopdemo.aspect_afterbefore.AfterBeforeTestHelper.aspectjTest(..))")
    public void callWith() {
    }

    /**
     * 使用After，那么将在切入点方法执行之后执行该切入方法代码
     *
     * @param jp 切入点信息参数（如果不需要相关信息，可以不填这个参数）
     */
    @After("callWith()")
    public void testCallAft(JoinPoint jp) {
        //打印返回值
        Log.i(TAG, "AspectJAfterBefore after,args:" + Arrays.toString(jp.getArgs()));
    }

    /**
     * 使用before
     */
    @Before("callWith()")
    public void testCallBef() {
        Log.d(TAG, "AspectJAfterBefore before");
    }
}
