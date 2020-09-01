package com.example.tablayoutdemo;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShouYeAdapter extends BaseQuickAdapter<ShouyeBean.NavsBean, BaseViewHolder> {

    public ShouYeAdapter(int layoutResId, @Nullable List<ShouyeBean.NavsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ShouyeBean.NavsBean optionsBean) {
        ImageView imageView = baseViewHolder.itemView.findViewById(R.id.imgview);
        Picasso.with(getContext()).load(R.drawable.small_icon).fit().centerCrop().into(imageView);
        baseViewHolder.setText(R.id.name_tv,optionsBean.getTitle());

    }
}
