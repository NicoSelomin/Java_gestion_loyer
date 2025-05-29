package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.Proprietaire;
import java.util.List;

public interface ProprietaireDAO {
    boolean save(Proprietaire proprietaire);
    Proprietaire findById(String id);
    List<Proprietaire> findAll();
    boolean update(Proprietaire proprietaire);
    boolean delete(String id);
}
