package com.main.project.java.Repository;

import com.main.project.java.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart,Integer>{
}
