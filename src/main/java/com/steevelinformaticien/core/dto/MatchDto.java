/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.dto;

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


    public MatchDto() {
    }

    public MatchDto(Long id, JoueurDto vainqueur, JoueurDto finaliste) {
        this.id = id;
        this.vainqueur = vainqueur;
        this.finaliste = finaliste;
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
}
