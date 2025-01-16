package com.codesnap.controller;

import com.codesnap.service.QRCodeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
@Validated
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody @Valid QRCodeRequest request) {
        try {
            byte[] qrCode = qrCodeService.generateQRCode(request.getData(), request.getWidth(), request.getHeight());

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png");

            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public static class QRCodeRequest {
        @NotBlank(message = "O campo 'data' não pode estar vazio.")
        private String data;

        @Min(value = 1, message = "A largura deve ser maior que 0.")
        private int width;

        @Min(value = 1, message = "A altura deve ser maior que 0.")
        private int height;

        // Getters e setters
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
