package com.nicoselomin.gestionLoyer.domain;

public class BienImmobilier {
    private String designation;
    private String adresse;
    private String type;
    private float loyerMensuel;
    private float chargeMensuel;
    private String statut;

    // 🔨 Constructeur
    public BienImmobilier(String designation, String adresse, String type, float loyerMensuel, float chargeMensuel, String statut) {
        this.designation = designation;
        this.adresse = adresse;
        this.type = type;
        this.loyerMensuel = loyerMensuel;
        this.chargeMensuel = chargeMensuel;
        this.statut = statut;
    }

    // ✅ Getters
    public String getDesignation() {
        return designation;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getType() {
        return type;
    }

    public float getLoyerMensuel() {
        return loyerMensuel;
    }

    public float getChargeMensuel() {
        return chargeMensuel;
    }

    public String getStatut() {
        return statut;
    }

    // ✅ Setters
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLoyerMensuel(float loyerMensuel) {
        this.loyerMensuel = loyerMensuel;
    }

    public void setChargeMensuel(float chargeMensuel) {
        this.chargeMensuel = chargeMensuel;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
