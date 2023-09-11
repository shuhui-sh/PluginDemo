package com.netease.pluginhookandroid9;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.view.ContextThemeWrapper;

public class PluginContext extends ContextThemeWrapper {

    private final DexElementFuse dexElementFuse;

    public PluginContext(Context base, DexElementFuse dexElementFuse) {
        super(base, 2114715920);
        this.dexElementFuse = dexElementFuse;
    }

    @Override
    public Resources getResources() {
        return this.dexElementFuse.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return this.dexElementFuse.getAssets();
    }

    @Override
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.dexElementFuse.getResources().newTheme();
        theme.applyStyle(2114715920, true);
        return theme;
    }
}
