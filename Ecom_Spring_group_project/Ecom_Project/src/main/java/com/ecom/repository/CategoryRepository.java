package com.ecom.repository;

import com.ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);
}
