package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.QRConfirmation;
import org.example.petwalk.services.interfaces.IQRConfirmationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/qr-confirmation")
public class QRConfirmationRestController {

    private final IQRConfirmationService qrConfirmationService;

    @GetMapping("/get-all")
    public List<QRConfirmation> getAllQRConfirmations() {
        return qrConfirmationService.getAllQRConfirmations();
    }

    @PostMapping("/add")
    public QRConfirmation addQRConfirmation(@RequestBody QRConfirmation qrConfirmation) {
        return qrConfirmationService.addQRConfirmation(qrConfirmation);
    }

    @PutMapping("/update")
    public QRConfirmation updateQRConfirmation(@RequestBody QRConfirmation qrConfirmation) {
        return qrConfirmationService.updateQRConfirmation(qrConfirmation);
    }

    @DeleteMapping("/delete")
    public void deleteQRConfirmation(@RequestBody QRConfirmation qrConfirmation) {
        qrConfirmationService.deleteQRConfirmation(qrConfirmation);
    }
}
