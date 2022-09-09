package com.github.vivyteam.url.api.database;

import java.util.LinkedHashMap;

public class HelperClass {
    static LinkedHashMap<Integer, String> fullUrlList = new LinkedHashMap<>();
    static LinkedHashMap <String, String> shortUrlLIst = new LinkedHashMap<>();

    public boolean checkURL (String url){
        return fullUrlList.containsValue(url);
    }

    public int addURL (String url){

        int id = fullUrlList.size() + 1;
        fullUrlList.put(id, url);

        return id;
    }
    public String getFullURL (String shortURL){
        String fullURL = null;
        for (String key : shortUrlLIst.keySet()){
            String value = shortUrlLIst.get(key);
            if (value.equals(shortURL)){
                fullURL = key;
            }
        }
        return fullURL;
    }
    public String getShortURL (String url){
        return shortUrlLIst.get(url);
    }
    public void addShortURL(String fullURL, String shortURL){
        shortUrlLIst.put(fullURL,shortURL);
    }
}
