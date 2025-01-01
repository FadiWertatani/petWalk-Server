package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.Tarif;
import org.example.petwalk.repository.ITarifRepo;
import org.example.petwalk.services.interfaces.ITarifService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarifImpl implements ITarifService {

    private final ITarifRepo tarifRepo;

    @Override
    public List<Tarif> getAllTarifs() {
        return tarifRepo.findAll();
    }

    @Override
    public Tarif addTarif(Tarif tarif) {
        return tarifRepo.save(tarif);
    }

    @Override
    public Tarif updateTarif(Tarif tarif) {
        Tarif existingTarif = tarifRepo.findById(tarif.getIdTarif())
                .orElseThrow(() -> new RuntimeException("Tarif not found"));
        existingTarif.setBaseTarif(tarif.getBaseTarif());
        existingTarif.setTarifDynamique(tarif.getTarifDynamique());
        existingTarif.setCriteres(tarif.getCriteres());
        return tarifRepo.save(existingTarif);
    }

    @Override
    public void deleteTarif(Tarif tarif) {
        Tarif existingTarif = tarifRepo.findById(tarif.getIdTarif())
                .orElseThrow(() -> new RuntimeException("Tarif not found"));
        tarifRepo.delete(existingTarif);
    }
}
