package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.service.JoueurService;

import java.util.List;

public class JoueurController {
    private JoueurService joueurService;

    public JoueurController(){
        this.joueurService=new JoueurService();
    }

    public void listeJoueur(){
        System.out.println("Liste Joueur ");
        List<JoueurDto> list=this.joueurService.getListJ();

        for(JoueurDto j:list){
            System.out.println("Id => "+j.getId()+" Nom => "+j.getNom()+" Prenom => "+j.getPrenom()+" Sexe => "+j.getSexe());
        }

    }
}
