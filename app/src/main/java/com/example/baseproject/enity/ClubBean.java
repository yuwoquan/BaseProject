package com.example.baseproject.enity;

/**
 * @author Ambrose
 * @date 2019/3/25 1:48 PM
 * @desc
 */
public class ClubBean {

    private int photo;
    private int star;
    private String clubname;
    private String type;
    private String wangba;
    private String address;

    public ClubBean(int photo, int star, String clubname, String type, String wangba, String address) {
        this.photo = photo;
        this.star = star;
        this.clubname = clubname;
        this.type = type;
        this.wangba = wangba;
        this.address = address;
    }



    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWangba() {
        return wangba;
    }

    public void setWangba(String wangba) {
        this.wangba = wangba;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
