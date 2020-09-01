package com.example.tablayoutdemo;

import java.util.List;

public class ShouyeBean {

    /**
     * search : {"keywords":["天然翡翠玉器","血玉"]}
     * banners : [{"id":2,"link":null,"picture":"http://qytb.cc/ff/files/w800/f25886df-448f-4a53-b1b8-f813edcc825b.jpg"}]
     * navs : [{"id":0,"title":"翡翠专区","icon":"https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png","link":"category/3"},{"id":1,"title":"每日秒杀","icon":"https://app.qiyitianbao.com/ff/files/509e9466-bc28-44b5-aab3-0fe1103f89a5.png","link":"seckill"},{"id":2,"title":"限时抢购","icon":"https://app.qiyitianbao.com/ff/files/d8029765-5370-4b47-b046-5fc1998b044a.png","link":"seckill"},{"id":3,"title":"瓜分特权","icon":"https://app.qiyitianbao.com/ff/files/779ab3bc-3844-4b0c-a50b-956af5b42900.png","link":"goods_group/5"},{"id":4,"title":"全城热榜","icon":"https://app.qiyitianbao.com/ff/files/013e3c1a-7cd7-42f5-aa43-3ebace8ee6b2.png","link":"goods_group/4"},{"id":5,"title":"热门活动","icon":"https://app.qiyitianbao.com/ff/files/189f7ad7-ca7c-4c16-b985-e90b806fde10.png","link":"activities"},{"id":6,"title":"话题发布","icon":"https://app.qiyitianbao.com/ff/files/18176120-0a73-46f3-9702-7fc111ed12b0.png","link":"tweet_post"},{"id":7,"title":"商品发布","icon":"https://app.qiyitianbao.com/ff/files/68592b32-5a6f-4d35-8c54-2fe53c0d01b2.png","link":"goods_post"},{"id":8,"title":"积分查询","icon":"https://app.qiyitianbao.com/ff/files/a2280f0e-faae-463c-96d9-fcf11dd59878.png","link":"point"},{"id":9,"title":"会员中心","icon":"https://app.qiyitianbao.com/ff/files/02f90c4d-cce7-4172-9c82-4a3fbeadf2b5.png","link":"https://app.qiyitianbao.com/do/webview/member/intro"}]
     * ads : {"col1":[{"id":1,"title":"翡翠手镯定制","picture":"https://app.qiyitianbao.com/ff/files/697b9963-4843-44d4-96ad-046578024fe1.png","link":""}],"col3":[{"id":2,"title":"文玩销量榜","picture":"https://app.qiyitianbao.com/ff/files/758d3d3b-245e-478b-a6dd-8b0cc410752b.png","link":""},{"id":3,"title":"翡翠新品榜","picture":"https://app.qiyitianbao.com/ff/files/287e050b-8e85-4dc9-a058-30955a7105fc.png","link":""},{"id":4,"title":"翡翠销量榜","picture":"https://app.qiyitianbao.com/ff/files/20b758e7-8996-4cf5-b782-f11726a23dbe.png","link":""}],"col3x":[{"id":5,"title":"工艺国风云翠","picture":"https://app.qiyitianbao.com/ff/files/0dd652bd-7206-4be2-a43d-8e04f62a35c9.png","link":"goods_group/1"},{"id":6,"title":"新品上市","picture":"https://app.qiyitianbao.com/ff/files/0cc289aa-2ce2-4c8b-82d9-dda24bf3cb9d.png","link":"goods_group/0"},{"id":7,"title":"新人特惠","picture":"https://app.qiyitianbao.com/ff/files/6fcba758-ed2c-4423-8506-7626fce5133f.png","link":"goods_group/3"}]}
     * tag_options : [{"id":0,"title":"全部","subtitle":"猜你喜欢"},{"id":1,"title":"发现好物","subtitle":"实力好物"},{"id":2,"title":"高颜值","subtitle":"你值得拥有"},{"id":3,"title":"官方严选","subtitle":"精品"}]
     * tag_goods : [{"id":6,"kind":"goods","goods_name":"一元体验","goods_pic":"http://qytb.cc/ff/files/w800/c7d7bb69-0e88-4ad3-b06d-7e97b3888ea4.jpg","goods_price":"1.00","goods_price_dead":""},{"id":5,"kind":"goods","goods_name":"厨房挂件厨房置物架刀架太空铝挂件背后11","goods_pic":"http://qytb.cc/ff/files/w400/77f232fe-714d-4661-acdc-cf6ebfa09273.jpg","goods_price":"129.99","goods_price_dead":""},{"id":4,"kind":"goods","goods_name":"车载充电器 金属车充多口USB充电器 快充充电器 高雅黑","goods_pic":"http://qytb.cc/ff/files/w800/d026addd-fd34-48a4-9b9f-a48e1b0fe096.jpg","goods_price":"99.00","goods_price_dead":""},{"id":3,"kind":"goods","goods_name":"车载充电器 金属车充多口USB充电器 快充充电器 高雅黑","goods_pic":"http://qytb.cc/ff/files/w800/d026addd-fd34-48a4-9b9f-a48e1b0fe096.jpg","goods_price":"99.00","goods_price_dead":""},{"id":2,"kind":"goods","goods_name":"[测试商品][自营] UGG 2017早秋新款女士雪地靴经典贝莉系列迷你靴","goods_pic":"http://qytb.cc/ff/files/w400/95cfbd82-c2b1-4d65-8b52-5505e08a58da.jpg","goods_price":"1680.00","goods_price_dead":""},{"id":1,"kind":"goods","goods_name":"[测试商品][自营] mcm 女包 小号 双肩包 MMK6SVE19","goods_pic":"http://qytb.cc/storage/images/1FJJxgBtD6EEw8jbVTSnj55oFIDq2ei4t4uK9KPu_md.jpeg","goods_price":"4999.00","goods_price_dead":"6999.00"}]
     */

    private SearchBean search;
    private AdsBean ads;
    private List<BannersBean> banners;
    private List<NavsBean> navs;
    private List<TagOptionsBean> tag_options;
    private List<TagGoodsBean> tag_goods;

    public SearchBean getSearch() {
        return search;
    }

    public void setSearch(SearchBean search) {
        this.search = search;
    }

    public AdsBean getAds() {
        return ads;
    }

    public void setAds(AdsBean ads) {
        this.ads = ads;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public List<NavsBean> getNavs() {
        return navs;
    }

    public void setNavs(List<NavsBean> navs) {
        this.navs = navs;
    }

    public List<TagOptionsBean> getTag_options() {
        return tag_options;
    }

    public void setTag_options(List<TagOptionsBean> tag_options) {
        this.tag_options = tag_options;
    }

    public List<TagGoodsBean> getTag_goods() {
        return tag_goods;
    }

    public void setTag_goods(List<TagGoodsBean> tag_goods) {
        this.tag_goods = tag_goods;
    }

    public static class SearchBean {
        private List<String> keywords;

        public List<String> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }
    }

    public static class AdsBean {
        private List<Col1Bean> col1;
        private List<Col3Bean> col3;
        private List<Col3xBean> col3x;

        public List<Col1Bean> getCol1() {
            return col1;
        }

        public void setCol1(List<Col1Bean> col1) {
            this.col1 = col1;
        }

        public List<Col3Bean> getCol3() {
            return col3;
        }

        public void setCol3(List<Col3Bean> col3) {
            this.col3 = col3;
        }

        public List<Col3xBean> getCol3x() {
            return col3x;
        }

        public void setCol3x(List<Col3xBean> col3x) {
            this.col3x = col3x;
        }

        public static class Col1Bean {
            /**
             * id : 1
             * title : 翡翠手镯定制
             * picture : https://app.qiyitianbao.com/ff/files/697b9963-4843-44d4-96ad-046578024fe1.png
             * link :
             */

            private int id;
            private String title;
            private String picture;
            private String link;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class Col3Bean {
            /**
             * id : 2
             * title : 文玩销量榜
             * picture : https://app.qiyitianbao.com/ff/files/758d3d3b-245e-478b-a6dd-8b0cc410752b.png
             * link :
             */

            private int id;
            private String title;
            private String picture;
            private String link;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class Col3xBean {
            /**
             * id : 5
             * title : 工艺国风云翠
             * picture : https://app.qiyitianbao.com/ff/files/0dd652bd-7206-4be2-a43d-8e04f62a35c9.png
             * link : goods_group/1
             */

            private int id;
            private String title;
            private String picture;
            private String link;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }

    public static class BannersBean {
        /**
         * id : 2
         * link : null
         * picture : http://qytb.cc/ff/files/w800/f25886df-448f-4a53-b1b8-f813edcc825b.jpg
         */

        private int id;
        private Object link;
        private String picture;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getLink() {
            return link;
        }

        public void setLink(Object link) {
            this.link = link;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }

    public static class NavsBean {
        /**
         * id : 0
         * title : 翡翠专区
         * icon : https://app.qiyitianbao.com/ff/files/71be30c6-3e76-4a37-b669-22dabdc761b6.png
         * link : category/3
         */

        private int id;
        private String title;
        private String icon;
        private String link;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public static class TagOptionsBean {
        /**
         * id : 0
         * title : 全部
         * subtitle : 猜你喜欢
         */

        private int id;
        private String title;
        private String subtitle;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
    }

    public static class TagGoodsBean {
        /**
         * id : 6
         * kind : goods
         * goods_name : 一元体验
         * goods_pic : http://qytb.cc/ff/files/w800/c7d7bb69-0e88-4ad3-b06d-7e97b3888ea4.jpg
         * goods_price : 1.00
         * goods_price_dead :
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
