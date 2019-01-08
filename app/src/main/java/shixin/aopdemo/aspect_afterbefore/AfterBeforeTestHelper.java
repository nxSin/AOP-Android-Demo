package shixin.aopdemo.aspect_afterbefore;

import android.util.Log;

/**
 * AfterBefore测试
 */
public class AfterBeforeTestHelper {

    private static final String TAG = AfterBeforeTestHelper.class.getSimpleName();

    public void testAfterBeforeOne() {
        Log.d(TAG, "testAfterBeforeOne");
        int i = aspectjTest();
        Log.i(TAG, "testAfterBeforeOne over");
    }

    /**
     * 被调用
     */
    private int aspectjTest() {
        Log.i(TAG, "exe aspectjTest");
        return 5;
    }
}

