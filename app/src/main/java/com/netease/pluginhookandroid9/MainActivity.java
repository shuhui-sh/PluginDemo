package com.netease.pluginhookandroid9;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Time: 2019-08-10
 * Author: Liudeli
 * Description: 宿主主Activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * 宿主启动[插件]中的PluginLoginActivity
     * @param view
     */
    public void startPluginLoginActivity(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.netease.pluginhookandroid9", "com.netease.pluginhookandroid9.PluginLoginActivity"));
//        startActivity(new Intent(this, PluginLoginActivity.class));
        startActivity(intent);
    }
}
