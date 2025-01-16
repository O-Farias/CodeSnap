package com.codesnap.service;

import com.codesnap.util.QRCodeGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text, int width, int height) {
        try {
            return QRCodeGenerator.generateQRCodeAsBytes(text, width, height);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar o QR Code", e);
        }
    }
}
