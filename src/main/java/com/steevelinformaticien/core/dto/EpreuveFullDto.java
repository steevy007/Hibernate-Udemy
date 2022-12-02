package com.steevelinformaticien.core.dto;

import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Tournoi;

import javax.persistence.*;
import java.util.Set;

public class EpreuveFullDto {
    private Long id;

    private Short annee;

    private Character typeEpreuve;

    private TournoiDto tournoi;

    private Set<JoueurDto> participants;

    public EpreuveFullDto(Long id, Short annee, Character typeEpreuve, TournoiDto tournoi) {
        this.id = id;
        this.annee = annee;
        this.typeEpreuve = typeEpreuve;
        this.tournoi = tournoi;
    }

    public EpreuveFullDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAnnee() {
        return annee;
    }

    public void setAnnee(Short annee) {
        this.annee = annee;
    }

    public Character getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    public TournoiDto getTournoi() {
        return tournoi;
    }

    public void setTournoi(TournoiDto tournoi) {
        this.tournoi = tournoi;
    }


    public Set<JoueurDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<JoueurDto> participants) {
        this.participants = participants;
    }
}
