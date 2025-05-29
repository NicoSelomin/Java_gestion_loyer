package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.dao.CompteDAO;
import com.nicoselomin.gestionLoyer.dao.CompteDAOImpl;
import com.nicoselomin.gestionLoyer.dao.MessageDAO;
import com.nicoselomin.gestionLoyer.dao.MessageDAOImpl;
import com.nicoselomin.gestionLoyer.domain.Compte;
import com.nicoselomin.gestionLoyer.domain.Message;
import com.nicoselomin.gestionLoyer.domain.Utilisateur;

import java.util.Date;

public class CompteServices implements ICompte {

    private final CompteDAO compteDAO = new CompteDAOImpl();
    private final MessageDAO messageDAO = new MessageDAOImpl();
    private Compte compteActif;

    @Override
    public boolean sInscrire() {
        // Exemple fictif de compte (à remplacer par une saisie utilisateur plus tard)
        Compte nouveau = new Compte("test@mail.com", "1234", null, new Date(), new Date(), null);
        boolean success = compteDAO.inscrire(nouveau);
        if (success) this.compteActif = nouveau;
        return success;
    }

    @Override
    public boolean seConnecter(String email, String motDePasse) {
        boolean success = compteDAO.seConnecter(email, motDePasse);
        if (success) {
            this.compteActif = compteDAO.findByEmail(email);
        }
        return success;
    }

    @Override
    public boolean miseAJourCompte(Compte compte) {
        return compteDAO.miseAJourCompte(compte);
    }

    @Override
    public void seDeconnecter() {
        if (compteActif != null) {
            compteDAO.seDeconnecter(compteActif.getEmail());
            compteActif = null;
        }
    }

    @Override
    public void envoyerMessage(Utilisateur destinataire, Message message) {
        // Compléter automatiquement l’expéditeur
        if (compteActif != null) {
            message.setExpediteur(compteActif.getEmail());
            message.setDestinataire(destinataire.getId()); // ou destinataire.getEmail() selon ton modèle
            message.setDateEnvoie(new Date());
            message.setStatutEnvoi("ENVOYE");

            messageDAO.envoyer(message);
        } else {
            System.out.println("⚠️ Aucun compte connecté !");
        }
    }
}
