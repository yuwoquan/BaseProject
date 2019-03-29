package com.example.baseproject.enity;

import java.util.List;

public class ApplyBean {

    private List<DataBean> data;

    public List<DataBean> getDate() {
        return data;
    }

    public void setDate(List<DataBean> date) {
        this.data = date;
    }

    public static class DataBean {
        /**
         * type : PUBG
         * context : [{"apple_image":"R.drawable.wb1","apple_date":"2019年1月21日","apple_site":"深圳福田区依迪综合市场"},{"apple_image":"R.drawable.wb2","apple_date":"2019年1月22日","apple_site":"深圳罗湖区中旅大厦"},{"apple_image":"R.drawable.wb3","apple_date":"2019年1月24日","apple_site":"深圳市福田区十庙地"},{"apple_image":"R.drawable.wb4","apple_date":"2019年1月25日","apple_site":"深圳福田现代国际大厦"},{"apple_image":"R.drawable.wb5","apple_date":"2019年1月26日","apple_site":"深圳龙岗区首创八意府"},{"apple_image":"R.drawable.wb6","apple_date":"2019年1月26日","apple_site":"广州白云区松柏北街"},{"apple_image":"R.drawable.wb7","apple_date":"2019年1月27日","apple_site":"广州越秀区瑶池西街"}]
         */

        private String type;
        private List<ContextBean> context;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ContextBean> getContext() {
            return context;
        }

        public void setContext(List<ContextBean> context) {
            this.context = context;
        }

        public static class ContextBean {
            /**
             * apple_image : R.drawable.wb1
             * apple_date : 2019年1月21日
             * apple_site : 深圳福田区依迪综合市场
             */

            private String apple_image;
            private String apple_date;
            private String apple_site;

            public String getApple_image() {
                return apple_image;
            }

            public void setApple_image(String apple_image) {
                this.apple_image = apple_image;
            }

            public String getApple_date() {
                return apple_date;
            }

            public void setApple_date(String apple_date) {
                this.apple_date = apple_date;
            }

            public String getApple_site() {
                return apple_site;
            }

            public void setApple_site(String apple_site) {
                this.apple_site = apple_site;
            }
        }
    }
}
