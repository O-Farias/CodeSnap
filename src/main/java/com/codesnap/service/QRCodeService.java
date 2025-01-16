package com.codesnap.service;

import com.codesnap.util.QRCodeGenerator;
import org.springframework.stereotype.Service;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String data, int width, int height) {
        try {
            return QRCodeGenerator.generateQRCode(data, width, height);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar o QR Code", e);
        }
    }
}
