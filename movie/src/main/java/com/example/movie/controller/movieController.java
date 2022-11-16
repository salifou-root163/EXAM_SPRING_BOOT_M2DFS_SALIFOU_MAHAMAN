package com.example.movie.controller;

import com.example.movie.model.Acteur;
import com.example.movie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "movieController")
@RestController
public class movieController {

    public List<Acteur> listActeur(){
        List<Acteur> list = new ArrayList<>();
        list.add(new Acteur("test", "rock", new Date("11/01/1998"), new ArrayList<Film>( )    ) );
        return list;
    }
    public List<Film> listFilm(){
        List<Film> list = new ArrayList<>();
        list.add(new Film("wakanda", "tintin",  new ArrayList<Acteur>(), new Date("10/10/2020")) );
        return list;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK" ),
            @ApiResponse(code = 401, message = "t'es pas autorisé :) "),
            @ApiResponse(code = 403, message = "Je comprend la requete mais je refuse de la traiter :) "),
            @ApiResponse(code = 404, message = "J'ai pas trouvé la page " )
    })

    @ApiOperation(value = "Get actors list ", response = Acteur.class, tags = "getActors")
    @RequestMapping("/getActors")
    public List<Acteur> actorsList(){
        return listActeur();
    }

    @ApiOperation(value = "Get specific Actor  ", response = Acteur.class, tags = "getActor/{name}")
    @RequestMapping(value = "/getActor/{name}")
    public Acteur getActor(@PathVariable(value = "name") String name) {

        List<Acteur> result =  listActeur().stream().filter(std -> std.getNom().equals(name)) .collect(Collectors.toList());
        return result.get(0);
    }
    @ApiOperation(value = "Get  Actors by movie name  ", response = Acteur.class, tags = "getActorsByMovie/{name}")
    @RequestMapping(value = "/getActorsByMovie/{name}")
    public List<Acteur> getActorByMovie(@PathVariable(value = "name") String name) {
        List<Acteur> result =  listActeur().stream().filter(
                std ->
                        std.getFilmographie().stream().filter(x -> x.getTitre().equals(name)).isParallel())
                .collect(Collectors.toList());
        return result;
    }

    // FIlms

    @ApiOperation(value = "Get movies list ", response = Acteur.class, tags = "getMovies")
    @RequestMapping("/getMovies")
    public List<Acteur> moviesList(){
        return listActeur();
    }
    @ApiOperation(value = "Get specific movie  ", response = Acteur.class, tags = "getMovie/{title}")
    @RequestMapping(value = "/getMovie/{title}")
    public Film getMovie(@PathVariable(value = "title") String title) {
        List<Film> result =  listFilm().stream().filter(std -> std.getTitre().equals(title)) .collect(Collectors.toList());
        return result.get(0);
    }

    @ApiOperation(value = "Get  movies by année de sortie  ", response = Acteur.class, tags = "getMoviesByDate/{date}")
    @RequestMapping(value = "/getMoviesByDate/{date}")
    public List<Film> getMoviesByDate(@PathVariable(value = "date") String date) {
        List<Film> result =  listFilm().stream().filter(
                        std ->std.getDateSortie().equals(date)).collect(Collectors.toList());
        return result;
    }






}
