package com.example.tablayoutdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: hao
 * @Date 2017/10/27 15:32
 * @Description  ViewPager适配器
 *  避免fragment切换反复DestroyView和CreateView
 **/

public class ShouYeFragmentPagerAdapter extends FragmentPagerAdapter {

    List<String> mTitles;
    List<Fragment> fragments;
    Context context;
    List<ShouyeBean.TagOptionsBean> tag_options  ;
    public ShouYeFragmentPagerAdapter(FragmentManager fm) {

        super(fm);
        fragments = new ArrayList<>();
        mTitles = new ArrayList<String>();
    }

    public ShouYeFragmentPagerAdapter(FragmentManager fm, List<ShouyeBean.TagOptionsBean> mtag_options , Context mcontext) {
        super(fm);
        context = mcontext;
        fragments = new ArrayList<>();
        tag_options = mtag_options;
        mTitles = new ArrayList<String>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    public void setItems(List<Fragment> fragments, List<String> mTitles) {
        this.fragments = fragments;
        this.mTitles = mTitles;
        notifyDataSetChanged();
    }
    public void setItems(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public View getTabView(int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.tab_item_layout, null);
        TextView textView = view.findViewById(R.id.tab_text);
        textView.setText(tag_options.get(position).getTitle());
        TextView tab_bottom_inditor = view.findViewById(R.id.tab_bottom_inditor);
        tab_bottom_inditor.setText(tag_options.get(position).getSubtitle());
        return view;
    }


}
