package com.gson8.adviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gson8.adviewpager.vpanim.TabletTransformer;

public class MainActivity extends AppCompatActivity
{

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    private int[] mImgIds = { R.drawable.img3, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img11, R.drawable.img12, R.drawable.img14 };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager)findViewById(R.id.id_viewpager);
        mViewPager.setPageTransformer(true, new TabletTransformer());
        //设置Page间间距,两个页面之相距多少
        mViewPager.setPageMargin(30);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(mAdapter = new PagerAdapter()
        {
            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                ImageView view = new ImageView(MainActivity.this);
                //                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setImageResource(mImgIds[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View)object);
            }

            @Override
            public int getCount()
            {
                return mImgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o)
            {
                return view == o;
            }
        });

    }
}
