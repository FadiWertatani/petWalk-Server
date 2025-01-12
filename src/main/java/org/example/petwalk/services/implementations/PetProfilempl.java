package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.entity.User;
import org.example.petwalk.repository.IPetProfileRepo;
import org.example.petwalk.repository.IUserRepo;
import org.example.petwalk.services.interfaces.IPetProfileService;

import java.util.List;

public class PetProfilempl implements IPetProfileService {
    IPetProfileRepo petRepo ;


    @Override
    public List<PetProfile> getAllProfiles()
    {return petRepo.findAll();}

    @Override
    public  PetProfile addPetProfile(PetProfile petProfile)
    { return petRepo.save(petProfile);}

    @Override
    public PetProfile getPetProfileById(int id)
    {return  petRepo.findPetProfileById(Math.toIntExact(id));}






}
