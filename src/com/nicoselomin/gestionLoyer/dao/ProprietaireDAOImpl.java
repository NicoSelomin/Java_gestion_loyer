package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Proprietaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietaireDAOImpl implements ProprietaireDAO {

    @Override
    public boolean save(Proprietaire proprietaire) {
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false);

            String sqlUtilisateur = "INSERT INTO utilisateur (id, nom, prenom, numero_tel, date_naissance, adresse) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlUtilisateur)) {
                stmt1.setString(1, proprietaire.getId());
                stmt1.setString(2, proprietaire.getNom());
                stmt1.setString(3, proprietaire.getPrenom());
                stmt1.setString(4, proprietaire.getNumeroTel());
                stmt1.setDate(5, Date.valueOf(proprietaire.getDateNaissance()));
                stmt1.setString(6, proprietaire.getAdresse());
                stmt1.executeUpdate();
            }

            String sqlProp = "INSERT INTO proprietaire (id) VALUES (?)";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlProp)) {
                stmt2.setString(1, proprietaire.getId());
                stmt2.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Proprietaire findById(String id) {
        String sql = "SELECT * FROM utilisateur u INNER JOIN proprietaire p ON u.id = p.id WHERE u.id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Proprietaire(
                            rs.getString("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("numero_tel"),
                            rs.getDate("date_naissance").toLocalDate(),
                            rs.getString("adresse")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Proprietaire> findAll() {
        List<Proprietaire> list = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur u INNER JOIN proprietaire p ON u.id = p.id";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proprietaire p = new Proprietaire(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("numero_tel"),
                        rs.getDate("date_naissance").toLocalDate(),
                        rs.getString("adresse")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean update(Proprietaire proprietaire) {
        String sql = "UPDATE utilisateur SET nom=?, prenom=?, numero_tel=?, date_naissance=?, adresse=? WHERE id=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, proprietaire.getNom());
            stmt.setString(2, proprietaire.getPrenom());
            stmt.setString(3, proprietaire.getNumeroTel());
            stmt.setDate(4, Date.valueOf(proprietaire.getDateNaissance()));
            stmt.setString(5, proprietaire.getAdresse());
            stmt.setString(6, proprietaire.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false);

            String sqlProp = "DELETE FROM proprietaire WHERE id = ?";
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlProp)) {
                stmt1.setString(1, id);
                stmt1.executeUpdate();
            }

            String sqlUser = "DELETE FROM utilisateur WHERE id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlUser)) {
                stmt2.setString(1, id);
                stmt2.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
