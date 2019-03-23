package com.example.baseproject.enity;

import java.io.Serializable;

/**
 * @author Ambrose
 * @date 2019/1/28 1:22 PM
 * @desc
 */
public class BoardBean implements Serializable {

    private int photo;
    private String msg;
    private String conntent;
    private int lines;
    public BoardBean(int photo, String msg, String conntent, int lines) {
        this.photo = photo;
        this.msg = msg;
        this.conntent = conntent;
        this.lines = lines;
    }



    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

}
