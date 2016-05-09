package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.HorizontalFilpTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class HorizontalFilpTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        page.setTranslationX(page.getWidth() * -position);
        page.setTranslationY(0);
        final float rotation = 180f * position;

        page.setAlpha(rotation > 90f || rotation < -90f ? 0 : 1);
        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(rotation);


    }
}
