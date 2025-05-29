package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {

    @Override
    public boolean envoyer(Message message) {
        String sql = "INSERT INTO message (contenu, date_envoie, expediteur, destinataire, statut_envoi) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, message.getContenu());
            stmt.setDate(2, new java.sql.Date(message.getDateEnvoie().getTime()));
            stmt.setString(3, message.getExpediteur());
            stmt.setString(4, message.getDestinataire());
            stmt.setString(5, message.getStatutEnvoi());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Message> findByDestinataire(String destinataire) {
        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE destinataire = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, destinataire);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setContenu(rs.getString("contenu"));
                message.setDateEnvoie(rs.getDate("date_envoie"));
                message.setExpediteur(rs.getString("expediteur"));
                message.setDestinataire(rs.getString("destinataire"));
                message.setStatutEnvoi(rs.getString("statut_envoi"));
                messages.add(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return messages;
    }
}
