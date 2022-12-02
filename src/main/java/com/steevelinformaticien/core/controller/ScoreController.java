package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.ScoreFullDto;
import com.steevelinformaticien.service.ScoreService;

import java.util.Scanner;

public class ScoreController {
    private ScoreService scoreService;

    public ScoreController() {
        this.scoreService =new ScoreService();
    }

    public void afficherScore(){
        Scanner sc=new Scanner(System.in);
        System.out.println("saisir l'identifiant du score sont vous voulez les informations !");
        long id=sc.nextLong();
        ScoreFullDto scoreFullDto=scoreService.getScore(id);
        System.out.println("Les sets du scire sont");
        System.out.println("Set 1 : "+scoreFullDto.getSet1());
        System.out.println("Set 2 : "+scoreFullDto.getSet2());
        System.out.println("Set 3 : "+(scoreFullDto.getSet3()!=null?scoreFullDto.getSet3():0));
        System.out.println("Set 4 : "+(scoreFullDto.getSet4()!=null?scoreFullDto.getSet4():0));
        System.out.println("Set 5 : "+(scoreFullDto.getSet5()!=null?scoreFullDto.getSet5():0));

        System.out.println("Il s'agit du tournoie "+scoreFullDto.getMatchDto().getEpreuveFullDto().getTournoi().getNom());
        System.out.println("L'epreuve s est deroule en "+scoreFullDto.getMatchDto().getEpreuveFullDto().getAnnee()+" et il s'agissait d'une epreuve "+(scoreFullDto.getMatchDto().getEpreuveFullDto().getTypeEpreuve().charValue()=='H'?"HOMME":"FEMME"));
    }

    public void supprimerScore(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du Score a supprimer");
        Long id=sc.nextLong();

        scoreService.deleteScore(id);
    }
}
