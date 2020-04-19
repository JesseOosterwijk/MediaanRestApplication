package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.messagingstompwebsocket.models.Order;
import com.example.messagingstompwebsocket.models.OrderModel;

@Controller
public class OrderController {

//	 @MessageMapping("/order")
//	  @SendTo("/topic/orders")
//	  public ReceivedOrder receivedOrder(Order order) throws Exception {
//	    Thread.sleep(1000); // simulated delay
//	    return new ReceivedOrder("Order in, " + HtmlUtils.htmlEscape(order.getName()) + "!");
//	  }

	@MessageMapping("/orders")
	@SendTo("/mediaan/kitchen")
	public OrderModel sendToKitchen(Order order) throws Exception {
		Thread.sleep(750);
		OrderModel oM = new OrderModel();
		oM.mealList = order.mealList;
		oM.tableNr = order.table;
		return oM;
	}

}
