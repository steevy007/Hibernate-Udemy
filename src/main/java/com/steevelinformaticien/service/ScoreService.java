package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.dto.EpreuveFullDto;
import com.steevelinformaticien.core.dto.MatchDto;
import com.steevelinformaticien.core.dto.ScoreFullDto;
import com.steevelinformaticien.core.dto.TournoiDto;
import com.steevelinformaticien.core.entity.Score;
import com.steevelinformaticien.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ScoreService {
    private ScoreRepositoryImpl scoreRepository;

    public ScoreService() {
        this.scoreRepository = new ScoreRepositoryImpl();
    }

    public ScoreFullDto getScore(Long id){
        Session session=null;
        Transaction tx=null;
        Score score=null;
        ScoreFullDto scoreFullDto=null;
        EpreuveFullDto epreuveDto=null;
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            score=this.scoreRepository.getById(id);

            scoreFullDto=new ScoreFullDto();
            scoreFullDto.setId(score.getId());
            scoreFullDto.setSet1(score.getSet1());
            scoreFullDto.setSet2(score.getSet2());
            scoreFullDto.setSet3(score.getSet3());
            scoreFullDto.setSet4(score.getSet4());
            scoreFullDto.setSet5(score.getSet5());

            MatchDto matchDto=new MatchDto();
            matchDto.setId(score.getMatch().getId());

            scoreFullDto.setMatchDto(matchDto);


            epreuveDto=new EpreuveFullDto();
            epreuveDto.setId(score.getMatch().getEpreuve().getId());
            epreuveDto.setAnnee(score.getMatch().getEpreuve().getAnnee());
            epreuveDto.setTypeEpreuve(score.getMatch().getEpreuve().getTypeEpreuve());

            TournoiDto tournoiDto=new TournoiDto();
            tournoiDto.setId(score.getMatch().getEpreuve().getTournoi().getId());
            tournoiDto.setNom(score.getMatch().getEpreuve().getTournoi().getNom());
            tournoiDto.setCode(score.getMatch().getEpreuve().getTournoi().getCode());
            epreuveDto.setTournoi(tournoiDto);

            matchDto.setEpreuveFullDto(epreuveDto);

            return scoreFullDto;

        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
        return  null;
    }

}
