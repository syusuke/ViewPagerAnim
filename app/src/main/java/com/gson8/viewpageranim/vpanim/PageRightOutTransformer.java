package com.gson8.viewpageranim.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.viewpageranim.vpanim.PageRightOutTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class PageRightOutTransformer implements ViewPager.PageTransformer
{
    private static final float SCALE = 0.5f;

    @Override
    public void transformPage(View page, float position)
    {

        float width = page.getWidth();
        float height = page.getHeight();

        if(position < -1)
        {
            setCommonScale(page, 1f);
        }
        else if(position <= 1)
        {
            if(position < 0)
            {
                setCommonScale(page, 1);
                page.setTranslationX(width * position * SCALE);
            }
            else
            {
                page.setPivotX(width * SCALE / 2.0f);
                page.setPivotY(height * SCALE);
                setCommonScale(page, position < SCALE ? (1 - position) : SCALE);
            }
        }
        else
        {
            setCommonScale(page, 1f);
        }
    }

    public void setCommonScale(View page, float f)
    {
        page.setScaleX(f);
        page.setScaleY(f);
    }
}
