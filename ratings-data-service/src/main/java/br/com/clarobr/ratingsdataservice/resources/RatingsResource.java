package br.com.clarobr.ratingsdataservice.resources;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clarobr.ratingsdataservice.model.Rating;
import br.com.clarobr.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@GetMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId, @RequestHeader HttpHeaders headers) {
//    	headers.forEach((key, value) -> {
//			System.out.println(String.format("##### Header '%s' = %s", key, value));
//	    });
    	    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
        return new Rating(movieId, 4);
    }

	@GetMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId, @RequestHeader HttpHeaders headers) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        
//        headers.forEach((key, value) -> {
//			System.out.println(String.format("##### Header '%s' = %s", key, value));
//	    });
    	
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
        return userRating;
    }

}
