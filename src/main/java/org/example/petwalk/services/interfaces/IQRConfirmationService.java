package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.QRConfirmation;

import java.util.List;

public interface IQRConfirmationService {
    List<QRConfirmation> getAllQRConfirmations();

    QRConfirmation addQRConfirmation(QRConfirmation qrConfirmation);

    QRConfirmation updateQRConfirmation(QRConfirmation qrConfirmation);

    void deleteQRConfirmation(QRConfirmation qrConfirmation);
}
