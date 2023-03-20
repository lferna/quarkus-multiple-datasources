package acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import acme.model.order.Order;
import acme.response.OrderResponse;
import io.quarkus.hibernate.orm.PersistenceUnit;

@ApplicationScoped
public class OrderService {

    @Inject
    @PersistenceUnit("orders") 
    EntityManager entityManagerOrder;
	
    
    public OrderResponse getOrder(Integer orderId) {
    	Order order = entityManagerOrder.find(Order.class, orderId);
    	OrderResponse orderResponse = new OrderResponse();
    	orderResponse.setId(order.getId());
    	orderResponse.setName(order.getName());
    	return orderResponse;
    }
}
