package acme.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import acme.response.OrderResponse;
import acme.service.OrderService;

@Path(value = "/api/v1/order")
public class OrderController {

	@Inject
	OrderService orderService;
	
	@Path(value = "/{orderId}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@GET
	public OrderResponse getOrder(@PathParam(value = "orderId") Integer orderId) {
		return orderService.getOrder(orderId);
	}
}
