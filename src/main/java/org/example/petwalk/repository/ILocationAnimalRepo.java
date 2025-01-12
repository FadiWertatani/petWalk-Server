package org.example.petwalk.repository;

import org.example.petwalk.entity.LocationAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationAnimalRepo extends JpaRepository<LocationAnimal , Long> {
    List<LocationAnimal> findLocationAnimalsByEmailOrderByTimestampDesc(String email);
}