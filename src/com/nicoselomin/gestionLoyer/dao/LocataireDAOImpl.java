package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Locataire;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class LocataireDAOImpl implements LocataireDAO {

    @Override
    public boolean save(Locataire locataire) {
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false); // On démarre une transaction

            // Étape 1 : ajouter dans la table utilisateur
            String sqlUtilisateur = "INSERT INTO utilisateur (id, nom, prenom, numero_tel, date_naissance, adresse) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlUtilisateur)) {
                stmt1.setString(1, locataire.getId());
                stmt1.setString(2, locataire.getNom());
                stmt1.setString(3, locataire.getPrenom());
                stmt1.setString(4, locataire.getNumeroTel());
                stmt1.setDate(5, Date.valueOf(locataire.getDateNaissance()));
                stmt1.setString(6, locataire.getAdresse());
                stmt1.executeUpdate();
            }

            // Étape 2 : ajouter dans la table locataire (lié à utilisateur)
            String sqlLocataire = "INSERT INTO locataire (id) VALUES (?)";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlLocataire)) {
                stmt2.setString(1, locataire.getId());
                stmt2.executeUpdate();
            }

            conn.commit(); // Tout s’est bien passé, on valide
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Locataire findById(String id) {
        String sql = "SELECT * FROM utilisateur u INNER JOIN locataire l ON u.id = l.id WHERE u.id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id); // on remplace le "?" par la valeur d'identifiant

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Locataire(
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

        return null; // Si aucun locataire trouvé
    }

    @Override
    public List<Locataire> findAll() {
        List<Locataire> locataires = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur u INNER JOIN locataire l ON u.id = l.id";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Locataire locataire = new Locataire(
                        rs.getString("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("numero_tel"),
                        rs.getDate("date_naissance").toLocalDate(),
                        rs.getString("adresse")
                );
                locataires.add(locataire);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return locataires;
    }

    @Override
    public boolean update(Locataire locataire) {
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, numero_tel = ?, date_naissance = ?, adresse = ? WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, locataire.getNom());
            stmt.setString(2, locataire.getPrenom());
            stmt.setString(3, locataire.getNumeroTel());
            stmt.setDate(4, Date.valueOf(locataire.getDateNaissance()));
            stmt.setString(5, locataire.getAdresse());
            stmt.setString(6, locataire.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false); // Début de transaction

            // Étape 1 : supprimer de la table locataire
            String sqlLoc = "DELETE FROM locataire WHERE id = ?";
            try (PreparedStatement stmt1 = conn.prepareStatement(sqlLoc)) {
                stmt1.setString(1, id);
                stmt1.executeUpdate();
            }

            // Étape 2 : supprimer de la table utilisateur
            String sqlUser = "DELETE FROM utilisateur WHERE id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlUser)) {
                stmt2.setString(1, id);
                stmt2.executeUpdate();
            }

            conn.commit(); // Valide la transaction
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
