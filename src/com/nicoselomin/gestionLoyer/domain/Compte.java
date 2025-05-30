package com.nicoselomin.gestionLoyer.domain;

import java.util.Date;

public class Compte {
    private String email;
    private String motDePasse;
    private Role role;
    private Date dateCreation;
    private Date dateDerniereConnexion;
    private StatutCompte statut;

    // 🔧 Constructeur complet
    public Compte(String email, String motDePasse, Role role, Date dateCreation, Date dateDerniereConnexion, StatutCompte statut) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.dateCreation = dateCreation;
        this.dateDerniereConnexion = dateDerniereConnexion;
        this.statut = statut;
    }

    // ✅ Getters
    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    public StatutCompte getStatut() {
        return statut;
    }

    // ✅ Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateDerniereConnexion(Date dateDerniereConnexion) {
        this.dateDerniereConnexion = dateDerniereConnexion;
    }

    public void setStatut(StatutCompte statut) {
        this.statut = statut;
    }
}