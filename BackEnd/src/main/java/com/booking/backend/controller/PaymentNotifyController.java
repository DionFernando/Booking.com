/*
package com.booking.backend.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentNotifyController {

    // Inject the secret key from application.properties or application.yml
    @Value("${payhere.secret.key}")
    private String secretKey;

    */
/**
     * Endpoint to receive payment notifications from PayHere.
     * Ensure that the parameters here match exactly what PayHere sends in their request.
     *//*

    @PostMapping("/notify")
    public ResponseEntity<String> paymentNotify(@RequestParam Map<String, String> params) {
        // Example: retrieving parameters sent by PayHere
        String orderId = params.get("order_id");
        String paymentStatus = params.get("payment_status");
        String receivedSignature = params.get("signature");

        // For demonstration, we construct a simple string to sign.
        // Adjust this logic according to PayHere's documentation regarding signature generation.
        String dataToSign = orderId + paymentStatus + secretKey;
        String generatedSignature = DigestUtils.md5Hex(dataToSign);

        // Validate signature
        if (!generatedSignature.equals(receivedSignature)) {
            System.err.println("Signature verification failed for order: " + orderId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
        }

        // Process the payment notification as required (e.g., update order status)
        return ResponseEntity.ok("Payment notification processed successfully");
    }
}
*/
