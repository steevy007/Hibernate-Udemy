/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.DatasourceProvider;
import com.steevelinformaticien.core.TestDeConnetion;
import com.steevelinformaticien.core.entity.Match;
import com.steevelinformaticien.core.entity.Score;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;

/**
 *
 * @author PEPECELL
 */
public class ScoreRepositoryImpl {
    public boolean create(Score score) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("INSERT INTO SCORE_VAINQUEUR(ID_MATCH,SET_1,SET_2,SET_3,SET_4,SET_5) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statment.setLong(1, score.getMatch().getId());
            statment.setByte(2,score.getSet1());
            statment.setByte(3, score.getSet2());
            statment.setByte(4, score.getSet3());
            if(score.getSet4()==null){
                statment.setNull(5,Types.TINYINT);
            }else{
                statment.setByte(5, score.getSet4());
            }
            
            if(score.getSet4()==null){
                statment.setNull(6,Types.TINYINT);
            }else{
               statment.setByte(6, score.getSet5());
            }
               
            

            statment.executeUpdate();
            ResultSet rs = statment.getGeneratedKeys();
            //conn.commit();
            if (rs.next()) {
                System.out.println("insert Score=>  " + rs.getLong(1));
                score.setId(rs.getLong(1));
                return true;
            }

            statment.close();

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
        return false;
    }

    public Score getById(Long id){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        Score score=session.get(Score.class,id);
        return score;
    }

    public void delete(Long id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
       Score score=session.get(Score.class,id);
        session.delete(score);
        System.out.println("Score Supprimer");

    }
}
