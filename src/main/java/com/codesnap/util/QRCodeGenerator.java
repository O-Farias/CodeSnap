package com.codesnap.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QRCodeGenerator {

    // Método para gerar QR Code como um array de bytes
    public static byte[] generateQRCodeAsBytes(String text, int width, int height) throws IOException {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("O texto para o QR Code não pode ser nulo ou vazio.");
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("As dimensões do QR Code devem ser maiores que zero.");
        }

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            BufferedImage qrImage = toBufferedImage(bitMatrix);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", outputStream);

            return outputStream.toByteArray();
        } catch (WriterException e) {
            throw new IOException("Erro ao gerar o QR Code: " + e.getMessage(), e);
        }
    }

    // Método auxiliar para converter BitMatrix em BufferedImage
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, (matrix.get(x, y) ? 0x000000 : 0xFFFFFF)); // Preto e branco
            }
        }
        return image;
    }
}
