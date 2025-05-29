package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.BienImmobilier;
import java.util.List;

public interface BienImmobilierDAO {
    boolean save(BienImmobilier bien);
    BienImmobilier findByDesignation(String designation);
    List<BienImmobilier> findAll();
    boolean update(BienImmobilier bien);
    boolean delete(String designation);
}
