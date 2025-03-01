package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.entity.User;
import org.example.petwalk.repository.IPetProfileRepo;
import org.example.petwalk.repository.IUserRepo;
import org.example.petwalk.services.interfaces.IPetProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetProfilempl implements IPetProfileService {
    IPetProfileRepo petRepo ;


    @Override
    public List<PetProfile> getAllProfiles() {return petRepo.findAll();}

    @Override
    public  PetProfile addPetProfile(PetProfile petProfile)
    { return petRepo.save(petProfile);}

    @Override
    public PetProfile getPetProfileById(int id)
    {return  petRepo.findPetProfileByIdpet(Math.toIntExact(id));}






}
