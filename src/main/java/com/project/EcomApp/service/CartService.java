package com.project.EcomApp.service;

import com.project.EcomApp.controller.CartController;
import com.project.EcomApp.payload.CartDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {
CartDTO addProductToCart(Long productId,Integer quantity);
List<CartDTO>getAllCarts();
CartDTO getCart(String emailId,Long cartId);
@Transactional
CartDTO updateProductQuantityInCart(Long productId,Integer quantity);
String deleteProductFromCart(Long cartId,Long productId);
void updateProductInCarts(Long cartId,Long productId);
}
