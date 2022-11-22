/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.core.entity.Tournoi;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    
    public Long createTournoi(Tournoi tournoi){
        return this.tournoiImpl.create(tournoi);
    }
    
    public boolean upadateTournoi(Tournoi tournoi){
        return this.tournoiImpl.update(tournoi);
    }
    
    public List<Tournoi> getListTournoi(){
        return this.tournoiImpl.list();
    }
    
    public Tournoi getTournoi(Long id){
        return this.tournoiImpl.getById(id);
    }
    
    public void deleteTournoi(Long id){
        Session session=null;
        Transaction transaction=null;
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            transaction= session.beginTransaction();
            this.tournoiImpl.delete(id);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null)
                transaction.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
    }
    
    
}
