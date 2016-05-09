package com.gson8.adviewpager.vpanim;

/*
 * ViewPagerAnim making by Syusuke/琴声悠扬 on 2016/5/9
 * E-Mail: Zyj7810@126.com
 * Package: com.gson8.adviewpager.vpanim.AlphaPageTransformer
 * Description: null
 */

import android.support.v4.view.ViewPager;
import android.view.View;

public class AlphaPageTransformer implements ViewPager.PageTransformer
{
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha = DEFAULT_MIN_ALPHA;

    @Override
    public void transformPage(View page, float position)
    {

        if(position < -1)
        {
            //左边页面停下来执行
            page.setAlpha(mMinAlpha);
        }
        else if(position <= 1)
        { // [-1,1]

            if(position < 0) //[0，-1]   原来中间的页面到左边时执行
            {
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 + position);
                page.setAlpha(factor);
            }
            else//[1，0]     原来右边的页面到中间
            {
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 - position);
                page.setAlpha(factor);
            }
        }
        else
        { // (1,+Infinity]  右边页面停下时执行
            page.setAlpha(mMinAlpha);
        }

    }
}
