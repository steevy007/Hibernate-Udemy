/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.entity;

/**
 *
 * @author PEPECELL
 */
public class Epreuve {

    private Long id;
    private Short annee;
    private Character typeEpreuve;
    private Tournoi tournoi;

    public Epreuve(Long id, Short annee, Character typeEpreuve, Tournoi tournoi) {
        this.id = id;
        this.annee = annee;
        this.typeEpreuve = typeEpreuve;
        this.tournoi = tournoi;
    }

    public Epreuve() {
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

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

}
