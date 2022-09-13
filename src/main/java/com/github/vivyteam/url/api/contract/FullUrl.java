package com.github.vivyteam.url.api.contract;

import com.github.vivyteam.url.api.database.HelperClass;


public class FullUrl {
    private String url;

    public FullUrl() {

    }

    public FullUrl(String url) {
        HelperClass helperClass = new HelperClass();
        String fullUrl;
        if(helperClass.getFullURL(url) == null){ //check if the full url exists or not.
            fullUrl = "A Full URL for the requested url doesnot exist!!";
            System.out.println("A Full URL for the requested url doesnot exist!!");
        }
        else {
            fullUrl = helperClass.getFullURL(url);
            System.out.println("Full URL is: "+helperClass.getFullURL(url));
        }
        this.url = fullUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
