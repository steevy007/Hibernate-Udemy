package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.TournoiDto;
import com.steevelinformaticien.service.TournoiService;

import java.util.Scanner;

public class TournoiController {
    private TournoiService tournoiService;


    public TournoiController(){
        this.tournoiService=new TournoiService();
    }

    public void afficherTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuiller saisir l'identifiant du tournoi");
        Long id=sc.nextLong();
        TournoiDto tournoiDto=this.tournoiService.getTournoi(id);

        System.out.println("Le tournoi selectionner est : "+tournoiDto.getNom());
    }


    public void creerTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("ceuillez saisir le nom du tournoi");
        String nom=sc.nextLine();
        System.out.println("veuillez saisr le code du tournoi");
        String code=sc.nextLine();

        TournoiDto tournoiDto=new TournoiDto();
        tournoiDto.setNom(nom);
        tournoiDto.setCode(code);

        this.tournoiService.createTournoi(tournoiDto);

    }


    public void updateTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir id fu tournoi");
        Long id=sc.nextLong();
        sc.nextLine();
        System.out.println("veuillez saisir le noiveau nom du tournoi");
        String newName=sc.nextLine();
        this.tournoiService.upadateTournoi(id,newName);
    }

    public void deleteTournoi(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuillez saisir Id du tournoi a supprimer");
        Long id=sc.nextLong();

        this.tournoiService.deleteTournoi(id);
    }
}
