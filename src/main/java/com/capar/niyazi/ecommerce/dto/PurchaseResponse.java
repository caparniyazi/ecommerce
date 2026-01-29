package com.capar.niyazi.ecommerce.dto;

import lombok.Data;

/**
 * The class to send back a Java object as JSON.
 * Lombok @Data will generate constructor for final fields.
 */
@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
}
