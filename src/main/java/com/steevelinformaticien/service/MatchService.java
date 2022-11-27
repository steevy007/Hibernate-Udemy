/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.dto.EpreuveLiteDto;
import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.core.dto.MatchDto;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.repository.MatchRepositoryImpl;
import com.steevelinformaticien.core.repository.ScoreRepositoryImpl;
import com.steevelinformaticien.core.entity.Match;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEPECELL
 */
public class MatchService {
    
    private MatchRepositoryImpl matchImpl;
    private ScoreRepositoryImpl scoreImpl;
    
    public MatchService(){
        this.matchImpl=new MatchRepositoryImpl();
        this.scoreImpl=new ScoreRepositoryImpl();
    }
    
    public boolean createMatch(Match match){
       if(this.matchImpl.create(match))
           if(this.scoreImpl.create(match.getScore()))
               return true;  
        return false;
    }


    public MatchDto getMatch(Long id){
        Session session=null;
        Transaction tx=null;
        Match match=null;
        MatchDto matchDto=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            //System.out.println("Epreuveeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            match=matchImpl.getById(id);
            matchDto=new MatchDto();
            matchDto.setId(match.getId());
            //creer finaliste
            JoueurDto joueurDtoFinaliste=new JoueurDto();
            joueurDtoFinaliste.setId(match.getFinaliste().getId());
            joueurDtoFinaliste.setNom(match.getFinaliste().getNom());
            joueurDtoFinaliste.setPrenom(match.getFinaliste().getPrenom());
            joueurDtoFinaliste.setSexe(match.getFinaliste().getSexe());
            matchDto.setFinaliste(joueurDtoFinaliste);
            //creer vainqueur
            JoueurDto joueurDtoVainqueur=new JoueurDto();
            joueurDtoVainqueur.setId(match.getVainqueur().getId());
            joueurDtoVainqueur.setNom(match.getVainqueur().getNom());
            joueurDtoVainqueur.setPrenom(match.getVainqueur().getPrenom());
            joueurDtoVainqueur.setSexe(match.getVainqueur().getSexe());
            matchDto.setVainqueur(joueurDtoVainqueur);
            tx.commit();

            //epreuveDto.setTournoi(epreuve.getTournoi());
            return matchDto;
        }catch(Exception e){
            //System.out.println(e);
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
        return null;
    }
}
