package com.indra.retail.orders.web.response;

import java.time.LocalDate;

import com.indra.retail.orders.model.OrderStatus;

public record OrderResponse(String orderId, OrderStatus status, double totalAmount, LocalDate estimatedDelivery) {

}
