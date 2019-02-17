package com.example.baseproject.db;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26/026.
 */

public class HomeController {
        public static volatile HomeController homeController;
        public static HomeController getInstance() {
            if (homeController == null) {
                synchronized (HomeController.class) {
                    if (homeController == null) {
                        homeController = new HomeController();
                    }
                }
            }
            return homeController;
        }
        /**
         * 添加数据
         */
        public long insert(HomeBean address) {
            return GreenDaoManager.getInstance().getSession().getHomeBeanDao().insert(address);
        }

        /**
         * 删除数据
         */
        public void delete(long id) {
            GreenDaoManager.getInstance().getSession().getHomeBeanDao().deleteByKey(id);
        }

        /**
         * 更新数据
         */
        public void update(HomeBean address) {
            GreenDaoManager.getInstance().getSession().getHomeBeanDao().update(address);
        }

    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<HomeBean> likeQueryy(String username,int i,int b,String msg) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getHomeBeanDao()
                .queryBuilder()
//                .and(HomeBeanDao.Properties.Se.between(18,25))
                .where(HomeBeanDao.Properties.Xingzuo.like("%" + username + "%"))
                .list();
    }
    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<HomeBean> likeQuery(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getHomeBeanDao()
                .queryBuilder()
                .where(HomeBeanDao.Properties.Xingzuo.like("%" + username + "%"))
                .list();
    }
    public List<HomeBean> likeQueryID(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getHomeBeanDao()
                .queryBuilder()
                .where(HomeBeanDao.Properties.Name.like("%" + username + "%"))
                .list();
    }
//    public List<HomeBean> likeQueryName(String username) {
//        return GreenDaoManager.getInstance()
//                .getSession()
//                .getHomeBeanDao()
//                .queryBuilder()
//                .where(HomeBeanDao.Properties.Url.like("%" + username + "%"))
//                .list();
//    }
//
//    public List<HomeBean> likeQueryNamee(String username) {
//        return GreenDaoManager.getInstance()
//                .getSession()
//                .getHomeBeanDao()
//                .queryBuilder()
//                .where(HomeBeanDao.Properties.Url.like("%" + username + "%"))
//                .list();
//    }

        /**
         * 查询指定数据，条件用户名必须相同
         */
        public List<HomeBean> query(String username) {
            return GreenDaoManager.getInstance().getSession().getHomeBeanDao().queryBuilder().where(HomeBeanDao.Properties.Name.eq(username)).list();
        }
}

