package com.valtech.training.firstspringboot.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entity.Order;
import com.valtech.training.firstspringboot.repository.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	@PostConstruct
	public void populateOrders() {
		orderRepo.save(new Order("MacBook Pro m3",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
		orderRepo.save(new Order("IPhone 15 pro",1,"For the Entire team",LocalDate.of(2023, 11, 9)));
		orderRepo.save(new Order("Refrigirator",1,"For the Entire team",LocalDate.of(2023, 11, 10)));
	}
	
	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}
	
	@Override
	public Order getOrder(Long orderId) {
		return orderRepo.getReferenceById(orderId);
	}
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	
}
