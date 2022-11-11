/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
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

/**
 *
 * @author PEPECELL
 */
public class TournoiRepositoryImpl {
    public Long create(Tournoi tournoi){
        Session session=null;
        Transaction tx=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            tx= session.beginTransaction();
            session.persist(tournoi);
            tx.commit();

            System.out.println("Le tournoi est creer avec  id : "+tournoi.getId());

            return tournoi.getId();
        }catch(Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            if(session!=null)
                session.close();
        }
        return null;
    }
    
    public boolean update(Tournoi tournoi){
        Connection conn=null;
        try{
            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            conn=datasource.getConnection();
            PreparedStatement stm=conn.prepareStatement("UPDATE TOURNOI SET nom=? , code=? WHERE id=?");
            stm.setString(1, tournoi.getNom());
            stm.setString(2, tournoi.getCode());
            stm.setLong(3,tournoi.getId());
            int affect=stm.executeUpdate();
            if(affect==1){
                conn.commit();
                return true;
            }
            
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
        
        return false;
    }
    
     public boolean delete(Long id){
        Connection conn=null;
        try{
            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            conn=datasource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement stm=conn.prepareStatement("DELETE FROM TOURNOI WHERE id=?");
            stm.setLong(1, id);
            int affect=stm.executeUpdate();
            if(affect==1){
                conn.commit();
                return true;
            }

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

        return false;
    }
     
     public Tournoi getById(Long id){
         Session session= HibernateUtil.getSessionFactory().openSession();
         Tournoi tournoi=null;
         try{
             tournoi=(Tournoi) session.get(Tournoi.class,id);

             System.out.println("Les Tournoi selectionner est : "+tournoi.getNom());
         }
         catch(Exception e){
             e.printStackTrace();
         }finally {
             if(session!=null)
                 session.close();
         }

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
