package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.ZoomOutTranformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class ZoomOutTranformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(0);

        float scale = 1f + Math.abs(position);
        page.setScaleX(scale);
        page.setScaleY(scale);
        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);

        if(position < -1.0f || position > 1.0f)
            page.setAlpha(0f);
        else
            page.setAlpha(1.0f - (scale - 1.0f));

        if(position == -1)
        {
            page.setTranslationX(page.getWidth() * -1);
        }
    }
}
