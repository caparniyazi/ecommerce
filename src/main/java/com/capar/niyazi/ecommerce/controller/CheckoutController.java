package com.capar.niyazi.ecommerce.controller;

import com.capar.niyazi.ecommerce.dto.Purchase;
import com.capar.niyazi.ecommerce.dto.PurchaseResponse;
import com.capar.niyazi.ecommerce.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin({"http://localhost:4200", "http://ecommerce-europe-bucket.s3-website.eu-north-1.amazonaws.com"})
@RestController
@RequestMapping("/api/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {
    // Data fields
    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
