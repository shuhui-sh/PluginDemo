package com.netease.pluginhookandroid9;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

public class MyInstrumentation extends Instrumentation {


    private final DexElementFuse dexElementFuse;
    private Instrumentation base;

    public MyInstrumentation(Instrumentation base, DexElementFuse dexElementFuse) {
        this.base = base;
        this.dexElementFuse = dexElementFuse;
    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        resetThemeId(activity);
        super.callActivityOnCreate(activity, icicle);
    }

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle, PersistableBundle persistentState) {
        resetThemeId(activity);
        super.callActivityOnCreate(activity, icicle, persistentState);
    }

    private void resetThemeId(Activity activity) {
        try {
            if (activity.getClass().getName().equals("com.netease.pluginhookandroid9.PluginLoginActivity")) {
//            activity.getTheme().applyStyle(2131493136, true);
                activity.setTheme(2114715920);
                Context base = activity.getBaseContext();
                Reflector.with(base).field("mResources").set(dexElementFuse.getResources());
                Reflector reflector = Reflector.with(activity);
                reflector.field("mBase").set(new PluginContext(activity.getBaseContext(), dexElementFuse));
                reflector.field("mResources").set(dexElementFuse.getResources());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
