package com.mediaan.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.mediaan.websocket.model.Order;

@Controller
public class OrderController {

	@MessageMapping("/order")
	@SendTo("/kitchen")
	public Order receivedOrder(Order order) throws Exception {
		return order;
	}

}
