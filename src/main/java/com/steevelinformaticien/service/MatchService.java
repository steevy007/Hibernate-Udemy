/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.core.repository.MatchRepositoryImpl;
import com.steevelinformaticien.core.repository.ScoreRepositoryImpl;
import com.steevelinformaticien.core.entity.Match;

/**
 *
 * @author PEPECELL
 */
public class MatchService {
    
    private MatchRepositoryImpl matchImpl;
    private ScoreRepositoryImpl scoreImpl;
    
    public MatchService(){
        this.matchImpl=new MatchRepositoryImpl();
        this.scoreImpl=new ScoreRepositoryImpl();
    }
    
    public boolean createMatch(Match match){
       if(this.matchImpl.create(match))
           if(this.scoreImpl.create(match.getScore()))
               return true;  
        return false;
    }
}
