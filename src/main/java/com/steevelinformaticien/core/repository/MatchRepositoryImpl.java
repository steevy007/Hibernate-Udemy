/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.DatasourceProvider;
import com.steevelinformaticien.core.TestDeConnetion;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import com.steevelinformaticien.core.entity.Match;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;

/**
 *
 * @author PEPECELL
 */
public class MatchRepositoryImpl {

    public Match getById(Long id){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
       Match match=session.get(Match.class,id);
        return match;
    }

    public void create(Match match) {
      Session session=HibernateUtil.getSessionFactory().getCurrentSession();
      session.persist(match);
        System.out.println("Match creer");
    }

    public void delete(Long id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Match match=session.get(Match.class,id);
        session.delete(match);
        System.out.println("Match Supprimer");

    }
}
