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
 * @author PEPECELL
 */
public class JoueurRepositoyImpl {


    public void create(Joueur joueur) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(joueur);
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

        Joueur joueur=getById(id);

        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(joueur);

        System.out.println("joueur supprimer !!!");
    }

    public Joueur getById(Long id) {
        //Connection conn = null;
        Joueur joueur = null;
        Session session = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        joueur = (Joueur) session.get(Joueur.class, id);
        System.out.println("joueur lu");


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
                joueur = new Joueur();
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
