package com.nicoselomin.gestionLoyer.domain;

import java.util.Date;

public class Message {
    private int id;
    private String contenu;
    private Date dateEnvoie;
    private String expediteur;
    private String destinataire;
    private String statutEnvoi;

    // 🔧 Constructeur vide
    public Message() {}

    // 🔧 Constructeur complet
    public Message(int id, String contenu, Date dateEnvoie, String expediteur, String destinataire, String statutEnvoi) {
        this.id = id;
        this.contenu = contenu;
        this.dateEnvoie = dateEnvoie;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.statutEnvoi = statutEnvoi;
    }

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getStatutEnvoi() {
        return statutEnvoi;
    }

    // ✅ Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public void setStatutEnvoi(String statutEnvoi) {
        this.statutEnvoi = statutEnvoi;
    }
}
