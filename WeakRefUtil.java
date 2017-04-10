package com.example.wangjing.zxingscan;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * 在Activity之间传递一次性数据用的工具类
 * <p>
 * Created by wangjing on 2017/3/5.
 */

public class WeakRefUtil {
    private static Map<String, Object> map = new HashMap<>();

    public static void put(String key, Object obj) {
        map.put(key, obj);
        Log.d("WeakRefUtil","WeakReference put - " + key + "  " + obj);
        if (map.size() > 10) {
            throw new IllegalStateException();
        }
    }

    public static <T> T get(String key) {
        Object value = map.remove(key);
        Log.d("WeakRefUtil","WeakReference put - " + key + "  " + value);
        if (value == null)
            return null;
        return (T) value;
    }

    public static int size() {
        return map.size();
    }
}
