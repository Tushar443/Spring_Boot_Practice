package com.example.restApi.repository.orderRepo;

import com.example.restApi.entity.orderEntity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends CrudRepository<Order,Long> {
}
