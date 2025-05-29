package com.nicoselomin.gestionLoyer.dao;

import com.nicoselomin.gestionLoyer.domain.ContratLocation;
import java.util.List;

public interface ContratLocationDAO {
    boolean save(ContratLocation contrat);
    ContratLocation findByReference(String reference);
    List<ContratLocation> findAll();
    boolean update(ContratLocation contrat);
    boolean delete(String reference);
}
