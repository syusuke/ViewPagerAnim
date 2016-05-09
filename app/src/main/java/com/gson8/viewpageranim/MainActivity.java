package com.gson8.viewpageranim;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.gson8.viewpageranim.vpanim.DefaultTransfomer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private int[] mImgIds = { R.drawable.img1, R.drawable.img2, R.drawable.img4, R.drawable.img16, R.drawable.img17 };

    ViewPager mCusViewPager;
    VpAdapter mAdatper;
    Toolbar mToolbar;
    List<String> mTransList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(this);

        mCusViewPager = (ViewPager)findViewById(R.id.cus_viewpager);

        mCusViewPager.setPageTransformer(true, new DefaultTransfomer());

        mTransList = new ArrayList<>();

        mAdatper = new VpAdapter();
        mCusViewPager.setAdapter(mAdatper);

        initData();

    }

    private void initData()
    {
        mTransList.add("CubeTransformer");
        mTransList.add("DefaultTransfomer");
        mTransList.add("DepthNoTransformer");
        mTransList.add("DepthPageTransformer");
        mTransList.add("HorizontalFilpTransformer");
        mTransList.add("PageLeftInTransformer");
        mTransList.add("PageRightOutTransformer");
        mTransList.add("RotateDownPageTransformer");
        mTransList.add("RotateUpPageTransformer");
        mTransList.add("ScaleIOransformer");
        mTransList.add("SqueezeTransformer");
        mTransList.add("TabletTransformer");
        mTransList.add("VerticalFlipTransformer");
        mTransList.add("ZoomInOutTransformer");
        mTransList.add("ZoomOutPageTransformer");
        mTransList.add("ZoomOutTranformer");
    }


    @Override
    public void onClick(View v)
    {
        showDia();
    }

    private void showDia()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ListView lv = new ListView(this);
        builder.setTitle("ViewPager的滑动效果");
        builder.setView(lv).setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTransList),
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        setViewPagerTransformer(which);
                        dialog.dismiss();
                    }
                });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        builder.create().show();
    }

    public void setViewPagerTransformer(int viewPagerTransformer)
    {
        try
        {
            mCusViewPager.setPageTransformer(true, (ViewPager.PageTransformer)Class.forName(
                    "com.gson8.viewpageranim.vpanim." + mTransList.get(viewPagerTransformer))
                    .newInstance());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    class VpAdapter extends PagerAdapter
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
    }

}
