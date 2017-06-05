package com.android.benben.followqq.aty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import com.android.benben.followqq.base.BaseActivity;
import com.android.benben.followqq.R;

/**
 * Time      2017/6/2 18:14 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class AtyWelcome extends BaseActivity {
    private static final int DELAY = 2000;
    private static final int GO_GUIDE = 0;
    private static final int GO_HOME = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*全屏*/
        setContentView(R.layout.activity_welcome);
        initLoad();
    }

    /**
     * 引导界面只在首次开启时显示
     */
    private void initLoad() {
        SharedPreferences sharedPreferences = getSharedPreferences("zzchat", MODE_PRIVATE);
        boolean welcome = sharedPreferences.getBoolean("welcome", true);
        if (!welcome) {
            handler.sendEmptyMessageDelayed(GO_HOME, DELAY);
        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE, DELAY);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("welcome", false);
            editor.apply();
        }

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE: {
                    goGuide();
                    break;
                }
                case GO_HOME: {
                    goHome();
                    break;
                }
                default:
                    break;
            }
        }
    };

    private void goHome() {
        Intent intent = new Intent(this, AtyLoginOrRegister.class);
        startActivity(intent);
        finish();
    }

    private void goGuide() {
        startActivity(new Intent(this, AtyGuide.class));
        finish();
    }
}
