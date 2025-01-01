package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Tarif;

import java.util.List;

public interface ITarifService {
    List<Tarif> getAllTarifs();

    Tarif addTarif(Tarif tarif);

    Tarif updateTarif(Tarif tarif);

    void deleteTarif(Tarif tarif);
}
