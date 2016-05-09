package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.ScaleIOransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class ScaleIOransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(0);
        page.setPivotX(position < 0 ? 0 : page.getWidth());
        page.setPivotY(page.getHeight() / 2f);
        float scale = position < 0 ? 1f + position : 1f - position;
        page.setScaleX(scale);
        page.setScaleY(scale);

    }
}
