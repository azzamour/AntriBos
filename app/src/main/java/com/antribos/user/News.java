package com.antribos.user;

import java.io.Serializable;

/**
 * Created by Muhammad Azzam on 08/11/2017.
 */

public class News implements Serializable {
    String title;
    String content;

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
}
