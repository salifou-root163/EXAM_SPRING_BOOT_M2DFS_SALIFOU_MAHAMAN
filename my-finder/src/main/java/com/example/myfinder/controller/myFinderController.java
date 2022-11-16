package com.example.myfinder.controller;

import com.example.myfinder.service.myFinderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@Api(value = "myFinderController")
@RestController
public class myFinderController {

    @Autowired
    myFinderService mfs;

    @ApiOperation(value = "Get actors list from movie-microService ", response = myFinderController.class, tags = "showAllActors")
    @RequestMapping(value = "/showAllActors", method = RequestMethod.GET)
    public String showAllActors() {
        return mfs.callgetActors();
    }
    @ApiOperation(value = "Get specific Actor from movie-microService  ", response = myFinderController.class, tags = "showActor/{name}")
    @RequestMapping(value = "/showActor/{name}", method = RequestMethod.GET)
    public String showActor(@PathVariable String name) {
        return mfs.callgetActor(name);
    }
    @ApiOperation(value = "Get  Actors by movie name from movie-microService  ", response = myFinderController.class, tags = "showActorsByMovie/{name}")
    @RequestMapping(value = "/showActorsByMovie/{title}", method = RequestMethod.GET)
    public String showActorsByMovie(@PathVariable String title) {
        return mfs.callgetgetActorsByMovie(title);
    }
    @ApiOperation(value = "Get movies list from movie-microService ", response = myFinderController.class, tags = "showAllMovies")
    @RequestMapping(value = "/showAllMovies", method = RequestMethod.GET)
    public String showAllMovies() {
        return mfs.callgetMovies();
    }

    @ApiOperation(value = "Get specific movie from movie-microService  ", response = myFinderController.class, tags = "showMovie/{title}")
    @RequestMapping(value = "/showMovie/{title}", method = RequestMethod.GET)
    public String showMovie(@PathVariable String title) {
        return mfs.callgetMovie(title);
    }

    @ApiOperation(value = "Get  movies by année de sortie from movie-microService  ", response = myFinderController.class, tags = "showMoviesByDate/{date}")
    @RequestMapping(value = "/showMoviesByDate/{date}", method = RequestMethod.GET)
    public String showMoviesByDate(@PathVariable String date) {
        return mfs.callgetMoviesByDate(new Date(date));
    }


}
