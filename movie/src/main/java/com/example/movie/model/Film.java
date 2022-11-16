package com.example.movie.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class Film {

    @ApiModelProperty(notes = "movie title",name = "titre", required = true, value = "the movie title")
    private String titre;
    @ApiModelProperty(notes = "movie productor",name = "realisateur", required = true, value = "the movie productor")
    private String realisateur;
    @ApiModelProperty(notes = "movie principal actors, list of actors ",name = "acteurPrincipal", required = true, value = "the movie principal actors")
    private List<Acteur> acteurPrincipal;

    @ApiModelProperty(notes = "movie date de sortie",name = "dateSortie", required = true, value = "the movie date de sortie")
    private Date dateSortie;

    public Film(String titre, String realisateur, List<Acteur> acteurPrincipal, Date dateSortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteurPrincipal = acteurPrincipal;
        this.dateSortie = dateSortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public List<Acteur> getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(List<Acteur> acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}
