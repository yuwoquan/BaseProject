package com.example.baseproject.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * @author Ambrose
 * @date 2019/1/18 10:27 AM
 * @desc
 */
@Entity
public class ZhuboBean implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    public Long id;
    private String province;
    private String desc;
    private  String city;
    private String name;
    private String idd;
    private String url;
    private String hobby;
    private String age;
    private int se;
    private String music;
    private String fensi;
    private String xingzuo;
    private String pingtai;
    private int leveal;
    private String yanzhi;
    private String msg;
    @Generated(hash = 549277961)
    public ZhuboBean(Long id, String province, String desc, String city,
            String name, String idd, String url, String hobby, String age, int se,
            String music, String fensi, String xingzuo, String pingtai, int leveal,
            String yanzhi, String msg) {
        this.id = id;
        this.province = province;
        this.desc = desc;
        this.city = city;
        this.name = name;
        this.idd = idd;
        this.url = url;
        this.hobby = hobby;
        this.age = age;
        this.se = se;
        this.music = music;
        this.fensi = fensi;
        this.xingzuo = xingzuo;
        this.pingtai = pingtai;
        this.leveal = leveal;
        this.yanzhi = yanzhi;
        this.msg = msg;
    }
    @Generated(hash = 1129455420)
    public ZhuboBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProvince() {
        return this.province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdd() {
        return this.idd;
    }
    public void setIdd(String idd) {
        this.idd = idd;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getHobby() {
        return this.hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public int getSe() {
        return this.se;
    }
    public void setSe(int se) {
        this.se = se;
    }
    public String getMusic() {
        return this.music;
    }
    public void setMusic(String music) {
        this.music = music;
    }
    public String getFensi() {
        return this.fensi;
    }
    public void setFensi(String fensi) {
        this.fensi = fensi;
    }
    public String getXingzuo() {
        return this.xingzuo;
    }
    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }
    public String getPingtai() {
        return this.pingtai;
    }
    public void setPingtai(String pingtai) {
        this.pingtai = pingtai;
    }
    public int getLeveal() {
        return this.leveal;
    }
    public void setLeveal(int leveal) {
        this.leveal = leveal;
    }
    public String getYanzhi() {
        return this.yanzhi;
    }
    public void setYanzhi(String yanzhi) {
        this.yanzhi = yanzhi;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
 

}
