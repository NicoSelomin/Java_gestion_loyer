package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.domain.*;

import java.util.List;

public interface IActionProprietaire {

    List<Paiement> suivrePaiements();

    boolean ajouterContrat(Locataire locataire, BienImmobilier bien);

    boolean ajouterBien(BienImmobilier bien);

    boolean modifierInfoBien(String idBien);

    void lierBienLocataire(BienImmobilier bien, Locataire locataire);

    boolean envoyerRappel(Rappel rappel, Locataire locataire);
}
