package shixin.aopdemo.aspect_within;

import android.util.Log;

/**
 * 合并测试
 */
public class WithInTestHelper {

    private static final String TAG = WithInTestHelper.class.getSimpleName();

    public void testWithinOne() {
        Log.d(TAG, "testWithinOne");
        aspectjTest(3);
        aspectjTest2(3);
    }

    /**
     * 被调用
     */
    public void aspectjTest(int i) {
        if (i > 0) {
            Log.d(TAG, "aspectjTest,i:" + i);
            aspectjTest(--i);
        }
    }

    /**
     * 被调用2
     */
    public void aspectjTest2(int i) {
        if (i > 0) {
            Log.d(TAG, "aspectjTest,i:" + i);
            aspectjTest2(--i);
        }
    }
}

