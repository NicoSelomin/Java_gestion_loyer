package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.domain.ContratLocation;
import com.nicoselomin.gestionLoyer.domain.Paiement;
import com.nicoselomin.gestionLoyer.domain.BienImmobilier;

import java.util.List;

public interface IActionLocataire {

    boolean enregistrerUnPaiementManuel(String email, ContratLocation contrat);
    void telechargerQuitance(Paiement paiement);
    void consulterHistoriquePaiement();
    List<BienImmobilier> consulterLocations();
}
