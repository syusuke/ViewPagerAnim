package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.adviewpager.vpanim.RotateDownPageTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class RotateDownPageTransformer implements ViewPager.PageTransformer
{
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    @Override
    public void transformPage(View page, float position)
    {
        if(position < -1)
        {
            page.setRotation(mMaxRotate * -1);
            page.setPivotX(page.getWidth());
            page.setPivotY(page.getHeight());
        }
        else if(position <= 1)
        { // [-1,1]

            if(position < 0)//[0，-1]
            {
                page.setPivotX(page.getWidth() * (0.5f + 0.5f * (-position)));
                page.setPivotY(page.getHeight());
                page.setRotation(mMaxRotate * position);
            }
            else//[1,0]
            {
                page.setPivotX(page.getWidth() * 0.5f * (1 - position));
                page.setPivotY(page.getHeight());
                page.setRotation(mMaxRotate * position);
            }
        }
        else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setRotation(mMaxRotate);
            page.setPivotX(page.getWidth() * 0);
            page.setPivotY(page.getHeight());
        }
    }
}
