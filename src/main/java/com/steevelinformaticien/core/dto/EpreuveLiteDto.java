package com.steevelinformaticien.core.dto;

import com.steevelinformaticien.core.entity.Tournoi;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EpreuveLiteDto {
    private Long id;

    private Short annee;

    private Character typeEpreuve;


    public EpreuveLiteDto(Long id, Short annee, Character typeEpreuve) {
        this.id = id;
        this.annee = annee;
        this.typeEpreuve = typeEpreuve;

    }

    public EpreuveLiteDto() {
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


}
