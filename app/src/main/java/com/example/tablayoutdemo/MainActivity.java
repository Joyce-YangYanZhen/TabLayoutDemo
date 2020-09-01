package com.example.tablayoutdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.iwgang.familiarrecyclerview.FamiliarRecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.search_editext)
    TextView search_editext;
    @BindView(R.id.search_btn)
    LinearLayout search_btn;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.banner_center)
    Banner banner_center;
    @BindView(R.id.mRecyclerView)
    FamiliarRecyclerView mRecyclerView;
    @BindView(R.id.tabLayout)
    TabLayout tab_layout;
    @BindView(R.id.viewPager)
    ViewPager myViewPager;
    @BindView(R.id.saoma_btn)
    ImageView saoma_btn;
    @BindView(R.id.leiji_btn)
    ImageView leiji_btn;
    @BindView(R.id.message_btn)
    ImageView message_btn;
    @BindView(R.id.guofengyuncui_btn)
    LinearLayout guofengyuncui_btn;
    @BindView(R.id.xinpin_btn)
    LinearLayout xinpin_btn;
    @BindView(R.id.xinrentehui_btn)
    LinearLayout xinrentehui_btn;
    @BindView(R.id.sales_volume)
    ImageView sales_volume;
    @BindView(R.id.new_product)
    ImageView new_product;
    @BindView(R.id.sales_volume2)
    ImageView sales_volume2;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        get_ShouYe_Resource();
        search_btn.setOnClickListener(this);
        saoma_btn.setOnClickListener(this);
        message_btn.setOnClickListener(this);
        leiji_btn.setOnClickListener(this);
        guofengyuncui_btn.setOnClickListener(this);
        xinpin_btn.setOnClickListener(this);
        xinrentehui_btn.setOnClickListener(this);
        sales_volume.setOnClickListener(this);
        new_product.setOnClickListener(this);
        sales_volume2.setOnClickListener(this);

        //头部刷新
        set_head_refresh();


    }
    private void set_head_refresh() {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return true;
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset >= 0) {
                    swipe_layout.setEnabled(true);
                } else {
                    swipe_layout.setEnabled(false);
                }
            }
        });
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        get_ShouYe_Resource();
                        swipe_layout.setRefreshing(false);
                    }
                }, 2000);

            }
        });

    }

    private void get_ShouYe_Resource() {
        //设置数据源
        ShouyeBean shouyeBean = new ShouyeBean();
        ShouyeBean.SearchBean searchBean = new ShouyeBean.SearchBean();
        List<String> strings = new ArrayList<>();
        strings.add("翡翠");
        searchBean.setKeywords(strings);

        shouyeBean.setSearch(searchBean);
        List<ShouyeBean.BannersBean> bannersBeans = new ArrayList<>();
        for(int i=0;i<4;i++){
            ShouyeBean.BannersBean bannersBean = new ShouyeBean.BannersBean();
            bannersBean.setPicture("https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png");
            bannersBeans.add(bannersBean);
        }


        shouyeBean.setBanners(bannersBeans);

        List<ShouyeBean.NavsBean> navsBeans = new ArrayList<>();
        for(int i=0;i<10;i++){
            ShouyeBean.NavsBean navsBean = new ShouyeBean.NavsBean();
            navsBean.setIcon("https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png");
            navsBean.setTitle("标题"+i);
            navsBeans.add(navsBean);
        }

        shouyeBean.setNavs(navsBeans);

        ShouyeBean.AdsBean adsBean = new ShouyeBean.AdsBean();
        List<ShouyeBean.AdsBean.Col1Bean> col1Beans = new ArrayList<>();
        for(int i=0;i<4;i++){
            ShouyeBean.AdsBean.Col1Bean col1Bean = new ShouyeBean.AdsBean.Col1Bean();
            col1Bean.setPicture("https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png");
            col1Beans.add(col1Bean);
        }

        adsBean.setCol1(col1Beans);
        List<ShouyeBean.AdsBean.Col3Bean> col3Beans = new ArrayList<>();
        for (int i=0;i<4;i++){
            ShouyeBean.AdsBean.Col3Bean col3Bean = new ShouyeBean.AdsBean.Col3Bean();
            col3Bean.setPicture("https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png");
            col3Beans.add(col3Bean);
        }
        adsBean.setCol3(col3Beans);
        List<ShouyeBean.AdsBean.Col3xBean> col3xBeans = new ArrayList<>();
        for (int i=0;i<4;i++){
            ShouyeBean.AdsBean.Col3xBean col3Bean = new ShouyeBean.AdsBean.Col3xBean();
            col3Bean.setPicture("https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png");
            col3xBeans.add(col3Bean);
        }
        adsBean.setCol3x(col3xBeans);
        shouyeBean.setAds(adsBean);
        List<ShouyeBean.TagOptionsBean> tagOptionsBeans = new ArrayList<>();
        for(int i=0;i<4;i++){
            ShouyeBean.TagOptionsBean tagOptionsBean = new ShouyeBean.TagOptionsBean();
            tagOptionsBean.setSubtitle("小标题"+i);
            tagOptionsBean.setTitle("tab大标题"+i);
            tagOptionsBeans.add(tagOptionsBean);
        }

        shouyeBean.setTag_options(tagOptionsBeans);


        setShouYeView(shouyeBean);
    }

    private void setShouYeView(ShouyeBean bean) {
        if (null != bean.getSearch().getKeywords() && bean.getSearch().getKeywords().size() > 0) {
            search_editext.setHint(bean.getSearch().getKeywords().get(0));
        }
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < bean.getBanners().size(); i++) {
            urls.add(bean.getBanners().get(i).getPicture());
        }
        set_banner_resource(urls, bean);

        ShouYeAdapter shouYeAdapter = new ShouYeAdapter(R.layout.shouye_item_layout, bean.getNavs());
        mRecyclerView.setAdapter(shouYeAdapter);

        List<String> center_urls = new ArrayList<>();
        for (int i = 0; i < bean.getAds().getCol1().size(); i++) {
            center_urls.add(bean.getAds().getCol1().get(i).getPicture());
        }

        set_center_banner_resource(center_urls);
        //设置tab的数据
        setTabView(bean.getTag_options());

        mRecyclerView.setOnItemClickListener(new FamiliarRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(FamiliarRecyclerView familiarRecyclerView, View view, int position) {
            }
        });


    }
    ShouYeFragmentPagerAdapter  mAdapter;
    private void setTabView(List<ShouyeBean.TagOptionsBean> tag_options) {
        List<String> mTitles = new ArrayList<>();
        ArrayList<Fragment> mFragments = new ArrayList<>();

        for (int i = 0; i < tag_options.size(); i++) {
            mTitles.add(tag_options.get(i).getTitle());
            mFragments.add(new TabFragment1(tag_options.get(i).getId()));
        }
        if (myViewPager.getAdapter() != null) {//清除viewpager的缓存
            //viewMaterialFragmentPagerAdapter.clear(myViewPager);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
                /*Bundle bundle = new Bundle();
                int index = myViewPager.getAdapter().getCount();
                String key = "index";

                while (index >= 0) {
                    bundle.putInt(key, index);
                    ft.remove(fm.getFragments().get(index-1));
                    index--;
                }
                ft.commit();*/

            for(int i=0;i<mFragments.size();i++){
                long itemId = mAdapter.getItemId(i);
                String name = makeFragmentName(myViewPager.getId(), itemId);
                Fragment fragment = fm.findFragmentByTag(name);
                if(fragment != null){//根据对应的ID，找到fragment，删除
                    ft.remove(fragment);
                }
            }
            ft.commitNowAllowingStateLoss();


        }

        mAdapter = new ShouYeFragmentPagerAdapter(getSupportFragmentManager(), tag_options, this);
        mAdapter.setItems(mFragments, mTitles);

        myViewPager.setAdapter(mAdapter);


        if(tab_layout.getTabCount()>0){
            tab_layout.removeAllTabs();
        }
        for (int i = 0; i < mTitles.size(); i++) {
            //设置自定义tab
            TabLayout.Tab tab = tab_layout.newTab();
            //添加自定义布局
            tab.setCustomView(mAdapter.getTabView(i));
            //绘制分割线
            LinearLayout linearLayout = (LinearLayout) tab_layout.getChildAt(0);
            linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                    R.drawable.shuxian));
            tab_layout.addTab(tab);

        }

        //设置初始样式
        View view = tab_layout.getTabAt(0).getCustomView();
        TextView textView = view.findViewById(R.id.tab_text);
        textView.setTextColor(Color.parseColor("#FFEF2A52"));
        TextView tab_bottom_inditor = view.findViewById(R.id.tab_bottom_inditor);
        tab_bottom_inditor.setTextColor(Color.parseColor("#ffffff"));
        tab_bottom_inditor.setBackgroundResource(R.drawable.tab_item_bottom_bg);

        setLayoutWidth();//tab设置等宽

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Log.e("社基康复了解到", "选中了" + tab.getPosition());
                myViewPager.setCurrentItem(tab.getPosition());

                View view = Objects.requireNonNull(tab_layout.getTabAt(tab.getPosition())).getCustomView();
                assert view != null;
                TextView textView = view.findViewById(R.id.tab_text);
                textView.setTextColor(Color.parseColor("#FFEF2A52"));
                TextView tab_bottom_inditor = view.findViewById(R.id.tab_bottom_inditor);
                tab_bottom_inditor.setTextColor(Color.parseColor("#ffffff"));
                tab_bottom_inditor.setBackgroundResource(R.drawable.tab_item_bottom_bg);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Log.e("社基康复了解到", "未选中" + tab.getPosition());
                View view = Objects.requireNonNull(tab_layout.getTabAt(tab.getPosition())).getCustomView();
                assert view != null;
                TextView textView = view.findViewById(R.id.tab_text);
                textView.setTextColor(Color.parseColor("#FF000000"));
                TextView tab_bottom_inditor = view.findViewById(R.id.tab_bottom_inditor);
                tab_bottom_inditor.setTextColor(Color.parseColor("#FF999999"));
                tab_bottom_inditor.setBackgroundResource(0);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("社基康复了解到", "ViewPager选中" + position);
                tab_layout.setScrollPosition(position, 0f, true);
                tab_layout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });


    }
    /**
     * 等同于FragmentPagerAdapter的makeFragmentName方法，
     * 由于父类的该方法是私有的，所以在此重新定义
     * @param viewId
     * @param id
     * @return
     */
    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }

    public void setLayoutWidth() {
        tab_layout.post(new Runnable() {
            @Override
            public void run() {
                // 拿到tabLayout的slidingTabIndicator属性
                try {
                    Field slidingTabIndicatorField = tab_layout.getClass().getDeclaredField("slidingTabIndicator");
                    slidingTabIndicatorField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) slidingTabIndicatorField.get(tab_layout);
                    Log.i("tabLayout", mTabStrip.getChildCount() + "   --");
                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);
//                        拿到tabview的textview属性
                        Field textViewField = tabView.getClass().getDeclaredField("textView");
                        textViewField.setAccessible(true);
                        TextView mTextView = (TextView) textViewField.get(tabView);
                        tabView.setPadding(0, 0, 0, 0);

//                        int width = mTextView.getWidth();
//                        if (width == 0) {
//                            mTextView.measure(0, 0);
//                            width = mTextView.getMeasuredWidth();
//                        }
//                        控制Item条目的宽度，这种设置的话就是等分
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        layoutParams.width = 0;
                        layoutParams.weight = 1;
                        tabView.setLayoutParams(layoutParams);
                        tabView.invalidate();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void set_center_banner_resource(List<String> urls) {
//        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);//设置圆形指示器与标题
//        banner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置
        banner_center.setDelayTime(2000);//设置轮播时间
        banner_center.setImages(urls);//设置图片源
        banner_center.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        });
        banner_center.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(MainActivity.this).load(R.drawable.banner_small).fit().into(imageView);
            }
        });
        banner_center.setClipToOutline(true);
        banner_center.start();
    }


    private void set_banner_resource(List<String> urls, ShouyeBean bean) {
//        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);//设置圆形指示器与标题
//        banner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置
        banner.setDelayTime(2000);//设置轮播时间
        banner.setImages(urls);//设置图片源
        banner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        });
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                Picasso.with(MainActivity.this).load(R.drawable.banner_large).fit().centerCrop().into(imageView);
            }
        });
        banner.setClipToOutline(true);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        banner.start();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_btn://搜索
                break;
            case R.id.saoma_btn://扫码
                break;
            case R.id.leiji_btn:

                break;
            case R.id.message_btn:
                break;
            case R.id.guofengyuncui_btn:

                break;
            case R.id.xinpin_btn:

                break;
            case R.id.xinrentehui_btn:

                break;
            case R.id.sales_volume:

                break;
            case R.id.new_product:

                break;
            case R.id.sales_volume2:

                break;

        }
    }

}