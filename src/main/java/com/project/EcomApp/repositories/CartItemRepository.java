package com.project.EcomApp.repositories;

import com.project.EcomApp.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository  extends JpaRepository<CartItem,Long> {
    @Query("SELECT ci from CartItem ci where ci.cart.id=?1 AND ci.product.id=?2")
    CartItem findCartItemByProductIdAndCartId(Long cartId,Long ProductId);

    @Modifying
    @Query("DELETE FROM CartItem ci where ci.cart.id=?1 AND ci.product.id=?2")
    void deleteCartItemByProductIdAndCartId(Long cartId,Long productId);
}
