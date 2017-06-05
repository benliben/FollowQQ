package com.android.benben.followqq.aty;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.android.benben.followqq.base.BaseActivity;
import com.android.benben.followqq.R;

/**
 * Time      2017/6/2 18:14 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class AtyWelcome extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initLoad() {
        SharedPreferences sharedPreferences = getSharedPreferences("zzchat", MODE_PRIVATE);
    }
}
