package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Message;
import java.util.List;

public interface MessageDAO {
    boolean envoyer(Message message);
    List<Message> findByDestinataire(String destinataire);
}
