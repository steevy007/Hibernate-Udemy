/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.dto.*;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Score;
import com.steevelinformaticien.core.repository.EpreuveRepositoryImpl;
import com.steevelinformaticien.core.repository.JoueurRepositoyImpl;
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

    private EpreuveRepositoryImpl epreuveImpl;

    private JoueurRepositoyImpl joueurImpl;
    
    public MatchService(){
        this.matchImpl=new MatchRepositoryImpl();
        this.scoreImpl=new ScoreRepositoryImpl();
        this.epreuveImpl=new EpreuveRepositoryImpl();
        this.joueurImpl=new JoueurRepositoyImpl();
    }


    public void createMatch(MatchDto t){
        Session session=null;
        Transaction tx=null;
        Match match=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();

            match=new Match();
            match.setEpreuve(epreuveImpl.getById(t.getEpreuveFullDto().getId()));
            match.setVainqueur(joueurImpl.getById(t.getVainqueur().getId()));
            match.setFinaliste(joueurImpl.getById(t.getFinaliste().getId()));

            Score score=new Score();
            score.setMatch(match);
            match.setScore(score);
            score.setSet1(t.getScoreFullDto().getSet1());
            score.setSet2(t.getScoreFullDto().getSet1());
            score.setSet3(t.getScoreFullDto().getSet1());
            score.setSet4(t.getScoreFullDto().getSet1());
            score.setSet5(t.getScoreFullDto().getSet1());

            matchImpl.create(match);

            tx.commit();
        }catch(Exception e){
            //System.out.println(e);
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
    }


    public void tapisVert(Long id){
        Session session=null;
        Transaction tx=null;
        Match match=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            match=this.matchImpl.getById(id);
            Joueur ancienvainqueur=match.getVainqueur();
            match.setVainqueur(match.getFinaliste());
            match.setFinaliste(ancienvainqueur);

            match.getScore().setSet1((byte)0);
            match.getScore().setSet2((byte)0);
            match.getScore().setSet3((byte)0);
            match.getScore().setSet4((byte)0);
            match.getScore().setSet5((byte)0);

            tx.commit();

        }catch(Exception e){
            //System.out.println(e);
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
    }


    public MatchDto getMatch(Long id){
        Session session=null;
        Transaction tx=null;
        Match match=null;
        MatchDto matchDto=null;
        EpreuveFullDto epreuveDto=null;
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

            //creation epreuve
            epreuveDto=new EpreuveFullDto();
            epreuveDto.setId(match.getEpreuve().getId());
            epreuveDto.setAnnee(match.getEpreuve().getAnnee());
            epreuveDto.setTypeEpreuve(match.getEpreuve().getTypeEpreuve());
            TournoiDto tournoiDto=new TournoiDto();
            tournoiDto.setId(match.getEpreuve().getTournoi().getId());
            tournoiDto.setCode(match.getEpreuve().getTournoi().getCode());
            tournoiDto.setNom(match.getEpreuve().getTournoi().getNom());
            epreuveDto.setTournoi(tournoiDto);

            matchDto.setEpreuveFullDto(epreuveDto);

            ScoreFullDto scoreFullDto=new ScoreFullDto();
            scoreFullDto.setId(match.getScore().getId());
            scoreFullDto.setSet1(match.getScore().getSet1());
            scoreFullDto.setSet2(match.getScore().getSet2());
            scoreFullDto.setSet3(match.getScore().getSet3());
            scoreFullDto.setSet4(match.getScore().getSet4());
            scoreFullDto.setSet5(match.getScore().getSet5());

            matchDto.setScoreFullDto(scoreFullDto);
            scoreFullDto.setMatchDto(matchDto);

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
