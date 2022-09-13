package com.github.vivyteam.url.api.database;

import java.util.LinkedHashMap;

public class HelperClass {
    public static LinkedHashMap<Integer, String> fullUrlList = new LinkedHashMap<>(); //store id and full url
    public static LinkedHashMap <String, String> shortUrlList = new LinkedHashMap<>();// store full url and short url

    public boolean checkURL (String url){// check if URL already exists
        return fullUrlList.containsValue(url);
    }

    public int addURL (String url){// add the full url to the hashmap and return id to apply the shortening algorithm

        int id = fullUrlList.size() + 1; //increment the value of id for each new entry
        fullUrlList.put(id, url);

        return id;

    }
    public String getFullURL (String shortURL){ //method to check if the fullURL for the requested shortURL exists
        String fullURL = null;
        for (String key : shortUrlList.keySet()){
            String value = shortUrlList.get(key);
            if (value.equals(shortURL)){
                fullURL = key;
            }
        }
        return fullURL;
    }

    public String getShortURL (String url){
        return shortUrlList.get(url);
    }

    public void addShortURL(String fullURL, String shortURL){
        shortUrlList.put(fullURL,shortURL);
    }
}
