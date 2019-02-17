package com.example.baseproject.db;

public class LinSecensController {
    public static volatile LinSecensController linSecensController;
    public static LinSecensController getInstance() {
        if (linSecensController == null) {
            synchronized (LinSecensController.class) {
                if (linSecensController == null) {
                    linSecensController = new LinSecensController();
                }
            }
        }
        return linSecensController;
    }
    /**
     * 添加数据
     */
    public long insert(LinsecensBean address) {
        return GreenDaoManager.getInstance().getSession().getLinsecensBeanDao().insert(address);
    }


}


