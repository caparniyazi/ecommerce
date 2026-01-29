package com.capar.niyazi.ecommerce.service;

import com.capar.niyazi.ecommerce.dto.Purchase;
import com.capar.niyazi.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
