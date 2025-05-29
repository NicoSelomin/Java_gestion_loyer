package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.domain.BienImmobilier;
import com.nicoselomin.gestionLoyer.domain.ContratLocation;
import com.nicoselomin.gestionLoyer.domain.Paiement;

import java.util.ArrayList;
import java.util.List;

public class LocataireServices implements IActionLocataire {

    @Override
    public boolean enregistrerUnPaiementManuel(String email, ContratLocation contrat) {
        // Simuler l'enregistrement d’un paiement manuel
        System.out.println("📥 Paiement manuel enregistré pour " + email + " - Contrat ref: " + contrat.getReference());
        return true;
    }

    @Override
    public void telechargerQuitance(Paiement paiement) {
        // Simuler un téléchargement de quittance
        System.out.println("📄 Téléchargement de la quittance pour le paiement ID: " + paiement.getIdPaiement());
    }

    @Override
    public void consulterHistoriquePaiement() {
        // Simuler une consultation
        System.out.println("📊 Historique des paiements affiché.");
    }

    @Override
    public List<BienImmobilier> consulterLocations() {
        // Simuler une liste vide
        System.out.println("🏠 Liste des biens loués affichée.");
        return new ArrayList<>();
    }
}
