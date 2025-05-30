package com.nicoselomin.gestionLoyer.services;

import com.nicoselomin.gestionLoyer.dao.MessageDAO;
import com.nicoselomin.gestionLoyer.dao.MessageDAOImpl;
import com.nicoselomin.gestionLoyer.domain.Message;

import java.util.List;

public class MessageService {

    private final MessageDAO dao = new MessageDAOImpl();

    public boolean envoyer(Message message) {
        return dao.envoyer(message);
    }

    public List<Message> recevoir(String idDestinataire) {
        return dao.recevoir(idDestinataire);
    }

    public List<Message> envoyerParUtilisateur(String idExpediteur) {
        return dao.findByExpediteur(idExpediteur);
    }

    public boolean supprimer(int idMessage) {
        return dao.delete(idMessage);
    }
}
