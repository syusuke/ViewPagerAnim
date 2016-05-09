package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.SqueezeTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class SqueezeTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        if(position < -1)
        {
            page.setPivotX(0);
            page.setScaleX(0);
        }
        else if(position <= 1)
        {
            if(position < 0)
            {
                page.setPivotX(page.getWidth());
                page.setScaleX(1f + position);
            }
            else
            {
                page.setPivotX(0);
                page.setScaleX(1f - position);
            }
        }
        else
        {
            page.setPivotX(page.getWidth());
            page.setScaleX(1);
        }
    }

}
