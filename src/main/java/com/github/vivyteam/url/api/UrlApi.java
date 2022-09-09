package com.github.vivyteam.url.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.vivyteam.url.api.contract.FullUrl;
import com.github.vivyteam.url.api.contract.ShortenedUrl;
import com.github.vivyteam.url.api.database.HelperClass;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class UrlApi {

    @GetMapping("/{url}/short")
    public Mono<ShortenedUrl> shortUrl(@PathVariable final String url) {
        FullUrl fullUrl = new FullUrl();
        System.out.println("Shortened URL is:"+fullUrl.urlShortener(url));
        return Mono.just(new ShortenedUrl(url));
    }

    @GetMapping("/{shortenedUrl}/full")
    public Mono<FullUrl> getFullUrl(@PathVariable final String shortenedUrl) {
        HelperClass helperClass = new HelperClass();
        if(helperClass.getFullURL(shortenedUrl) == null){
            System.out.println("A Full URL for the requested url doesnot exist!!");
        }
        else {
            System.out.println("Full URL is:"+helperClass.getFullURL(shortenedUrl));
        }

        return Mono.just(new FullUrl(shortenedUrl));
    }

    @GetMapping("/{shortenedUrl}")
    public void redirectShortUrl(@PathVariable final String shortenedUrl){
        HelperClass helperClass = new HelperClass();
        String fullURL = helperClass.getFullURL(shortenedUrl);
        System.out.println(fullURL);
        try{
            Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(new URI("https://www.youtube.com/"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
