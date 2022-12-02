/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.dto.JoueurDto;
import com.steevelinformaticien.core.repository.JoueurRepositoyImpl;
import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.core.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PEPECELL
 */
public class JoueurService {
    private JoueurRepositoyImpl joueurImpl;

    public JoueurService() {
        this.joueurImpl=new JoueurRepositoyImpl();
        
    }

    public List<JoueurDto> getListJ(){
        Transaction tx=null;
        Session session=null;
        List<JoueurDto> joueurDtoList=new ArrayList<>();
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            List<Joueur> list=this.joueurImpl.list();

            for(Joueur joueur:list){
                JoueurDto joueurDto=new JoueurDto();
                joueurDto.setId(joueur.getId());
                joueurDto.setNom(joueur.getNom());
                joueurDto.setPrenom(joueur.getPrenom());
                joueurDto.setSexe(joueur.getSexe());
                joueurDtoList.add(joueurDto);
            }

            tx.commit();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
        return joueurDtoList;
    }
    
    public void createJoueur(Joueur joueur){
        Transaction tx=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            this.joueurImpl.create(joueur);
            tx.commit();
            System.out.println("Identifiant Joueur est  "+joueur.getId());
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }


    }
    
    
    public Joueur getJoueur(Long id){
        Joueur joueur=null;
        Transaction tx=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            joueur=this.joueurImpl.getById(id);
            tx.commit();
            System.out.println("Identifiant Joueur est  "+joueur.getId());
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

        return joueur;
    }
    
    public List<Joueur> getListJoueur(){
        return this.joueurImpl.list();
    }
    
    
    public void updateJoueur(Joueur joueur){
        this.joueurImpl.update(joueur);
    }
    
    
    public void deleteJoueur(Long id){
        Transaction tx=null;
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            this.joueurImpl.delete(id);
            tx.commit();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
        }finally {
            if(session!=null)
                session.close();
        }
    }

    public void rename(Long id,String name){
        Joueur joueur=getJoueur(id);
        Transaction tx=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            joueur.setNom("Ou fenk Modifier la ");
            Joueur joueur1=(Joueur) session.merge(joueur);
            tx.commit();
            System.out.println(joueur1.toString());
            System.out.println("le nom du joueur modifier est "+joueur.getNom());
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }

    }


    public void modifySexe(Long id,char sexe){
        Joueur joueur=this.getJoueur(id);
        Transaction tx=null;
        Session session=null;

        try{
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            tx= session.beginTransaction();
            joueur.setSexe(sexe);
            Joueur joueur1=(Joueur) session.merge(joueur);
            tx.commit();
            System.out.println("le sexe de "+joueur1.getNom()+" a ete modifier ");
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();

        }

    }

    
}
