/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.controller.EpreuveController;
import com.steevelinformaticien.core.controller.JoueurController;
import com.steevelinformaticien.core.controller.MatchController;
import com.steevelinformaticien.core.controller.ScoreController;
import com.steevelinformaticien.core.entity.Tournoi;
import com.steevelinformaticien.core.repository.JoueurRepositoyImpl;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.service.EpreuveService;
import com.steevelinformaticien.service.JoueurService;
import com.steevelinformaticien.service.TournoiService;

import java.util.List;

/**
 * @author PEPECELL
 */

public class TestDeConnetion {

    public static void main(String... args) {
        JoueurService impl = new JoueurService();
        /*System.out.println("Lecture d'un joueur");
        impl.getJoueur(10L);
        System.out.println("----------------------------------------------------");
        TournoiService tournoi=new TournoiService();
        System.out.println("Lecture d'un Tournoi");
        tournoi.getTournoi(10L);
        System.out.println("____________________________________________________");
        //cration d'un joueur
        Joueur joueur = new Joueur();
        joueur.setNom("Kanou");
        joueur.setPrenom("Bling");
        joueur.setSexe(("F").charAt(0));
        impl.createJoueur(joueur);
    /*
        System.out.println("-------------------------------------------------------");
        //creer Tournoi
        Tournoi tournoi=new Tournoi();
        tournoi.setNom("Championnat Lakay");
        tournoi.setCode("LK");

        TournoiService tournoiService=new TournoiService();
        tournoiService.createTournoi(tournoi);
*/
        System.out.println("-----------------------------------------------------------------");
        //renommer un joueur
       // impl.deleteJoueur(10L);


        //delete Tournoi

       // EpreuveController epreuveController=new EpreuveController();
       //epreuveController.getEpreuveAvecTournoi();
        //epreuveController.getEpreuveSansTournoi();

        //impl.getJoueur(10L);

        //MatchController matchController=new MatchController();
        //matchController.supprimerMatch();

        //ScoreController scoreController=new ScoreController();
        //scoreController.supprimerScore();

        JoueurController joueurController=new JoueurController();
        joueurController.listeJoueur();
    }
}
