package com.github.vivyteam.url.api;

import com.github.vivyteam.url.api.contract.FullUrl;
import com.github.vivyteam.url.api.contract.ShortenedUrl;
import com.github.vivyteam.url.api.database.HelperClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class UrlApi {

    @GetMapping("/{url}/short")
    public Mono<ShortenedUrl> shortUrl(@PathVariable final String url) {
        FullUrl fullUrl = new FullUrl();
        System.out.println("Shortened URL is: http://localhost:9000/"+fullUrl.urlShortener(url));
        return Mono.just(new ShortenedUrl(url));
    }

    @GetMapping("/{shortenedUrl}/full")
    public Mono<FullUrl> getFullUrl(@PathVariable final String shortenedUrl) {
        HelperClass helperClass = new HelperClass();

        if(helperClass.getFullURL(shortenedUrl) == null){ //check if the full url exists or not.
            System.out.println("A Full URL for the requested url doesnot exist!!");
        }
        else {
            System.out.println("Full URL is: "+helperClass.getFullURL(shortenedUrl));
        }

        return Mono.just(new FullUrl(shortenedUrl));
    }

}
