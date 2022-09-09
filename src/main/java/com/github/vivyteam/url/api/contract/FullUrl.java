package com.github.vivyteam.url.api.contract;

import com.github.vivyteam.url.api.database.HelperClass;

import java.util.HashMap;
import java.util.List;

public class FullUrl {
    private String url;

    public FullUrl() {
    }

    public FullUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String urlShortener (String url){
        HelperClass helperClass = new HelperClass();
        StringBuilder shortURl = new StringBuilder();
        if(helperClass.checkURL(url))
        {
            System.out.println(helperClass.getShortURL(url));
        }
        else {
            int id  = helperClass.addURL(url);
            char []charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

            while (id > 0){
                int charPos = id % 62;
                shortURl.append(charList[charPos]);
                id = id/62;
            }
            helperClass.addShortURL(url,shortURl.reverse().toString());
        }
        return shortURl.reverse().toString();
    }
}
