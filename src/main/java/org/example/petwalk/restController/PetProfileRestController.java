package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.repository.IPetProfileRepo;
import org.example.petwalk.services.interfaces.IPetProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PetProfileRestController {
    IPetProfileService petProfileService;
    IPetProfileRepo petProfileRepo;

    @GetMapping("/petprofiles/get-all")
    List<PetProfile> getAllPets() {
        return petProfileService.getAllProfiles();
    }

    @PostMapping("/petprofile/add")
    PetProfile addPetProfile(@RequestBody PetProfile petProfile) {
        return petProfileService.addPetProfile(petProfile);
    }


    @GetMapping(path = "/petprofile/get-By-Id/{id}")
    public void getPetProfileById(@PathVariable int id) {Optional<PetProfile> petProfile = Optional.ofNullable(petProfileService.getPetProfileById(id));
    }
}
