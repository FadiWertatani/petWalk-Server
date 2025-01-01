package org.example.petwalk.repository;

import org.example.petwalk.entity.QRConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQRConfirmationRepo extends JpaRepository<QRConfirmation, Long> {
}
