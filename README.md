# ViewPager Transformer
> - ps:`Transformer`接口是Android 3.0后推出的.如果要兼容3.0以下的.可以看一下 [JazzyViewPager](https://github.com/jfeinstein10/JazzyViewPager)
> - 写这个的目录,一方面学习.二方面,不想自定义控件.可以把`com.gson8.viewpageranim.vpanim`包下的某个Transformer文件复制到项目就可以用了

**所有的东西都是在`app Module下`**

```
 mCusViewPager.setPageTransformer(true, new DefaultTransfomer());
```

## 1.app
![](app/vp1.gif)

## 主要参考资料
- http://developer.android.com/training/animation/screen-slide.html
- http://blog.csdn.net/lmj623565791/article/details/40411921/
- http://blog.csdn.net/lmj623565791/article/details/51339751