package com.project.connect_more_than_two_db.repository.productRepo;

import com.project.connect_more_than_two_db.entity.productEntity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product,Long> {
}
