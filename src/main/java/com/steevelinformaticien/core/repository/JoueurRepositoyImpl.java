/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.DatasourceProvider;
import com.steevelinformaticien.core.TestDeConnetion;
import com.steevelinformaticien.core.entity.Joueur;
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
public class JoueurRepositoyImpl {

    public void create(Joueur joueur) {
       Session session=null;
        Transaction tx=null;
       try{
           session=HibernateUtil.getSessionFactory().openSession();
           tx=session.beginTransaction();
          session.persist(joueur);
          tx.commit();
           System.out.println("Le joueur a ete creer et a pour id : "+joueur.getId());
       }catch (Exception e){
           e.printStackTrace();
           if(tx!=null)
               tx.rollback();
       }finally {
           if(session!=null)
               session.close();
       }
    }

    public void update(Joueur joueur) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("UPDATE JOUEUR SET NOM=? , PRENOM=? , SEXE=? WHERE ID=?");
            statment.setString(1, joueur.getNom());
            statment.setString(2, joueur.getPrenom());
            statment.setString(3, joueur.getSexe().toString());
            statment.setLong(4, joueur.getId());

            statment.executeUpdate();
            //conn.commit();
            statment.close();
            System.out.println("update joueur");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(TestDeConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("DELETE FROM JOUEUR WHERE ID=?");
            statment.setLong(1, id);
            statment.executeUpdate();
            conn.commit();
            statment.close();
            System.out.println("delete joueur");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(TestDeConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Joueur getById(Long id) {
        //Connection conn = null;
        Joueur joueur=null;
        Session session=null;
        try {
            
            session=HibernateUtil.getSessionFactory().openSession();
            joueur=(Joueur)session.get(Joueur.class,id);
            System.out.println("joueur lu");
            
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            /*BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("SELECT * FROM JOUEUR WHERE ID=?");
            statment.setLong(1, id);
            ResultSet rs = statment.executeQuery();

            if (rs.next()) {
                joueur=new Joueur();
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
                joueur.setId(rs.getLong("ID"));
            }

            //conn.commit();
            statment.close();*/
            System.out.println("Le Joueur selectionner se nomme  : "+joueur.getNom());
        }catch(Throwable t){
            t.printStackTrace();
        } /*catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(TestDeConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } */finally {
            if(session!=null)
                session.close();
            /*try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }

        return joueur;
    }

    public List<Joueur> list() {
        Connection conn = null;
        Joueur joueur = null;
        List<Joueur> list = new ArrayList();
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("SELECT * FROM JOUEUR ");
            ResultSet rs = statment.executeQuery();

            while (rs.next()) {
                joueur=new Joueur();
                joueur.setId(rs.getLong("ID"));
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));

                list.add(joueur);
            }

            //conn.commit();
            statment.close();
            System.out.println("Liste Joueurs");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(TestDeConnetion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
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
