package shixin.aopdemo.aspect_combine;

import android.util.Log;

/**
 * Combine测试
 */
public class CombineHelper {

    private static final String TAG = CombineHelper.class.getSimpleName();

    public void testStart() {
        Log.d(TAG, "testStart");
        test1();
        test2();
        Log.i(TAG, "testStart over");
    }

    /**
     * 测试方法1，调用aspectJ()
     */
    private void test1() {
        Log.d(TAG, "test1");
        aspectJ();
    }

    /**
     * 测试方法2，调用aspectJ()
     */
    private void test2() {
        Log.d(TAG, "test2");
        aspectJ();
    }

    /**
     * 被切入的方法
     */
    private void aspectJ() {
        Log.d(TAG, "conbineNotPickedOut2");
    }
}

