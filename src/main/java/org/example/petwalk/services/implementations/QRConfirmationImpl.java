package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.QRConfirmation;
import org.example.petwalk.repository.IQRConfirmationRepo;
import org.example.petwalk.services.interfaces.IQRConfirmationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QRConfirmationImpl implements IQRConfirmationService {

    private final IQRConfirmationRepo qrConfirmationRepo;

    @Override
    public List<QRConfirmation> getAllQRConfirmations() {
        return qrConfirmationRepo.findAll();
    }

    @Override
    public QRConfirmation addQRConfirmation(QRConfirmation qrConfirmation) {
        return qrConfirmationRepo.save(qrConfirmation);
    }

    @Override
    public QRConfirmation updateQRConfirmation(QRConfirmation qrConfirmation) {
        QRConfirmation existingQR = qrConfirmationRepo.findById(qrConfirmation.getIdQR())
                .orElseThrow(() -> new RuntimeException("QRConfirmation not found"));
        existingQR.setConfirmation(qrConfirmation.getConfirmation());
        return qrConfirmationRepo.save(existingQR);
    }

    @Override
    public void deleteQRConfirmation(QRConfirmation qrConfirmation) {
        QRConfirmation existingQR = qrConfirmationRepo.findById(qrConfirmation.getIdQR())
                .orElseThrow(() -> new RuntimeException("QRConfirmation not found"));
        qrConfirmationRepo.delete(existingQR);
    }
}
