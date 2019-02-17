package com.example.baseproject.db;

/**
 * @author Ambrose
 * @date 2019/1/28 12:22 PM
 * @desc
 */
public class CommentController {
    public static volatile CommentController commentController;
    public static CommentController getInstance() {
        if (commentController == null) {
            synchronized (CommentController.class) {
                if (commentController == null) {
                   commentController = new CommentController();
                }
            }
        }
        return commentController;
    }
    /**
     * 添加数据
     */
    public long insert(CommentBean address) {
        return GreenDaoManager.getInstance().getSession().getCommentBeanDao().insert(address);
    }


}

