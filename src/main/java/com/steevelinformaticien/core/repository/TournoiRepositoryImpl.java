/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.EntityManagerHolder;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Tournoi;
import com.steevelinformaticien.core.DatasourceProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

/**
 *
 * @author PEPECELL
 */
public class TournoiRepositoryImpl {
    public void create(Tournoi tournoi){
        EntityManager em=new EntityManagerHolder().getCurrentEntityManager();
        em.persist(tournoi);
        System.out.println("tournoi creer");
    }
    

    
     public void delete(Long id){
        EntityManager em=new EntityManagerHolder().getCurrentEntityManager();
        Tournoi tournoi=em.find(Tournoi.class,id);
        em.remove(tournoi);
         System.out.println("Tournoi Delete !!!!");
    }
     
     public Tournoi getById(Long id){
         EntityManager em=new EntityManagerHolder().getCurrentEntityManager();
         Tournoi tournoi=em.find(Tournoi.class,id);
         return tournoi;
    }
     
      public List<Tournoi> list(){
        Connection conn=null;
        List<Tournoi> list=new ArrayList();
        Tournoi tournoi=null;
        try{
            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            conn=datasource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement("SELECT * FROM TOURNOI ");
            
            ResultSet rs=stm.executeQuery();
            
            while(rs.next()){
               tournoi=new Tournoi(); 
               tournoi.setId(rs.getLong("ID"));
               tournoi.setNom(rs.getString("NOM"));
               tournoi.setCode(rs.getString("CODE"));
               list.add(tournoi);
            }
            conn.commit();
            rs.close();
            //return list;
        }catch(Exception e){
             e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(TournoiRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
}
