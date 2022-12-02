package com.steevelinformaticien.core.controller;

import com.steevelinformaticien.core.dto.EpreuveFullDto;
import com.steevelinformaticien.core.dto.EpreuveLiteDto;
import com.steevelinformaticien.core.dto.MatchDto;
import com.steevelinformaticien.service.EpreuveService;
import com.steevelinformaticien.service.MatchService;

import java.util.Scanner;

public class MatchController {
    private MatchService matchService;

    public MatchController(){
        this.matchService=new MatchService();
    }


    public void tapisVert(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du Match vous voulez annuler");
        Long id=sc.nextLong();

        matchService.tapisVert(id);

    }

    public void supprimerMatch(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du Match a supprimer");
        Long id=sc.nextLong();

        matchService.deleteMatch(id);
    }

    public void getMatch(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du Match");
        Long id=sc.nextLong();
        MatchDto matchDto=this.matchService.getMatch(id);
        System.out.println("Il s'agit d'un match de "+matchDto.getEpreuveFullDto().getAnnee()+" qui s'est deroule a "+matchDto.getEpreuveFullDto().getTournoi().getNom());
        System.out.println("le nom et le prenom du vainqueur sont : "+ matchDto.getVainqueur().getNom()+" "+matchDto.getVainqueur().getPrenom());
        System.out.println("le nom et le prenom du finaliste sont : "+ matchDto.getFinaliste().getNom()+" "+matchDto.getFinaliste().getPrenom());

        System.out.println("Les sets du scire sont");
        System.out.println("Set 1 : "+matchDto.getScoreFullDto().getSet1());
        System.out.println("Set 2 : "+matchDto.getScoreFullDto().getSet2());
        System.out.println("Set 3 : "+(matchDto.getScoreFullDto().getSet3()!=null?matchDto.getScoreFullDto().getSet3():0));
        System.out.println("Set 4 : "+(matchDto.getScoreFullDto().getSet4()!=null?matchDto.getScoreFullDto().getSet4():0));
        System.out.println("Set 5 : "+(matchDto.getScoreFullDto().getSet5()!=null?matchDto.getScoreFullDto().getSet5():0));
    }

}
