package com.example.baseproject.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class LinsecensBean {
    @Id
    public Long id;
    private String photo;
    private String name;
    private String time;
    private String comment;
    private String zan;
    private String school;
    private String msg;
    @Generated(hash = 667157771)
    public LinsecensBean(Long id, String photo, String name, String time,
            String comment, String zan, String school, String msg) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.time = time;
        this.comment = comment;
        this.zan = zan;
        this.school = school;
        this.msg = msg;
    }
    @Generated(hash = 1483377876)
    public LinsecensBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getZan() {
        return this.zan;
    }
    public void setZan(String zan) {
        this.zan = zan;
    }
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
