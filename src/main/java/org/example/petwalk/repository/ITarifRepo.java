package org.example.petwalk.repository;

import org.example.petwalk.entity.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarifRepo extends JpaRepository<Tarif, Long> {
}
