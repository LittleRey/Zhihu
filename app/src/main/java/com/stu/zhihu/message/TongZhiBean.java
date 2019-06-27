package com.stu.zhihu.message;

public class TongZhiBean {
    String title;
    String time;
    String subtitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public TongZhiBean(String title, String time, String subtitle) {
        this.title = title;
        this.time = time;
        this.subtitle = subtitle;
    }
}
