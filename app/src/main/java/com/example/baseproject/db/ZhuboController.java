package com.example.baseproject.db;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26/026.
 */

public class ZhuboController {
        public static volatile ZhuboController zhuboController;
        public static ZhuboController getInstance() {
            if (zhuboController == null) {
                synchronized (ZhuboController.class) {
                    if (zhuboController == null) {
                        zhuboController = new ZhuboController();
                    }
                }
            }
            return zhuboController;
        }
        /**
         * 添加数据
         */
        public long insert(ZhuboBean address) {
            return GreenDaoManager.getInstance().getSession().getZhuboBeanDao().insert(address);
        }

        /**
         * 删除数据
         */
        public void delete(long id) {
            GreenDaoManager.getInstance().getSession().getZhuboBeanDao().deleteByKey(id);
        }

        /**
         * 更新数据
         */
        public void update(ZhuboBean address) {
            GreenDaoManager.getInstance().getSession().getZhuboBeanDao().update(address);
        }

    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<ZhuboBean> likeQueryy(String username, int i, int b, String msg) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getZhuboBeanDao()
                .queryBuilder()
//                .and(ZhuboBeanDao.Properties.Se.between(18,25))
                .where(ZhuboBeanDao.Properties.Xingzuo.like("%" + username + "%"))
                .list();
    }
    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<ZhuboBean> likeQuery(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getZhuboBeanDao()
                .queryBuilder()
                .where(ZhuboBeanDao.Properties.Xingzuo.like("%" + username + "%"))
                .list();
    }
    public List<ZhuboBean> likeQueryID(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getZhuboBeanDao()
                .queryBuilder()
                .where(ZhuboBeanDao.Properties.Name.like("%" + username + "%"))
                .list();
    }
    public List<ZhuboBean> likeQueryName(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getZhuboBeanDao()
                .queryBuilder()
                .where(ZhuboBeanDao.Properties.Url.like("%" + username + "%"))
                .list();
    }

    public List<ZhuboBean> likeQueryNamee(String username) {
        return GreenDaoManager.getInstance()
                .getSession()
                .getZhuboBeanDao()
                .queryBuilder()
                .where(ZhuboBeanDao.Properties.Url.like("%" + username + "%"))
                .list();
    }

        /**
         * 查询指定数据，条件用户名必须相同
         */
        public List<ZhuboBean> query(String username) {
            return GreenDaoManager.getInstance().getSession().getZhuboBeanDao().queryBuilder().where(ZhuboBeanDao.Properties.Xingzuo.eq(username)).list();
        }
}

