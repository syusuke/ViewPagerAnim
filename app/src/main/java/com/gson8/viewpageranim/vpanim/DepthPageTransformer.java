package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.DepthPageTransformer
 * Description: google 官方DEMO
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPageTransformer implements ViewPager.PageTransformer
{
    private float mScale = 0.75f;
    private int mPageWidth = 0;


    public DepthPageTransformer(){}

    public DepthPageTransformer(float scale)
    {
        this.mScale = scale;
    }

    public void setScale(float mScale)
    {
        this.mScale = mScale;
    }

    public float getScale()
    {
        return mScale;
    }

    @Override
    public void transformPage(View page, float position)
    {
        mPageWidth = page.getWidth();
        if(position < -1)
        {
            //// [-Infinity,-1)
            // This page is way off-screen to the left.
            // 本页面的方式关闭屏幕左侧
            page.setAlpha(0);
        }
        else if(position <= 0)
        {
            // [-1,0]
            // Use the default slide transition when moving to the left page
            // 向左移动页面时使用默认的幻灯片切换
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        }
        else if(position <= 1)
        {
            // (0,1]
            // Fade the page out.

            page.setAlpha(1 - position);
            page.setTranslationX(mPageWidth * -position);
            float scaleFactor = mScale + (1 - mScale) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
        else
        {
            //本页面的方式关闭屏幕向右
            // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }

    }
}
