/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.service;

import com.steevelinformaticien.core.repository.JoueurRepositoyImpl;
import com.steevelinformaticien.core.repository.TournoiRepositoryImpl;
import com.steevelinformaticien.core.entity.Joueur;
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
    
    public void createJoueur(Joueur joueur){
        this.joueurImpl.create(joueur);
    }
    
    
    public Joueur getJoueur(Long id){
        return this.joueurImpl.getById(id);
    }
    
    public List<Joueur> getListJoueur(){
        return this.joueurImpl.list();
    }
    
    
    public void updateJoueur(Joueur joueur){
        this.joueurImpl.update(joueur);
    }
    
    
    public void deleteJoueur(Long id){
        this.joueurImpl.delete(id);
    }
    
}
