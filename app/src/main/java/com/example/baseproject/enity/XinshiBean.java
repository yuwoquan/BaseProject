package com.example.baseproject.enity;

import java.io.Serializable;

/**
 * @author Ambrose
 * @date 2019/3/25 5:06 PM
 * @desc
 */
public class XinshiBean implements Serializable {
    private String name;
    private String qianming;

    public XinshiBean(String name, String qianming, String newxuan, int photo, String jingxuan, int hot) {
        this.name = name;
        this.qianming = qianming;
        this.newxuan = newxuan;
        this.photo = photo;
        this.jingxuan = jingxuan;
        this.hot = hot;
    }

    public XinshiBean(){

    }
    private String newxuan;
    private int photo;
    private String jingxuan;
    private int hot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQianming() {
        return qianming;
    }

    public void setQianming(String qianming) {
        this.qianming = qianming;
    }

    public String getNewxuan() {
        return newxuan;
    }

    public void setNewxuan(String newxuan) {
        this.newxuan = newxuan;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getJingxuan() {
        return jingxuan;
    }

    public void setJingxuan(String jingxuan) {
        this.jingxuan = jingxuan;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }




}
