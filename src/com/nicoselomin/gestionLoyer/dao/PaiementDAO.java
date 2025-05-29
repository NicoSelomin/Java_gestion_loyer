package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Paiement;
import java.util.List;

public interface PaiementDAO {
    boolean save(Paiement paiement, String contratReference);
    List<Paiement> findByContrat(String contratReference);
    List<Paiement> findAll();
    boolean delete(Paiement paiement, String contratReference);
}
