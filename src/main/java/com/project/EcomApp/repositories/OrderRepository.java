package com.project.EcomApp.repositories;

import com.project.EcomApp.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
