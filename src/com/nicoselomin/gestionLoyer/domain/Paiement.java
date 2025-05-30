package com.nicoselomin.gestionLoyer.domain;
import java.util.Date;

public class Paiement {
    private int idPaiement;
    private Date mois;
    private float montantPaye;
    private Date datePaiement;
    private ModePaiement modePaiement;
    private StatutPaiement statut;

    //Getters
    public int getIdPaiement() {
        return idPaiement;
    }

    public Date getMois() {
        return mois;
    }

    public float getMontantPaye() {
        return montantPaye;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public StatutPaiement getStatut() {
        return statut;
    }

    // Setters
    public void setMois(Date mois) {
        this.mois = mois;
    }

    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public void setStatut(StatutPaiement statut) {
        this.statut = statut;
    }
}
