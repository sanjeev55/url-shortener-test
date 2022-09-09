# Implementationd Details
For the given task following assumption was made:
- URL could be of any type

For the database:
- i opted not to connect to any database and maintain static hashmaps instead. 

Following classes were added:
HelperClass
- This class was created to handle the operation related to the indexing and storage of fullURL and shortURL. 
- Two hashmaps are created namely "fullUrlList" to store all the URLs requested and their corresponding ID; and "shortUrlList" to store the shortUrl and Full Url. 

The main logic behind the conversion from Full to short url is based on "Base Conversion", which means, the "id" (associated with the full URL) i.e is base10 number is converted to base62 characters which eventually will be used as the shortened URL. 
And for the reverse implementation, since all the shortURl and FullURl is maintained in "shortUrlLIst", i simply searched the hashmap using the shortURL to obtain the stored Full URL.

**The output is printed in the console. **

As for the bonus task, i opted to not attempt it because of the time limitation i have. 



# High level overview

We have created a simple application that comprises a backend app built in Java with Spring Webflux.

The purpose of the app is to create shortened versions of URLs. For example, given the url `https://github.com/VivyTeam/url-shortener-be-test`, the backend application would create a short url such as `http://localhost:9000/41e515a91a72`.

The application has two endpoints, detailed below:

```
GET /{urlToBeShortened}/short # Shorten the given URL
GET /{shortenedUrl}/full # Returns the full URL given the shortened version
```

# Your task

- Fork the repository
- Implement the logic to shorten a URL
- Implement the logic to get the full URL given a shortened one
- Bonus: implement a new endpoint that redirects the request to the full version of the shortened URL, like
  ```
  GET /{shortenedUrl} # Redirects the request to the full version of the shortened URL
  ```
- Share your repository with us

# Ports

Backend default port: `9000`
