package com.example.baseproject.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * @author Ambrose
 * @date 2019/1/28 12:05 PM
 * @desc
 */
@Entity
public class CommentBean {
    @Id
    public Long id;
    private String msg;
    private String photo;
    private String name;
    private int commentnum;
    private int zannum;
    private String data;
    private String school;
    @Generated(hash = 1326693185)
    public CommentBean(Long id, String msg, String photo, String name,
            int commentnum, int zannum, String data, String school) {
        this.id = id;
        this.msg = msg;
        this.photo = photo;
        this.name = name;
        this.commentnum = commentnum;
        this.zannum = zannum;
        this.data = data;
        this.school = school;
    }
    @Generated(hash = 373728077)
    public CommentBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getPhoto() {
        return this.photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCommentnum() {
        return this.commentnum;
    }
    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }
    public int getZannum() {
        return this.zannum;
    }
    public void setZannum(int zannum) {
        this.zannum = zannum;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

  
}
