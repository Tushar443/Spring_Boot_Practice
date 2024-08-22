package com.project.connect_more_than_two_db;

import com.project.connect_more_than_two_db.entity.orderEntity.Order;
import com.project.connect_more_than_two_db.entity.productEntity.Product;
import com.project.connect_more_than_two_db.repository.orderRepo.OrderDAO;
import com.project.connect_more_than_two_db.repository.productRepo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@EnableAutoConfiguration
public class ConnectMoreThanTwoDbApplication implements CommandLineRunner {


	@Autowired
	ProductDAO productDAO;

	@Autowired
	OrderDAO orderDAO;


	public static void main(String[] args) {
		SpringApplication.run(ConnectMoreThanTwoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Phone",2000);
		productDAO.save(product); // MySQL

		Order order = new Order("Tushar", LocalDate.now());
		orderDAO.save(order);  // Postgresql
	}
}
