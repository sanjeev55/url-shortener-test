package com.github.vivyteam.url.api.contract;

import com.github.vivyteam.url.api.database.HelperClass;


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
        String finalShortURL;

        if(helperClass.checkURL(url))
        {
            finalShortURL = helperClass.getShortURL(url);
        }
        else {
            int id  = helperClass.addURL(url);
            char []charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); //indexing base62 character list

            while (id > 0){
                int charPos = id % 62;
                shortURl.append(charList[charPos]);
                id = id/62;
            }
            finalShortURL = shortURl.reverse().toString();
            helperClass.addShortURL(url,shortURl.reverse().toString());
        }
        return finalShortURL;
    }
}
