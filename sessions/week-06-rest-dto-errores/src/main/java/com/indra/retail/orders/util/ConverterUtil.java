package com.indra.retail.orders.util;

import com.indra.retail.orders.model.Order;
import com.indra.retail.orders.model.OrderStatus;
import com.indra.retail.orders.web.request.CreateOrderRequest;
import com.indra.retail.orders.web.response.OrderResponse;

public class ConverterUtil {    

    public static Order convertRequestToOrder(CreateOrderRequest request) {
        Order order = new Order("Customer1",request.items(), request.deliveryAddress());        
        order.setCustomerId(request.customerId());        
        return order;
    }

    public static OrderResponse convertOrderToOrderResponse(Order order) {
        return(new OrderResponse(order.getId(),OrderStatus.CREATED,order.getTotalAmount(),order.getEstimatedDelivery()));    
    }
}
