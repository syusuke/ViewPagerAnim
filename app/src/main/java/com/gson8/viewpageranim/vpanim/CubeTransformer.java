package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.CubeTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class CubeTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        if(position < 0)
        {
            page.setPivotX(page.getWidth());
            page.setPivotY(page.getHeight() * 0.5f);
            page.setRotationY(90f * position);
        }
        else
        {
            page.setPivotX(0);
            page.setPivotY(page.getHeight() * 0.5f);
            page.setRotationY(90f * position);
        }
    }
}
