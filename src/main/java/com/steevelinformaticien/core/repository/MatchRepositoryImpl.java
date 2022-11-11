/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.core.DatasourceProvider;
import com.steevelinformaticien.core.TestDeConnetion;
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

/**
 *
 * @author PEPECELL
 */
public class MatchRepositoryImpl {

    public boolean create(Match match) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4 
            //Class.forName(DRIVER_CLASS_NAME);

            BasicDataSource datasource = DatasourceProvider.getSingleDatasource();
            //MySQL driver MySQL Connector
            conn = datasource.getConnection();
            PreparedStatement statment = conn.prepareStatement("INSERT INTO MATCH_TENNIS(ID_EPREUVE,ID_VAINQUEUR,ID_FINALISTE) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statment.setLong(1, match.getEpreuve().getId());
            statment.setLong(2, match.getVainqueur().getId());
            statment.setLong(3, match.getFinaliste().getId());

            statment.executeUpdate();
            ResultSet rs = statment.getGeneratedKeys();
            //conn.commit();
            if (rs.next()) {
                System.out.println("insert Match avec ID =>  " + rs.getLong(1));
                match.setId(rs.getLong(1));
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
}
