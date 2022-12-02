package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.service.JoueurService;

import java.util.List;
import java.util.Scanner;

public class JoueurController {
    private JoueurService joueurService;

    public JoueurController(){
        this.joueurService=new JoueurService();
    }

    public void listeJoueur(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir le sexe");
        char sexe=sc.nextLine().charAt(0);
        List<JoueurDto> list=this.joueurService.getListJ(sexe);

        for(JoueurDto j:list){
            System.out.println("Id => "+j.getId()+" Nom => "+j.getNom()+" Prenom => "+j.getPrenom()+" Sexe => "+j.getSexe());
        }

    }
}
