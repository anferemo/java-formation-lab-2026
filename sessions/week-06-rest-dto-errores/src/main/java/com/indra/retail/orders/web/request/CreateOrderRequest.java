package com.indra.retail.orders.web.request;

import java.util.List;

import com.indra.retail.orders.model.OrderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateOrderRequest(
    @NotBlank   String customerId, 
    @NotEmpty  @Size(min = 1) List<OrderItem> items, 
    @NotNull @Size(min=10) String deliveryAddress) {

}
