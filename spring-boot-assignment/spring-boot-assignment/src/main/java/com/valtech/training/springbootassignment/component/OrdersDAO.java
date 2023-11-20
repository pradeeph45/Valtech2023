package com.valtech.training.springbootassignment.component;

import java.util.List;

public interface OrdersDAO {

	void deleteOrders(int id);

	void updateOrders(Orders orders);

	void createOrders(Orders orders);

	List<Orders> getOrders();

	Orders getOrder();

	long countOrders();

}