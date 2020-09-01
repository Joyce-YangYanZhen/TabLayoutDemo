package com.example.tablayoutdemo;

import java.util.List;

public class GoodItemBean {

    private List<TagGoodsBean> tag_goods;

    public List<TagGoodsBean> getTag_goods() {
        return tag_goods;
    }

    public void setTag_goods(List<TagGoodsBean> tag_goods) {
        this.tag_goods = tag_goods;
    }

    public static class TagGoodsBean {
        /**
         * id : 1
         * kind : goods
         * goods_name : [测试商品][自营] mcm 女包 小号 双肩包 MMK6SVE19
         * goods_pic : http://qytb.cc/storage/images/1FJJxgBtD6EEw8jbVTSnj55oFIDq2ei4t4uK9KPu_md.jpeg
         * goods_price : 4999.00
         * goods_price_dead : 6999.00
         */

        private int id;
        private String kind;
        private String goods_name;
        private String goods_pic;
        private String goods_price;
        private String goods_price_dead;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_pic() {
            return goods_pic;
        }

        public void setGoods_pic(String goods_pic) {
            this.goods_pic = goods_pic;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_price_dead() {
            return goods_price_dead;
        }

        public void setGoods_price_dead(String goods_price_dead) {
            this.goods_price_dead = goods_price_dead;
        }
    }
}
