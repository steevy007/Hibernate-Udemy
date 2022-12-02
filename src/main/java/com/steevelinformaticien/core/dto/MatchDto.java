/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.dto;

import com.steevelinformaticien.core.controller.EpreuveController;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Score;

import javax.persistence.*;

/**
 *
 * @author PEPECELL
 */

public class MatchDto {
    private Long id;
    private JoueurDto vainqueur;
    private JoueurDto finaliste;

    private EpreuveFullDto epreuveFullDto;
    private ScoreFullDto scoreFullDto;

    public MatchDto() {
    }

    public MatchDto(Long id, JoueurDto vainqueur, JoueurDto finaliste , EpreuveFullDto epreuveController) {
        this.id = id;
        this.vainqueur = vainqueur;
        this.finaliste = finaliste;
        this.epreuveFullDto=epreuveController;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JoueurDto getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(JoueurDto vainqueur) {
        this.vainqueur = vainqueur;
    }

    public JoueurDto getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(JoueurDto finaliste) {
        this.finaliste = finaliste;
    }

    public EpreuveFullDto getEpreuveFullDto() {
        return epreuveFullDto;
    }

    public void setEpreuveFullDto(EpreuveFullDto epreuveFullDto) {
        this.epreuveFullDto = epreuveFullDto;
    }

    public ScoreFullDto getScoreFullDto() {
        return scoreFullDto;
    }

    public void setScoreFullDto(ScoreFullDto scoreFullDto) {
        this.scoreFullDto = scoreFullDto;
    }
}
