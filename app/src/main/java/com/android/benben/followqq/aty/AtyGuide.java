package com.android.benben.followqq.aty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.benben.followqq.R;
import com.android.benben.followqq.adapter.AdapterGuideViewPager;
import com.android.benben.followqq.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Time      2017/6/2 18:15 .
 * Author   : LiYuanXiong.
 * Content  :引导页面
 */

public class AtyGuide extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private AdapterGuideViewPager adapterGuideViewPager;
    private List<View> viewList;
    private ImageView imageView[] = new ImageView[3];
    private int[] indicatorDotIds = {R.id.iv_indicator_dot1, R.id.iv_indicator_dot2, R.id.iv_indicator_dot3};
    private Button btnToMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page1, null));
        viewList.add(inflater.inflate(R.layout.guide_page2, null));
        viewList.add(inflater.inflate(R.layout.guide_page3, null));

        for (int i = 0; i < indicatorDotIds.length; i++) {
            imageView[i] = (ImageView) findViewById(indicatorDotIds[i]);
        }
        adapterGuideViewPager = new AdapterGuideViewPager(this, viewList);

        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);

        btnToMain = (Button) (viewList.get(2)).findViewById(R.id.btn_to_main);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AtyGuide.this, AtyLoginOrRegister.class));
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 改变页面的指示器
     *
     * @param position id
     */
    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < indicatorDotIds.length; i++) {
            if (i != position) {
                imageView[i].setImageResource(R.drawable.unselected);
            } else {
                imageView[i].setImageResource(R.drawable.selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
