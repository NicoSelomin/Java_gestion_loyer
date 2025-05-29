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

    // Getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
