package com.nicoselomin.gestionLoyer.domain;


import java.time.LocalDate;

public abstract class Utilisateur {
    protected String id;
    protected String nom;
    protected String prenom;
    protected String numeroTel;
    protected LocalDate dateNaissance;
    protected String adresse;

    public Utilisateur(String id, String nom, String prenom, String numeroTel, LocalDate dateNaissance, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

}
