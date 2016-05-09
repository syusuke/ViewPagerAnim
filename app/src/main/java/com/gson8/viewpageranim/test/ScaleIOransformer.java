package com.gson8.viewpageranim.test;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.test.ScaleIOransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class ScaleIOransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        if(position < -1)
        {
            page.setScaleX(0);
            page.setScaleY(0);
        }
        else if(position <= 1)
        {
            if(position < 0)
            {
                page.setPivotX(0);
                page.setPivotY(page.getHeight() * 0.5f);
                float scale = position + 1f;
                page.setScaleX(scale);
                page.setScaleY(scale);
            }
            else
            {
                page.setPivotX(page.getWidth());
                page.setPivotY(page.getHeight() * 0.5f);
                float scale = 1f - position;
                page.setScaleX(scale);
                page.setScaleY(scale);
            }
        }
        else
        {
            page.setScaleX(0);
            page.setScaleY(0);
        }

    }
}
