package be.businesstraining.repository;

import java.util.List;

import be.businesstraining.domain.Order;

public class OrdersRepositoryImpl implements IOrdersRepository {

	private List<Order> orders ;  // INJECTE PAR SPRING
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void create(Order o) {
		
		orders.add(o);
	}

	@Override
	public Order findById(String id) {
		return orders
				.stream()
				.filter(o -> o.getOrderId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Order> findAll() {
		return orders;
	}

	@Override
	public void update(Order o) {
	}

	@Override
	public void delete(String id) {
	}

}
