package com.steevelinformaticien.core.repository;

import com.steevelinformaticien.HibernateUtil;
import com.steevelinformaticien.core.entity.Epreuve;
import org.hibernate.Session;

public class EpreuveRepositoryImpl {
    public Epreuve getById(Long id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Epreuve epreuve=session.get(Epreuve.class,id);
        return epreuve;
    }
}
