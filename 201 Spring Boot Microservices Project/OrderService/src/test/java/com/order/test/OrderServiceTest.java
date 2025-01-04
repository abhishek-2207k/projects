package com.order.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.order.entities.Orders;
import com.order.repositories.OrderRepo;
import com.order.service.OrderServiceImpl;

@SpringBootTest(classes= {OrderServiceTest.class})
public class OrderServiceTest {
	@Mock
	OrderRepo or;
	@InjectMocks
	OrderServiceImpl rsi;
	public List<Orders> orders;
	@Test
	@Order(1)
	public void test_getRestaurant() {
		List<Orders> orders=new ArrayList<Orders>();
		orders.add(new Orders(101, "Puri", 25, 40,1, "Debit Card", "Pending"));
		orders.add(new Orders(102, "Naan", 25, 60,2, "Credit Card", "Done"));
		when(or.findAll()).thenReturn(orders); //Mocking
		assertEquals(2,rsi.viewOrders().size());
	}
	@Test
	@Order(2)
	public void test_createOrder() {
		Orders orders=new Orders(102, "Naan", 25, 60,2, "Credit Card", "Done");
		or.save(orders);
		verify(or,times(1)).save(orders);
	}
	@Test
	@Order(3)
	public void test_updateOrder() {
		Orders orders=new Orders(102, "Naan", 25, 60,2, "Credit Card", "Done");
		or.save(orders);
		verify(or,times(1)).save(orders);
	}
	@Test
	@Order(4)
	public void test_deleteOrder() {
		Orders orders=new Orders(102, "Naan", 25, 60,2, "Credit Card", "Done");
		or.delete(orders);
		verify(or,times(1)).delete(orders);
	}

}