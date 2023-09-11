package com.netease.pluginhookandroid9;

import android.app.Instrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Hooker {

    private static final String TAG = "Hooker";

    public static void hookInstrumentation(DexElementFuse dexElementFuse) throws Exception {
        Class<?> activityThread = Class.forName("android.app.ActivityThread");
        Method sCurrentActivityThread = activityThread.getDeclaredMethod("currentActivityThread");
        sCurrentActivityThread.setAccessible(true);
        //获取ActivityThread 对象
        Object activityThreadObject = sCurrentActivityThread.invoke(activityThread);

        //获取 Instrumentation 对象
        Field mInstrumentation = activityThread.getDeclaredField("mInstrumentation");
        mInstrumentation.setAccessible(true);
        Instrumentation instrumentation = (Instrumentation) mInstrumentation.get(activityThreadObject);
        MyInstrumentation customInstrumentation = new MyInstrumentation(instrumentation, dexElementFuse);
        //将我们的 customInstrumentation 设置进去
        mInstrumentation.set(activityThreadObject, customInstrumentation);
    }
}
