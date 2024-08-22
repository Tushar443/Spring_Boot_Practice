package com.example.restApi.repository.productRepo;

import com.example.restApi.entity.productEntity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product,Long> {
}
