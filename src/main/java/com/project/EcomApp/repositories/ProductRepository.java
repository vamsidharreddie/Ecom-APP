package com.project.EcomApp.repositories;

import com.project.EcomApp.model.Category;
import com.project.EcomApp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product>findByCategoryOrderByPriceAsc(Category category, Pageable pageDetails);
    Page<Product>findByProductNameLikeIgnoreCase(String keyword,Pageable pageDetails);
}
