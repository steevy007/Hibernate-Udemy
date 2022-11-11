/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.core;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author PEPECELL
 */
public class DatasourceProvider {

    private static BasicDataSource datasource=null;

    public static BasicDataSource getSingleDatasource() {
        if (datasource == null) {
            datasource=new BasicDataSource();
            datasource.setInitialSize(5);
            datasource.setUrl("jdbc:mysql://localhost:3306/tennis");
            datasource.setUsername("root");
            datasource.setPassword("Steevy@2017");
            
        }
        return datasource;
    }
}
