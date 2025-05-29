package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.ContratLocation;
import com.nicoselomin.gestionLoyer.domain.EtatContrat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratLocationDAOImpl implements ContratLocationDAO {

    @Override
    public boolean save(ContratLocation contrat) {
        String sql = "INSERT INTO contrat_location (reference, date_entree, loyer_et_charges, depot_de_garantie, " +
                "jour_paiement, date_sortie, etat, lien, locataire_id, bien_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contrat.getReference());
            stmt.setDate(2, new java.sql.Date(contrat.getDateEntree().getTime()));
            stmt.setFloat(3, contrat.getLoyerEtCharges());
            stmt.setFloat(4, contrat.getDepotDeGarantie());
            stmt.setInt(5, contrat.getJourDePaiement());
            stmt.setDate(6, new java.sql.Date(contrat.getDateSortie().getTime()));
            stmt.setString(7, contrat.getEtat().name());
            stmt.setString(8, contrat.getLien());
            stmt.setString(9, contrat.getLien().split("-")[0]); // locataire_id (à adapter)
            stmt.setInt(10, Integer.parseInt(contrat.getLien().split("-")[1])); // bien_id (à adapter)

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ContratLocation findByReference(String reference) {
        String sql = "SELECT * FROM contrat_location WHERE reference = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reference);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ContratLocation(
                        rs.getString("reference"),
                        rs.getDate("date_entree"),
                        rs.getFloat("loyer_et_charges"),
                        rs.getFloat("depot_de_garantie"),
                        rs.getInt("jour_paiement"),
                        rs.getDate("date_sortie"),
                        EtatContrat.valueOf(rs.getString("etat")),
                        rs.getString("lien")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ContratLocation> findAll() {
        List<ContratLocation> contrats = new ArrayList<>();
        String sql = "SELECT * FROM contrat_location";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                contrats.add(new ContratLocation(
                        rs.getString("reference"),
                        rs.getDate("date_entree"),
                        rs.getFloat("loyer_et_charges"),
                        rs.getFloat("depot_de_garantie"),
                        rs.getInt("jour_paiement"),
                        rs.getDate("date_sortie"),
                        EtatContrat.valueOf(rs.getString("etat")),
                        rs.getString("lien")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contrats;
    }

    @Override
    public boolean update(ContratLocation contrat) {
        String sql = "UPDATE contrat_location SET date_entree = ?, loyer_et_charges = ?, depot_de_garantie = ?, " +
                "jour_paiement = ?, date_sortie = ?, etat = ?, lien = ? WHERE reference = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(contrat.getDateEntree().getTime()));
            stmt.setFloat(2, contrat.getLoyerEtCharges());
            stmt.setFloat(3, contrat.getDepotDeGarantie());
            stmt.setInt(4, contrat.getJourDePaiement());
            stmt.setDate(5, new java.sql.Date(contrat.getDateSortie().getTime()));
            stmt.setString(6, contrat.getEtat().name());
            stmt.setString(7, contrat.getLien());
            stmt.setString(8, contrat.getReference());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String reference) {
        String sql = "DELETE FROM contrat_location WHERE reference = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reference);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
