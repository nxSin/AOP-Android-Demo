package shixin.aopdemo.aspect_around;

import android.util.Log;

/**
 * Around测试
 */
public class AroundTestHelper {

    private static final String TAG = AroundTestHelper.class.getSimpleName();

    public void testAroundOne() {
        Log.d(TAG, "testStart");
        aspectjTest();
        Log.i(TAG, "testStart over");
    }
    /**
     * 被调用
     */
    private void aspectjTest() {
        Log.d(TAG, "aspectjTest");
    }
}

