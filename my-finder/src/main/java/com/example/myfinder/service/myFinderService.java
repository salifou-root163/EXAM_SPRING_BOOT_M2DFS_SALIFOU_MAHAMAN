package com.example.myfinder.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class myFinderService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetActors() {
        String response = this.restTemplate.exchange("http://myMovie/getActors"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();

        return "ALl Actors " + response;
    }

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetActor(String name) {
        String response = this.restTemplate.exchange("http://myMovie/getActor/{name}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }, name).getBody();

        return "Actor " + response;
    }

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetgetActorsByMovie(String name) {
        String response = this.restTemplate.exchange("http://myMovie/getActorsByMovie/{name}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }, name).getBody();

        return "Actors by movie:  " + response;
    }

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetMovies() {
        String response = this.restTemplate.exchange("http://myMovie/getMovies"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();

        return "ALl movies " + response;
    }

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetMovie(String title) {
        String response = this.restTemplate.exchange("http://myMovie/getMovie/{title}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }, title).getBody();

        return "Movie " + response;
    }

    @HystrixCommand(fallbackMethod = "errorCallBack")
    public String callgetMoviesByDate(Date date) {
        String response = this.restTemplate.exchange("http://myMovie/getMoviesByDate/{date}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }, date).getBody();

        return "movie for this date  " + response;
    }

    @SuppressWarnings("unused")
    private String errorCallBack(){
        return "Oups.....  ";
    }



    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
