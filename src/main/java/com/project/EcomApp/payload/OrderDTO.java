package com.project.EcomApp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderID;
    private String email;
    private List<OrderItemDTO>orderItems;
    private LocalDate orderDate;
    private Double totalAmount;
    private String orderStatus;
    private Long addressId;
}
