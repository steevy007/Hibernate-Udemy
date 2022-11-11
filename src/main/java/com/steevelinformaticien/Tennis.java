/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.steevelinformaticien;

import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Match;
import com.steevelinformaticien.core.entity.Score;
import com.steevelinformaticien.core.entity.Tournoi;
import com.steevelinformaticien.service.MatchService;
import com.steevelinformaticien.service.TournoiService;
import java.util.List;

/**
 *
 * @author PEPECELL
 */
public class Tennis {

    public static void main(String[] args) {
       /* TournoiService impl = new TournoiService();

        System.out.println("Add toutnoi");
        Tournoi add = new Tournoi(null, "AMERICAN", "AM");
        System.out.println("ID Tournoi Add => " + impl.createTournoi(add));
        System.out.println("Update Tournoi");
        Tournoi update = new Tournoi(8L, "NOM EDIT", "ED");
        if (impl.upadateTournoi(update)) {
            System.out.println("TOURNOI EDIT");
        }
        
        System.out.println("Delete");
        if(impl.deleteTournoi(8L))
            System.out.println("Tournoi Delete");
        
        System.out.println("Get Tournoi By ID");
        Tournoi getbyid=impl.getTournoi(1L);
        System.out.println("ID => "+getbyid.getId().toString()+" NOM => "+getbyid.getNom()+" CODE => "+getbyid.getCode());

        List<Tournoi> list = impl.getListTournoi();

        System.out.println("Listes Tournoi");
        for (Tournoi t : list) {
            System.out.println("ID => " + t.getId().toString() + " NOM => " + t.getNom() + " CODE => " + t.getCode());
        }*/
       
       
       MatchService matchservice=new MatchService();
       Match match=new Match();
       Score score=new Score();
       score.setSet1((byte)3);
       score.setSet2((byte)4);
       score.setSet3((byte)6);
       
       match.setScore(score);
       score.setMatch(match);
       Joueur federer=new Joueur();
       federer.setId(41L);
       Joueur nadal=new Joueur();
       nadal.setId(31L);
       match.setVainqueur(federer);
       match.setFinaliste(nadal);
       
       Epreuve epreuve=new Epreuve();
       epreuve.setId(9L);
       
       match.setEpreuve(epreuve);
       
       matchservice.createMatch(match);
       
       
       
       
    }
}
