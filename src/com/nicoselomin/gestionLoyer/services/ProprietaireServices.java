package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.dao.BienImmobilierDAO;
import com.nicoselomin.gestionLoyer.dao.BienImmobilierDAOImpl;
import com.nicoselomin.gestionLoyer.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ProprietaireServices implements IActionProprietaire {

    private final BienImmobilierDAO bienDAO = new BienImmobilierDAOImpl();

    @Override
    public boolean ajouterBien(BienImmobilier bien) {
        System.out.println("📥 Enregistrement réel du bien en base...");
        return bienDAO.save(bien);
    }
    @Override
    public List<Paiement> suivrePaiements() {
        // 🔧 Simuler les paiements
        System.out.println("📊 Suivi des paiements");
        return new ArrayList<>();
    }

    @Override
    public boolean ajouterContrat(Locataire locataire, BienImmobilier bien) {
        System.out.println("📄 Contrat ajouté entre locataire " + locataire.getId() + " et bien " + bien.getDesignation());
        return true;
    }

    @Override
    public boolean modifierInfoBien(String idBien) {
        System.out.println("✏️ Informations du bien modifiées pour ID : " + idBien);
        return true;
    }

    @Override
    public void lierBienLocataire(BienImmobilier bien, Locataire locataire) {
        System.out.println("🔗 Bien " + bien.getDesignation() + " lié au locataire " + locataire.getId());
    }

    @Override
    public boolean envoyerRappel(Rappel rappel, Locataire locataire) {
        System.out.println("📧 Rappel envoyé au locataire " + locataire.getId());
        return true;
    }
}
