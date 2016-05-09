package com.gson8.viewpageranim.test;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.test.HorizontalFilpTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class HorizontalFilpTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        float rataion = 180f * position;
        page.setRotationX(0);
        page.setRotationY(0);
        page.setRotation(0);
        page.setScaleX(1);
        page.setScaleY(1);
        page.setPivotX(0);
        page.setPivotY(0);
        page.setTranslationY(0);
        page.setEnabled(false);
        if(position < -1)
        {
        }
        else if(position <= 1)
        {
            if(position < 0)
            {
                page.setPivotX(page.getWidth() * 0.5f);
                page.setPivotY(page.getHeight() * 0.5f);
                page.setRotationY(rataion);
            }
            else
            {
                page.setPivotX(page.getWidth() * 0.5f);
                page.setPivotY(page.getHeight() * 0.5f);
                page.setRotationY(rataion);
            }
        }
        else
        {
        }


    }
}
