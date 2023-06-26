package com.geli.ecommerce.repository;

import com.geli.ecommerce.model.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem,Integer> {
}
