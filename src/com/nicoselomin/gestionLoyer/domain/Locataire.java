package com.nicoselomin.gestionLoyer.domain;

import java.time.LocalDate;

public class Locataire extends Utilisateur {

    public Locataire(String id, String nom, String prenom, String numeroTel, LocalDate dateNaissance, String adresse) {
        super(id, nom, prenom, numeroTel, dateNaissance, adresse);
    }

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getNumeroTel() { return numeroTel; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getAdresse() { return adresse; }

}

