package com.capar.niyazi.ecommerce.dto;

import com.capar.niyazi.ecommerce.entity.Address;
import com.capar.niyazi.ecommerce.entity.Customer;
import com.capar.niyazi.ecommerce.entity.Order;
import com.capar.niyazi.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    // Data fields
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
