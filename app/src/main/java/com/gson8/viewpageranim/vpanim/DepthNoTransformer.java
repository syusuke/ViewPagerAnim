package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.DepthPageTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthNoTransformer implements ViewPager.PageTransformer
{
    private float mScale = 1f;

    @Override
    public void transformPage(View page, float position)
    {
        if(position <= 0)
        {
            page.setTranslationX(0);

        }
        else if(position <= 1)
        {
            page.setTranslationX(page.getWidth() * -position);
        }


    }
}
