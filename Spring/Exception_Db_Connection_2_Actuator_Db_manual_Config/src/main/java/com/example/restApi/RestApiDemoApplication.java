package com.example.restApi;

import com.example.restApi.entity.orderEntity.Order;
import com.example.restApi.entity.productEntity.Product;
import com.example.restApi.repository.orderRepo.OrderDAO;
import com.example.restApi.repository.productRepo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RestApiDemoApplication implements CommandLineRunner {

//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	@Autowired
//	DataSource dataSource;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(RestApiDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		jdbcTemplate.execute("insert into student value (1,'Tushar','More')");
//		System.out.println("Inserted");
//
//		System.out.println(dataSource.getConnection());

		Product product = new Product("Phone",2000);
		productDAO.save(product); // MySQL

		Order order = new Order("Tushar", LocalDate.now());
		orderDAO.save(order);  // Postgresql

	}
}
