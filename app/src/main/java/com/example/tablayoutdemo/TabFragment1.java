package com.example.tablayoutdemo;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TabFragment1 extends LazyFragment {
    @BindView(R.id.foot)
    PullToRefreshLayout foot;
    @BindView(R.id.grid_recycler_view)
    RecyclerView grid_recycler_view;

    private TabAdapter tabAdapter;
    private int PAGE=0;
    private int PER_PAGE=15;
    private List<GoodItemBean.TagGoodsBean> listBeans = new ArrayList<>();
    private boolean isPrepared;
    private static int current_index;
    public TabFragment1(int id){
        current_index = id;
    }

    @Override
    protected void lazyLoad() {
        if (isPrepared && isVisible) {
            //做加载数据的网络操作
            isPrepared = false;
            setDateResource();
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_tab;
    }

    @Override
    protected void initView(View view) {
        Log.e("初始化fragment","初始化fragment");
        //做初始化View的操作
        isPrepared = true;
        ButterKnife.bind(this, view);


        foot.setCanRefresh(false);
        foot.setRefreshListener(baseRefreshListener);

    }


    private void setDateResource() {
        getOrderResource();
    }

    BaseRefreshListener baseRefreshListener = new BaseRefreshListener() {
        @Override
        public void refresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listBeans.clear();
                    PAGE = 0;
                    getOrderResource();
                    foot.finishRefresh();
                }
            }, 1000);

        }

        @Override
        public void loadMore() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    PAGE++;
                    getOrderResource();
                    foot.finishLoadMore();
                }
            }, 1000);

        }
    };

    private void getOrderResource() {
        GoodItemBean goodItemBean = new GoodItemBean();
        List<GoodItemBean.TagGoodsBean> tagGoodsBeans = new ArrayList<>();
        for(int i=0;i<10;i++){
            GoodItemBean.TagGoodsBean tagGoodsBean = new GoodItemBean.TagGoodsBean();
            tagGoodsBean.setGoods_name("商品名称"+i);
            tagGoodsBean.setGoods_pic("src/main/res/drawable/null_.png");
            tagGoodsBean.setGoods_price("100");
            tagGoodsBean.setGoods_price_dead("10000");
            tagGoodsBeans.add(tagGoodsBean);
        }
        goodItemBean.setTag_goods(tagGoodsBeans);
        listBeans.addAll(goodItemBean.getTag_goods());
        if (listBeans.size() > 0 && goodItemBean.getTag_goods().size() == 0) {
            foot.setCanLoadMore(false);
            //Utils.showTextToas(getActivity(), "没有更多内容了");
        }
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        grid_recycler_view.setLayoutManager(layoutManager);
        if (tabAdapter == null) {
            tabAdapter = new TabAdapter(R.layout.shouye_adapter_item,listBeans);
            grid_recycler_view.setAdapter(tabAdapter);
            grid_recycler_view.addItemDecoration(new GridSpacingItemDecoration(2, 10, false));
            View nullView = View.inflate(getActivity(), R.layout.fragment_null, null);
            tabAdapter.setEmptyView(nullView);
        }else{
            tabAdapter.notifyDataSetChanged();
        }
        tabAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {

            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        PAGE = 0;
    }



  /*  public void setUserVisibleHint(boolean isVisibleToUser) {
        // TODO Auto-generated method stub
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            current_index = FirstPageFragment.select_tab_position;
            setDateResource();

        }
    }*/

}
