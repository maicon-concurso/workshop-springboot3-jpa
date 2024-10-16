package com.maicon_estudos.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maicon_estudos.curso.entities.Category;
import com.maicon_estudos.curso.entities.Order;
import com.maicon_estudos.curso.entities.OrderItem;
import com.maicon_estudos.curso.entities.Product;
import com.maicon_estudos.curso.entities.User;
import com.maicon_estudos.curso.entities.enums.OrderStatus;
import com.maicon_estudos.curso.repositories.CategoryRepository;
import com.maicon_estudos.curso.repositories.OrderItemRepository;
import com.maicon_estudos.curso.repositories.OrderRepository;
import com.maicon_estudos.curso.repositories.ProductRepository;
import com.maicon_estudos.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3,p4 ,p5));
		
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "69993337575", "00394418552");
		User u2 = new User(null, "João", "joao@gmail.com", "6993337577", "0039445252");
		User u3 = new User(null, "Tadeu", "tadeua@gmail.com", "699989899", "003941515");
		User u4 = new User(null, "Ruiz", "ruiz@gmail.com", "69935656", "00347522");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u1); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
}
