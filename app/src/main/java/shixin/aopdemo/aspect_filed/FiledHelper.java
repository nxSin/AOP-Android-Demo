package shixin.aopdemo.aspect_filed;

import android.util.Log;

/**
 * Filed测试
 */
public class FiledHelper {

    private static final String TAG = FiledHelper.class.getSimpleName();

    /**
     * 姓名，String类型
     */
    private String name;
    /**
     * 年龄 int
     */
    private int age;

    public void testStart() {
        Log.d(TAG, "testStart");
        //给age赋值，那么代表了做了set
        this.age = 5;
        Log.i(TAG, "get age value:" + age);

        this.name = "小宝贝";
        //打印name，等于获取name值，代表了get
        Log.i(TAG, "get name value:" + name);
        Log.i(TAG, "testStart over");
    }
}

