package shixin.aopdemo.aspect_handle_exception;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.IOException;

/**
 * 异常切入
 */
@Aspect
public class AspectJException {
    private static final String TAG = AspectJException.class.getSimpleName();

    /**
     * 异常产生之后插入
     * handler方式，指定IO异常，并获取参数ex
     */
    @Before(value = "handler(java.io.IOException+) && args(ex)")
    public void testHandleBefore(IOException ex) throws Throwable {
        Log.d(TAG, "testHandleBefore before");
        Log.d(TAG, "出现io异常:" + ex);
        //打印栈信息
        ex.printStackTrace();
        //还可以统一写入文件等
    }

}