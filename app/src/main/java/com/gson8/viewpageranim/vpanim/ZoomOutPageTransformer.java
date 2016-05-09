package com.gson8.viewpageranim.vpanim;

import android.support.v4.view.ViewPager;
import android.view.View;


/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.ZoomInOutTransformer
 * Description: google官方DEMO
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer
{
    private float mScale = 0.85f;
    private float mAlaha = 0.5f;

    public ZoomOutPageTransformer(){}

    public ZoomOutPageTransformer(float scale, float alpha)
    {
        this.mScale = scale;
        this.mAlaha = alpha;
    }

    public float getScale()
    {
        return mScale;
    }

    public void setScale(float mScale)
    {
        this.mScale = mScale;
    }

    public float getAlaha()
    {
        return mAlaha;
    }

    public void setAlaha(float mAlaha)
    {
        this.mAlaha = mAlaha;
    }

    public void transformPage(View view, float position)
    {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if(position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);
        }
        else if(position <= 1)
        { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(mScale, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if(position < 0)
            {
                view.setTranslationX(horzMargin - vertMargin / 2);
            }
            else
            {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between mScale and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(mAlaha + (scaleFactor - mScale) / (1 - mScale) * (1 - mAlaha));

        }
        else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}