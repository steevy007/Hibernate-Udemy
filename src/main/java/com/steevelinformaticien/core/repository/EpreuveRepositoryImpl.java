package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.EntityManagerHolder;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EpreuveRepositoryImpl {
    public Epreuve getById(Long id){
        EntityManager em=new EntityManagerHolder().getCurrentEntityManager();
        Epreuve epreuve=em.find(Epreuve.class,id);
        return epreuve;
    }


    public List<Epreuve> list(String codeTournoi) {
        EntityManager em=new EntityManagerHolder().getCurrentEntityManager();
        TypedQuery<Epreuve> query=em.createQuery("select e from Epreuve e where e.tournoi.code=?0",Epreuve.class);
        query.setParameter(0,codeTournoi);
        List<Epreuve> listEpreuve=query.getResultList();
        return listEpreuve;
    }
}
