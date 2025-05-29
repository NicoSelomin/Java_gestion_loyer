package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.BienImmobilier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BienImmobilierDAOImpl implements BienImmobilierDAO {

    @Override
    public boolean save(BienImmobilier bien) {
        String sql = "INSERT INTO bienimmobilier (designation, adresse, type, loyer_mensuel, charge_mensuel, statut) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bien.getDesignation());
            stmt.setString(2, bien.getAdresse());
            stmt.setString(3, bien.getType());
            stmt.setFloat(4, bien.getLoyerMensuel());
            stmt.setFloat(5, bien.getChargeMensuel());
            stmt.setString(6, bien.getStatut());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BienImmobilier findByDesignation(String designation) {
        String sql = "SELECT * FROM bienimmobilier WHERE designation = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, designation);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new BienImmobilier(
                        rs.getString("designation"),
                        rs.getString("adresse"),
                        rs.getString("type"),
                        rs.getFloat("loyer_mensuel"),
                        rs.getFloat("charge_mensuel"),
                        rs.getString("statut")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<BienImmobilier> findAll() {
        List<BienImmobilier> biens = new ArrayList<>();
        String sql = "SELECT * FROM bienimmobilier";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                biens.add(new BienImmobilier(
                        rs.getString("designation"),
                        rs.getString("adresse"),
                        rs.getString("type"),
                        rs.getFloat("loyer_mensuel"),
                        rs.getFloat("charge_mensuel"),
                        rs.getString("statut")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return biens;
    }

    @Override
    public boolean update(BienImmobilier bien) {
        String sql = "UPDATE bienimmobilier SET adresse = ?, type = ?, loyer_mensuel = ?, charge_mensuel = ?, statut = ? WHERE designation = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bien.getAdresse());
            stmt.setString(2, bien.getType());
            stmt.setFloat(3, bien.getLoyerMensuel());
            stmt.setFloat(4, bien.getChargeMensuel());
            stmt.setString(5, bien.getStatut());
            stmt.setString(6, bien.getDesignation());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String designation) {
        String sql = "DELETE FROM bienimmobilier WHERE designation = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, designation);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
