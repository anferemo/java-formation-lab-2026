package com.indra.retail.orders.util;

import java.time.LocalDate;

import com.indra.retail.orders.model.Order;
import com.indra.retail.orders.model.OrderStatus;
import com.indra.retail.orders.web.request.CreateOrderRequest;
import com.indra.retail.orders.web.response.OrderResponse;
import java.util.UUID;

public class ConverterUtil {

    private static long DELIVERY_DAYS_DURATION = 3L;

    public static Order convertRequestToOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setId("4");
        order.setCustomerId(request.customerId());
        order.setDeliveryAddress(request.deliveryAddress());
        order.setItems(request.items());
        order.setEstimatedDelivery(LocalDate.now().plusDays(DELIVERY_DAYS_DURATION));
        return order;
    }

    public static OrderResponse convertOrderToOrderResponse(Order order) {
        return(new OrderResponse(UUID.randomUUID().toString(),OrderStatus.CREATED,5L,order.getEstimatedDelivery()));    
    }
}
