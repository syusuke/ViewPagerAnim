package com.gson8.adviewpager.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.adviewpager.vpanim.RotateDownPageTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class TabletTransformer implements ViewPager.PageTransformer
{
    private static float mDegee = 30;
    private static float mAlpha = 0.5f;

    @Override
    public void transformPage(View page, float position)
    {
        if(position < -1)
        {
            page.setRotationY(mDegee);
            page.setAlpha(1);
        }
        else if(position <= 1)
        {
            if(position < 0)
            {
                page.setTranslationX((page.getWidth() * 0.5f) * position);
                page.setPivotX(page.getWidth() / 2.0f);
                page.setPivotY(page.getHeight() / 2.0f);
                page.setRotationY(mDegee * -position);
                page.setAlpha(mAlpha + (1 - mAlpha) * (1 + position));

            }
            else
            {
                page.setTranslationX((page.getWidth() * 0.5f) * -position);
                page.setPivotX(page.getWidth() / 2.0f);
                page.setPivotY(page.getHeight() / 2.0f);
                page.setRotationY(mDegee * -position);
                page.setAlpha(mAlpha + (1 - mAlpha) * (1 - position));
            }
        }
        else
        {
            page.setRotationY(-mDegee);
            page.setAlpha(1);
        }
    }
}
