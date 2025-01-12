package org.example.petwalk.restController;

import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.repository.IPetProfileRepo;
import org.example.petwalk.services.interfaces.IPetProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class PetProfileRestController {
    IPetProfileService petProfileService;
    IPetProfileRepo petProfileRepo;

    @GetMapping("/petprofiles/get-all")
    List<PetProfile> getAllProfiles() {
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
