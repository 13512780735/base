package com.likeits.simple.adapter.indent;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.Indent.IndentListModel;

import java.util.List;

/**
 * Created by admin on 2018/5/11.
 */

public class GoodIndent04Adapter extends BaseQuickAdapter<IndentListModel.ListBean, BaseViewHolder> {
    private List<IndentListModel.ListBean.GoodsBean> datas;
    private IndentShopListAdapter mAdapter;

    public GoodIndent04Adapter(int layoutResId, List<IndentListModel.ListBean> data) {
        super(R.layout.goods_indent_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, IndentListModel.ListBean item) {
        datas = item.getGoods();
        baseViewHolder.setText(R.id.tv_indent_number, "订单号：" + item.getOrdersn());
        baseViewHolder.setText(R.id.tv_indent_name, item.getMerchname());

        baseViewHolder.setText(R.id.tv_total_number, "共 " + item.getSum() + " 个商品,合计");
        baseViewHolder.setText(R.id.tv_total_price, "¥ " + item.getPrice());
        int status = item.getStatus();
        if (status == 3) {
            baseViewHolder.setText(R.id.tv_indent_status, "等待评价");
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_del_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_appraise_indent).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.tv_check_wuLiu).setVisibility(View.VISIBLE);
            baseViewHolder.setText(R.id.tv_del_indent, "删除订单");
            baseViewHolder.setText(R.id.tv_appraise_indent, "评价");
            baseViewHolder.setText(R.id.tv_check_wuLiu, "查看物流");
        }
        baseViewHolder.addOnClickListener(R.id.tv_appraise_indent);
        baseViewHolder.addOnClickListener(R.id.tv_del_indent);
        baseViewHolder.addOnClickListener(R.id.tv_check_wuLiu);
        baseViewHolder.addOnClickListener(R.id.rl_indent_details);
        mAdapter = new IndentShopListAdapter(R.layout.layout_indent_shop_listitems, datas);
        RecyclerView mRecyclerView = baseViewHolder.getView(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }
}
