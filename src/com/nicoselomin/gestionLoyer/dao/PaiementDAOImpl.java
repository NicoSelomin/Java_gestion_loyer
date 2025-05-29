package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Paiement;
import com.nicoselomin.gestionLoyer.domain.ModePaiement;
import com.nicoselomin.gestionLoyer.domain.StatutPaiement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaiementDAOImpl implements PaiementDAO {

    @Override
    public boolean save(Paiement paiement, String contratReference) {
        String sql = "INSERT INTO paiement (mois, montant_paye, date_paiement, mode_paiement, statut, contrat_reference) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(paiement.getMois().getTime()));
            stmt.setFloat(2, paiement.getMontantPaye());
            stmt.setDate(3, new java.sql.Date(paiement.getDatePaiement().getTime()));
            stmt.setString(4, paiement.getModePaiement().name());
            stmt.setString(5, paiement.getStatut().name());
            stmt.setString(6, contratReference);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Paiement> findByContrat(String contratReference) {
        List<Paiement> paiements = new ArrayList<>();
        String sql = "SELECT * FROM paiement WHERE contrat_reference = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contratReference);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paiement paiement = new Paiement();
                paiement.setMois(rs.getDate("mois"));
                paiement.setMontantPaye(rs.getFloat("montant_paye"));
                paiement.setDatePaiement(rs.getDate("date_paiement"));
                paiement.setModePaiement(ModePaiement.valueOf(rs.getString("mode_paiement")));
                paiement.setStatut(StatutPaiement.valueOf(rs.getString("statut")));

                paiements.add(paiement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paiements;
    }

    @Override
    public List<Paiement> findAll() {
        List<Paiement> paiements = new ArrayList<>();
        String sql = "SELECT * FROM paiement";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paiement paiement = new Paiement();
                paiement.setMois(rs.getDate("mois"));
                paiement.setMontantPaye(rs.getFloat("montant_paye"));
                paiement.setDatePaiement(rs.getDate("date_paiement"));
                paiement.setModePaiement(ModePaiement.valueOf(rs.getString("mode_paiement")));
                paiement.setStatut(StatutPaiement.valueOf(rs.getString("statut")));

                paiements.add(paiement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paiements;
    }

    @Override
    public boolean delete(Paiement paiement, String contratReference) {
        String sql = "DELETE FROM paiement WHERE mois = ? AND contrat_reference = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(paiement.getMois().getTime()));
            stmt.setString(2, contratReference);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
