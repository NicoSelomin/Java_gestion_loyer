package com.nicoselomin.gestionLoyer.domain;
import java.util.Date;

public class ContratLocation {
    private String reference;
    private Date dateEntree;
    private float loyerEtCharges;
    private float depotDeGarantie;
    private int jourDePaiement;
    private Date dateSortie;
    private EtatContrat etat;
    private String lien;

    public ContratLocation(String reference, Date dateEntree, float loyerEtCharges, float depotDeGarantie,
                           int jourDePaiement, Date dateSortie, EtatContrat etat, String lien) {
        this.reference = reference;
        this.dateEntree = dateEntree;
        this.loyerEtCharges = loyerEtCharges;
        this.depotDeGarantie = depotDeGarantie;
        this.jourDePaiement = jourDePaiement;
        this.dateSortie = dateSortie;
        this.etat = etat;
        this.lien = lien;
    }

    // Getters
    public String getReference() {
        return reference;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public float getLoyerEtCharges() {
        return loyerEtCharges;
    }

    public float getDepotDeGarantie() {
        return depotDeGarantie;
    }

    public int getJourDePaiement() {
        return jourDePaiement;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public EtatContrat getEtat() {
        return etat;
    }

    public String getLien() {
        return lien;
    }

    // Setters
    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public void setLoyerEtCharges(float loyerEtCharges) {
        this.loyerEtCharges = loyerEtCharges;
    }

    public void setDepotDeGarantie(float depotDeGarantie) {
        this.depotDeGarantie = depotDeGarantie;
    }

    public void setJourDePaiement(int jourDePaiement) {
        this.jourDePaiement = jourDePaiement;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setEtat(EtatContrat etat) {
        this.etat = etat;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}
