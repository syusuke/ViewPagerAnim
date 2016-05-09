package com.gson8.viewpageranim;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gson8.viewpageranim.vpanim.ZoomOutTranformer;
import com.gson8.viewpageranim.vpanim.DepthPageTransformer;
import com.gson8.viewpageranim.vpanim.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener
{

    private int[] mImgIds = { R.drawable.img1, R.drawable.img2, R.drawable.img4, R.drawable.img16, R.drawable.img17 };

    ViewPager mCusViewPager;

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);

        mToolbar.inflateMenu(R.menu.menu);
        mToolbar.setOnMenuItemClickListener(this);
        mCusViewPager = (ViewPager)findViewById(R.id.cus_viewpager);



        mCusViewPager.setPageTransformer(true, new ZoomOutTranformer());


        mCusViewPager.setAdapter(new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return mImgIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                ImageView iv = new ImageView(MainActivity.this);
                iv.setImageResource(mImgIds[position]);
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(iv);
                return iv;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView((View)object);
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
        int id = item.getItemId();
        switch(id)
        {
            case R.id.one:
                mCusViewPager.setPageTransformer(true, new DepthPageTransformer());
                break;
            case R.id.two:
                mCusViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                break;
        }
        return true;
    }
}
