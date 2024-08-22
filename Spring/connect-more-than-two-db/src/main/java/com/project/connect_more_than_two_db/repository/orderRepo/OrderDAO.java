package com.project.connect_more_than_two_db.repository.orderRepo;
import com.project.connect_more_than_two_db.entity.orderEntity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends CrudRepository<Order,Long> {
}
