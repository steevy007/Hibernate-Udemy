/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.entity;

/**
 *
 * @author PEPECELL
 */

public class Match {
    private Long id;
    private Joueur vainqueur;
    private Joueur finaliste;
    private Epreuve epreuve;
    private Score score;

    public Match() {
    }

    public Match(Long id, Joueur vainqueur, Joueur finaliste, Epreuve epreuve) {
        this.id = id;
        this.vainqueur = vainqueur;
        this.finaliste = finaliste;
        this.epreuve = epreuve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Joueur getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(Joueur vainqueur) {
        this.vainqueur = vainqueur;
    }

    public Joueur getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(Joueur finaliste) {
        this.finaliste = finaliste;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    
    
    
    
}
