package org.example.petwalk.repository;


import org.example.petwalk.entity.PetProfile;
import org.example.petwalk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetProfileRepo extends JpaRepository<PetProfile, Long> {
    PetProfile findPetProfileByIdpet(int id);

}
