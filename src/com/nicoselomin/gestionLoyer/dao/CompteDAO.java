package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Compte;

public interface CompteDAO {
    boolean inscrire(Compte compte);
    boolean seConnecter(String email, String motDePasse);
    boolean miseAJourCompte(Compte compte);
    void seDeconnecter(String email);
    Compte findByEmail(String email);
}
