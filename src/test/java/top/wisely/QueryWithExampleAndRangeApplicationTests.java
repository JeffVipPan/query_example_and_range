package top.wisely;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jeffpan.domain.Customer;
import top.jeffpan.domain.Order;
import top.jeffpan.repository.CustomerRepository;
import top.jeffpan.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryWithExampleAndRangeApplicationTests {

	@Test
	public void contextLoads() {
	}


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testManyToOnePersist() {

        Customer customer = new Customer();
        customer.setName("李四");


        Order order = new Order();
        order.setCustomer(customer);
        order.setName("iPhone 8");
        order = orderRepository.save(order);

        customerRepository.save(customer);

        System.out.println(order);
    }


    @Test
    public void testManyToOneFind() {

        Order order = orderRepository.findOne(1);
        System.out.println(order.getName());

        System.out.println(order.getCustomer().getName());
    }


    @Test

    public void testManyToOneUpdate() throws Exception {

//        Order order = new Order();
//        order.setId(2);
//        order.setName("Apple Watch");
//
//        orderRepository.save(order);

        try {
            Customer customer = new Customer();
            customer.setId(1);
            customer.setName("Bill zhang44");
            // orderRepository.delete(customer.get);
            customerRepository.delete(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
