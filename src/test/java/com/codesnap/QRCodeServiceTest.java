package com.codesnap;

import com.codesnap.service.QRCodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QRCodeServiceTest {

    @Autowired
    private QRCodeService qrCodeService;

    @Test
    public void testGenerateQRCodeWithValidData() throws Exception {
        byte[] qrCode = qrCodeService.generateQRCode("https://example.com", 300, 300);

        // Verifica se o array não é nulo e tem dados
        Assertions.assertNotNull(qrCode, "QR Code não deve ser nulo.");
        Assertions.assertTrue(qrCode.length > 0, "QR Code deve conter dados.");
    }

    @Test
    public void testGenerateQRCodeWithNegativeDimensions() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            qrCodeService.generateQRCode("https://example.com", -300, 300);
        });
        Assertions.assertEquals("As dimensões do QR Code devem ser maiores que zero.", exception.getMessage());
    }

    @Test
    public void testGenerateQRCodeWithNullData() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            qrCodeService.generateQRCode(null, 300, 300);
        });
        Assertions.assertEquals("O texto para o QR Code não pode ser nulo ou vazio.", exception.getMessage());
    }
}
