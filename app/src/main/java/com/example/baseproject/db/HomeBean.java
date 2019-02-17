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
public class HomeBean implements Serializable {
    static final long serialVersionUID = 42L; //添加后才可以进行序列化
    @Id
    public Long id;
    private  String photo;
    private  String name;
    private  String birth;
    private  String xingzuo;
    private  String gexing;
    private  String music;
    private  String school;
    private  String ge;
    private  String hobby;
    private  String provenic;
    private int km;
    @Generated(hash = 233105689)
    public HomeBean(Long id, String photo, String name, String birth,
            String xingzuo, String gexing, String music, String school, String ge,
            String hobby, String provenic, int km) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.birth = birth;
        this.xingzuo = xingzuo;
        this.gexing = gexing;
        this.music = music;
        this.school = school;
        this.ge = ge;
        this.hobby = hobby;
        this.provenic = provenic;
        this.km = km;
    }
    @Generated(hash = 931577662)
    public HomeBean() {
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
    public String getBirth() {
        return this.birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getXingzuo() {
        return this.xingzuo;
    }
    public void setXingzuo(String xingzuo) {
        this.xingzuo = xingzuo;
    }
    public String getGexing() {
        return this.gexing;
    }
    public void setGexing(String gexing) {
        this.gexing = gexing;
    }
    public String getMusic() {
        return this.music;
    }
    public void setMusic(String music) {
        this.music = music;
    }
    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getGe() {
        return this.ge;
    }
    public void setGe(String ge) {
        this.ge = ge;
    }
    public String getHobby() {
        return this.hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getProvenic() {
        return this.provenic;
    }
    public void setProvenic(String provenic) {
        this.provenic = provenic;
    }
    public int getKm() {
        return this.km;
    }
    public void setKm(int km) {
        this.km = km;
    }
   
   
}
