/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.EntityManagerHolder;
import com.steevelinformaticien.core.dto.TournoiDto;
import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.core.entity.Tournoi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author PEPECELL
 */
public class TournoiService {
    private TournoiRepositoryImpl tournoiImpl;

    public TournoiService() {
        this.tournoiImpl=new TournoiRepositoryImpl();
    }
    
    public void createTournoi(TournoiDto tournoi){
        EntityManager em=null;
        EntityTransaction transaction=null;
        try{
            em= new EntityManagerHolder().getCurrentEntityManager();
            transaction= em.getTransaction();
            transaction.begin();
            Tournoi t=new Tournoi();
            t.setCode(tournoi.getCode());
            t.setNom(tournoi.getNom());
            //t.setId(tournoi.getId());
            this.tournoiImpl.create(t);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }finally {
            if(em!=null)
                em.close();
        }
    }
    
    public void upadateTournoi(Long id, String nom){
        TournoiDto tournoiDto=getTournoi(id);
        EntityManager em=null;
        EntityTransaction transaction=null;
        Tournoi tournoi=null;
        try{
            em= new EntityManagerHolder().getCurrentEntityManager();
            transaction= em.getTransaction();
            transaction.begin();
            tournoi=new Tournoi();
            tournoi.setId(tournoiDto.getId());
            tournoi.setNom(nom);
            tournoi.setCode(tournoiDto.getCode());
            em.persist(tournoi);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }finally {
            if(em!=null)
                em.close();
        }


        }
    
    public List<Tournoi> getListTournoi(){
        return this.tournoiImpl.list();
    }
    
    public TournoiDto getTournoi(Long id){
        EntityManager em=null;
        EntityTransaction transaction=null;
        TournoiDto tournoiDto=null;
        Tournoi tournoi=null;
        try{
            em= new EntityManagerHolder().getCurrentEntityManager();
            transaction= em.getTransaction();
            transaction.begin();
            tournoi=this.tournoiImpl.getById(id);
            tournoiDto=new TournoiDto();
            tournoiDto.setNom(tournoi.getNom());
            tournoiDto.setCode(tournoi.getCode());
            tournoiDto.setId(tournoi.getId());
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }finally {
            if(em!=null)
                em.close();
        }

        return tournoiDto;
    }
    
    public void deleteTournoi(Long id){
        EntityManager em=null;
        EntityTransaction transaction=null;
        try{
            em= new EntityManagerHolder().getCurrentEntityManager();
            transaction= em.getTransaction();
            transaction.begin();
            this.tournoiImpl.delete(id);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }finally {
            if(em!=null)
                em.close();
        }
    }
    
    
}
