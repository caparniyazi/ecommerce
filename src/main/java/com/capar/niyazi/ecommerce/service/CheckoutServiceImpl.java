package com.capar.niyazi.ecommerce.service;

import com.capar.niyazi.ecommerce.dao.CustomerRepository;
import com.capar.niyazi.ecommerce.dto.Purchase;
import com.capar.niyazi.ecommerce.dto.PurchaseResponse;
import com.capar.niyazi.ecommerce.entity.Customer;
import com.capar.niyazi.ecommerce.entity.Order;
import com.capar.niyazi.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {
    // Data fields
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Retrieve order info from DTO
        Order order = purchase.getOrder();

        // Generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNubmer(orderTrackingNumber);

        // Populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // Populate order with shipping and billing address
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        // Populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //  Save to the database
        customerRepository.save(customer);

        // Return a response.
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
