package shixin.aopdemo.util;

import android.content.SharedPreferences;
import android.preference.PreferenceActivity;

import shixin.aopdemo.base.APP;

public class Useful {
    /**
     * @param xmlName
     * @param key
     * @return 空 返回“none”
     */
    public static String ReadSharedPerference(String xmlName, String key) {
        SharedPreferences preferences = APP.getContext().getSharedPreferences(xmlName, PreferenceActivity.MODE_PRIVATE);
        String value = preferences.getString(key, "none");
        return value;
    }

    /**
     * 保存字段
     *
     * @param xmlName
     * @param key
     * @param value
     */
    public static void SharedPerferencesCreat(String xmlName, String key, String value) {
        SharedPreferences preferences = APP.getContext().getSharedPreferences(xmlName, PreferenceActivity.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    /**
     * 清空某一条数据
     *
     * @param xmlName
     * @param key
     */
    public static void clearSpecialPerferences(String xmlName, String key) {

        SharedPreferences preferences = APP.getContext().getSharedPreferences(xmlName, PreferenceActivity.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.remove(key);
        edit.commit();

    }

    /**
     * 清空数据
     *
     * @param xmlName
     */
    public static void clearPerfences(String xmlName) {

        SharedPreferences preferences = APP.getContext().getSharedPreferences(xmlName, PreferenceActivity.MODE_WORLD_READABLE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.clear();
        edit.commit();

    }
}
