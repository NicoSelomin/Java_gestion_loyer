package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.domain.Compte;
import com.nicoselomin.gestionLoyer.domain.Message;
import com.nicoselomin.gestionLoyer.domain.Utilisateur;

public interface ICompte {
    boolean sInscrire();
    boolean seConnecter(String email, String motDePasse);
    boolean miseAJourCompte(Compte compte);
    void seDeconnecter();
    void envoyerMessage(Utilisateur destinataire, Message message);
}
