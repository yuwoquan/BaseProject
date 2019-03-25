package com.example.baseproject.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Ambrose
 * @date 2019/3/25 2:33 PM
 * @desc
 */
@Entity
public class MyReleaseBean {
    @Id
    public Long id;
    private String url;
    private String title;
    private String time;
    private String address;
    private String people;
    private String beizhu;
    @Generated(hash = 1156010763)
    public MyReleaseBean(Long id, String url, String title, String time,
            String address, String people, String beizhu) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.time = time;
        this.address = address;
        this.people = people;
        this.beizhu = beizhu;
    }
    @Generated(hash = 1561445898)
    public MyReleaseBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPeople() {
        return this.people;
    }
    public void setPeople(String people) {
        this.people = people;
    }
    public String getBeizhu() {
        return this.beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

}
