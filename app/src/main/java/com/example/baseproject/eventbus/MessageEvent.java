package com.example.baseproject.eventbus;

/**
 * Created by Administrator on 2018/5/24/024.
 */

public class MessageEvent {
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseTitle() {
        return baseTitle;
    }

    public void setBaseTitle(String baseTitle) {
        this.baseTitle = baseTitle;
    }

    private String baseUrl;

    public MessageEvent(String baseUrl, String baseTitle) {
        this.baseUrl = baseUrl;
        this.baseTitle = baseTitle;
    }

    private String baseTitle;
}
