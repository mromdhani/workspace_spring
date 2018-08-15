package be.businesstraining.business;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import be.businesstraining.domain.Order;
import be.businesstraining.repository.IOrdersRepository;

@Service()
public class OrdersBusinessImpl implements IOrdersBusiness {

	@Autowired
	private IOrdersRepository repo;  // DEPEND ON ABSTRACTIONS !!!
	
	
	public IOrdersRepository getRepo() {
		return repo;
	}

	public void setRepo(IOrdersRepository repo) {
		this.repo = repo;
	}

	@Override
	public BigDecimal computeTotalOrderPrice(String id) {
		
		Order order = repo.findById(id);
		
		return order.getProducts()
				.stream()
				.map(p -> p.getUnitPrice())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
