package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.dto.EpreuveFullDto;
import com.steevelinformaticien.core.dto.EpreuveLiteDto;
import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.core.dto.TournoiDto;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.repository.EpreuveRepositoryImpl;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

public class EpreuveService {
    private EpreuveRepositoryImpl epreuveRepository;

    public EpreuveService(){
        this.epreuveRepository=new EpreuveRepositoryImpl();
    }
    public EpreuveFullDto getEpreuveDetaille(Long id){
        Session session=null;
        Transaction tx=null;
        Epreuve epreuve=null;
        EpreuveFullDto epreuveDto=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            //System.out.println("Epreuveeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            epreuve=epreuveRepository.getById(id);
            //Hibernate.initialize(epreuve.getTournoi());

            epreuveDto=new EpreuveFullDto();
            epreuveDto.setId(epreuve.getId());
            epreuveDto.setAnnee(epreuve.getAnnee());
            epreuveDto.setTypeEpreuve(epreuve.getTypeEpreuve());

            TournoiDto tournoiDto=new TournoiDto();
            tournoiDto.setId(epreuve.getTournoi().getId());
            tournoiDto.setNom(epreuve.getTournoi().getNom());
            tournoiDto.setCode(epreuve.getTournoi().getCode());
            epreuveDto.setTournoi(tournoiDto);

            epreuveDto.setParticipants(new HashSet<>());
            for(Joueur joueur: epreuve.getParticipants()){
                final JoueurDto joueurDto=new JoueurDto();
                joueurDto.setId(joueur.getId());
                joueurDto.setPrenom(joueur.getPrenom());
                joueurDto.setNom(joueur.getNom());
                joueurDto.setSexe(joueur.getSexe());

                epreuveDto.getParticipants().add(joueurDto);
            }

            tx.commit();
            return epreuveDto;
        }catch(Exception e){
            System.out.println(e);
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }

        return null;
    }


    public EpreuveLiteDto getEpreuveSansTournoi(Long id){
        Session session=null;
        Transaction tx=null;
        Epreuve epreuve=null;
        EpreuveLiteDto epreuveDto=null;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx=session.beginTransaction();
            //System.out.println("Epreuveeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            epreuve=epreuveRepository.getById(id);
            tx.commit();
            epreuveDto=new EpreuveLiteDto();
            epreuveDto.setId(epreuve.getId());
            epreuveDto.setAnnee(epreuve.getAnnee());
            epreuveDto.setTypeEpreuve(epreuve.getTypeEpreuve());
            //epreuveDto.setTournoi(epreuve.getTournoi());
            return epreuveDto;
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
