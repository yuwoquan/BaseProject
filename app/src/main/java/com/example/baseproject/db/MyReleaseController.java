package com.example.baseproject.db;

/**
 * @author Ambrose
 * @date 2019/3/25 2:35 PM
 * @desc
 */
public class MyReleaseController {
    public static volatile MyReleaseController linSecensController;
    public static MyReleaseController getInstance() {
        if (linSecensController == null) {
            synchronized (LinSecensController.class) {
                if (linSecensController == null) {
                    linSecensController = new MyReleaseController();
                }
            }
        }
        return linSecensController;
    }
    /**
     * 添加数据
     */
    public long insert(MyReleaseBean address) {
        return GreenDaoManager.getInstance().getSession().getMyReleaseBeanDao().insert(address);
    }
}
