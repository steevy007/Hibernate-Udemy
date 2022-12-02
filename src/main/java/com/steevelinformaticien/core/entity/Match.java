/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.entity;

import javax.persistence.*;

/**
 *
 * @author PEPECELL
 */
@Entity
@Table(name = "MATCH_TENNIS")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VAINQUEUR")
    private Joueur vainqueur;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FINALISTE")
    private Joueur finaliste;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EPREUVE")
    private Epreuve epreuve;
    @OneToOne(fetch =FetchType.LAZY , mappedBy = "match")
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
