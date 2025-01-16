package com.codesnap.service;

import com.codesnap.generator.QRCodeGenerator;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    private final QRCodeGenerator qrCodeGenerator;

    public QRCodeService(QRCodeGenerator qrCodeGenerator) {
        this.qrCodeGenerator = qrCodeGenerator;
    }

    public String generateQRCode(String data) {
        try {
            return qrCodeGenerator.generateQRCodeBase64(data);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar o QR Code", e);
        }
    }
}
