package com.codesnap.controller;

import com.codesnap.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateQRCode(@RequestBody String data) {
        String qrCodeBase64 = qrCodeService.generateQRCode(data);
        return ResponseEntity.ok(qrCodeBase64);
    }
}
