package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.Tarif;
import org.example.petwalk.services.interfaces.ITarifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tarif")
public class TarifRestController {

    private final ITarifService tarifService;

    @GetMapping("/get-all")
    public List<Tarif> getAllTarifs() {
        return tarifService.getAllTarifs();
    }

    @PostMapping("/add")
    public Tarif addTarif(@RequestBody Tarif tarif) {
        return tarifService.addTarif(tarif);
    }

    @PutMapping("/update")
    public Tarif updateTarif(@RequestBody Tarif tarif) {
        return tarifService.updateTarif(tarif);
    }

    @DeleteMapping("/delete")
    public void deleteTarif(@RequestBody Tarif tarif) {
        tarifService.deleteTarif(tarif);
    }
}
