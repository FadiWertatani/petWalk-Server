package org.example.petwalk.repository;


import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetProfileRepo extends JpaRepository<PetProfile, Long> {
    PetProfile findPetProfileById(int id);

}
