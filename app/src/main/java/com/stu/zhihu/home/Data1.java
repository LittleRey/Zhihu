package com.stu.zhihu.home;

public class Data1 {
    String title;
    String content;
    String sub;

    public Data1() {
    }

    public Data1(String title, String content, String sub) {
        this.title = title;
        this.content = content;
        this.sub = sub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
