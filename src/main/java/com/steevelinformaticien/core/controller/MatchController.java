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

    public void getMatch(){
        Scanner sc=new Scanner(System.in);
        System.out.println("veuillez saisir l'ID du Match");
        Long id=sc.nextLong();
        MatchDto matchDto=this.matchService.getMatch(id);
        System.out.println("le nom et le prenom du vainqueur sont : "+ matchDto.getVainqueur().getNom()+" "+matchDto.getVainqueur().getPrenom());
        System.out.println("le nom et le prenom du finaliste sont : "+ matchDto.getFinaliste().getNom()+" "+matchDto.getFinaliste().getPrenom());
    }

}
