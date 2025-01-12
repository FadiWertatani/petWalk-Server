package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.entity.User;

import java.util.List;

public interface IPetProfileService {

    List<PetProfile> getAllProfiles() ;

    PetProfile addPetProfile(org.example.petwalk.entity.PetProfile petProfile);

    PetProfile getPetProfileById(int id);


}
