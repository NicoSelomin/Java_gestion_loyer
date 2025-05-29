package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Locataire;
import java.util.List;

public interface LocataireDAO {
    boolean save(Locataire locataire);
    Locataire findById(String id);
    List<Locataire> findAll();
    boolean update(Locataire locataire);
    boolean delete(String id);
}
