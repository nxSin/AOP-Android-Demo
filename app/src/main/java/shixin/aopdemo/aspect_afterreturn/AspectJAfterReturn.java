package shixin.aopdemo.aspect_afterreturn;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * afterreturn
 */
@Aspect
public class AspectJAfterReturn {
    private static final String TAG = AspectJAfterReturn.class.getSimpleName();

    /**
     * 切入方法
     */
    @Pointcut("call(* shixin.aopdemo.aspect_afterreturn.AfterReturnTestHelper.aspectjTest(..))")
    public void callWith() {
    }

    /**
     * 使用AfterReturning
     * @param jp JoinPoint，可获取方法、类、参数等信息(这个参数不是AfterReturning特有，不用关心)
     * @param ret 返回值 AfterReturning特有,注意注解中的参数名称与方法中的名称要一样，比如这里的ret
     */
    @AfterReturning(returning = "ret",  pointcut = "callWith()")
    public void testCallAft(JoinPoint jp, Object ret) {
        //打印返回值
        Log.d(TAG, "AspectJAftwerReturn after,return:" + ret);
        Log.i(TAG, "AspectJAftwerReturn after,args:" + Arrays.toString(jp.getArgs()));
    }

    @Before("callWith()")
    public void testCallBef() {
        Log.d(TAG, "AspectJAftwerReturn before");
    }
}
