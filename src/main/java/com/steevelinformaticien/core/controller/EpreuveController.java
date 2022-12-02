package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.EpreuveFullDto;
import com.steevelinformaticien.core.dto.EpreuveLiteDto;
import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.service.EpreuveService;

import java.util.Scanner;

public class EpreuveController {
    private EpreuveService epreuveService;

    public EpreuveController(){
        this.epreuveService=new EpreuveService();
    }

    public void getEpreuveAvecTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du tournoi");
        Long id=sc.nextLong();
        EpreuveFullDto epreuve=this.epreuveService.getEpreuveDetaille(id);
        System.out.println("L'annee de l'epreuve selectionner est "+epreuve.getAnnee()+" le tournoi est "+epreuve.getTournoi().getNom());
        for (JoueurDto joueurDto:epreuve.getParticipants()){
            System.out.println(joueurDto.getNom()+" "+joueurDto.getPrenom());
        }
    }

    public void getEpreuveSansTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du tournoi");
        Long id=sc.nextLong();
        EpreuveLiteDto epreuve=this.epreuveService.getEpreuveSansTournoi(id);
        System.out.println("L'annee de l'epreuve selectionner est "+epreuve.getAnnee());
    }
}
