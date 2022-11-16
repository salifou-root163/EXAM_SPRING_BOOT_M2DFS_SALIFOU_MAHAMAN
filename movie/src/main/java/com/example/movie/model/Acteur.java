package com.example.movie.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class Acteur {

    @ApiModelProperty(notes = "Actor firstame",name = "nom", required = true, value = "the actor lastname")
    private String nom;
    @ApiModelProperty(notes = "Actor lastname",name = "prenom", required = true, value = "the actor lastname")
    private String prenom;
    @ApiModelProperty(notes = "Actor birth date",name = "dateNaiss", required = true, value = "the actor bith date")
    private Date dateNaiss;
    @ApiModelProperty(notes = "Actor movies , list of movies",name = "filmographie", required = true, value = "the actor movies list")
    private List<Film> filmographie;

    public Acteur(String nom, String prenom, Date dateNaiss, List<Film> filmographie) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.filmographie = filmographie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public List<Film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(List<Film> filmographie) {
        this.filmographie = filmographie;
    }
}
