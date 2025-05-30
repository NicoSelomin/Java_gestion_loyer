package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.dao.PaiementDAO;
import com.nicoselomin.gestionLoyer.dao.PaiementDAOImpl;
import com.nicoselomin.gestionLoyer.domain.Paiement;

import java.util.List;

public class PaiementServices {

    private final PaiementDAO dao = new PaiementDAOImpl();

    public boolean enregistrerPaiement(Paiement paiement, String contratReference) {
        return dao.save(paiement, contratReference);
    }

    public List<Paiement> consulterPaiements(String contratReference) {
        return dao.findByContrat(contratReference);
    }

    public List<Paiement> listerTousLesPaiements() {
        return dao.findAll();
    }

    public boolean supprimerPaiement(Paiement paiement, String contratReference) {
        return dao.delete(paiement, contratReference);
    }
}
