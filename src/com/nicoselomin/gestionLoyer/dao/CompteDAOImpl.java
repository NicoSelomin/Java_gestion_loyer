package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Compte;
import com.nicoselomin.gestionLoyer.domain.Role;
import com.nicoselomin.gestionLoyer.domain.StatutCompte;

import java.sql.*;

public class CompteDAOImpl implements CompteDAO {

    @Override
    public boolean inscrire(Compte compte) {
        String sql = "INSERT INTO compte (email, mot_de_passe, role, date_creation, date_derniere_connexion, statut) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compte.getEmail());
            stmt.setString(2, compte.getMotDePasse());
            stmt.setString(3, compte.getRole().name());
            stmt.setDate(4, new java.sql.Date(compte.getDateCreation().getTime()));
            stmt.setDate(5, new java.sql.Date(compte.getDateDerniereConnexion().getTime()));
            stmt.setString(6, compte.getStatut().name());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean seConnecter(String email, String motDePasse) {
        String sql = "SELECT * FROM compte WHERE email = ? AND mot_de_passe = ? AND statut = 'ACTIF'";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, motDePasse);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true si trouvé

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean miseAJourCompte(Compte compte) {
        String sql = "UPDATE compte SET mot_de_passe = ?, role = ?, date_derniere_connexion = ?, statut = ? WHERE email = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compte.getMotDePasse());
            stmt.setString(2, compte.getRole().name());
            stmt.setDate(3, new java.sql.Date(compte.getDateDerniereConnexion().getTime()));
            stmt.setString(4, compte.getStatut().name());
            stmt.setString(5, compte.getEmail());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void seDeconnecter(String email) {
        String sql = "UPDATE compte SET statut = 'INACTIF' WHERE email = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Compte findByEmail(String email) {
        String sql = "SELECT * FROM compte WHERE email = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Compte(
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        Role.valueOf(rs.getString("role")),
                        rs.getDate("date_creation"),
                        rs.getDate("date_derniere_connexion"),
                        StatutCompte.valueOf(rs.getString("statut"))
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
