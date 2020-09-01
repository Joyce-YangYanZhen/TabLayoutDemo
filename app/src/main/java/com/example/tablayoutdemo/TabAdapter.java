package com.example.tablayoutdemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.android.library.YLCircleImageView;

import java.util.List;

public class TabAdapter extends BaseQuickAdapter<GoodItemBean.TagGoodsBean, BaseViewHolder> {

    public TabAdapter(int layoutResId, @Nullable List<GoodItemBean.TagGoodsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, GoodItemBean.TagGoodsBean tagGoodsBean) {

        YLCircleImageView roundImageView = baseViewHolder.itemView.findViewById(R.id.good_img);
        int resourceId = R.drawable.new_products_list_emerald;
        Picasso.with(getContext()).load(resourceId).fit().centerCrop().into(roundImageView);
        baseViewHolder.setText(R.id.name_tv,tagGoodsBean.getGoods_name());
        baseViewHolder.setText(R.id.price_tv,"¥"+tagGoodsBean.getGoods_price());
        if(null!=tagGoodsBean.getGoods_price_dead()&&tagGoodsBean.getGoods_price_dead().length()>0){
            baseViewHolder.setVisible(R.id.shichangjia_tv,true);
            baseViewHolder.setText(R.id.shichangjia_tv, "市场价：¥"+tagGoodsBean.getGoods_price_dead());
        }else{
            baseViewHolder.setVisible(R.id.shichangjia_tv,false);
        }



    }
}
