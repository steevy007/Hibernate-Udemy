package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.entity.Epreuve;
import com.steevelinformaticien.core.entity.Joueur;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EpreuveRepositoryImpl {
    public Epreuve getById(Long id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Epreuve epreuve=session.get(Epreuve.class,id);
        return epreuve;
    }


    public List<Epreuve> list(String codeTournoi) {
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Query<Epreuve> query=session.createQuery("select e from Epreuve e where e.tournoi.code=?0",Epreuve.class);
        query.setParameter(0,codeTournoi);
        List<Epreuve> listEpreuve=query.getResultList();
        return listEpreuve;
    }
}
