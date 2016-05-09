package com.gson8.viewpageranim.test;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.test.VerticalFlipTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class VerticalFlipTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position)
    {
        final float rotation = -180f * position;

        page.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);

        Log.e("tass", "transformPage: " + page.getWidth() + "  " + page.getHeight() + rotation);

        page.setRotationX(rotation);
    }
}
