package top.wisely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wisely.domain.Order;
import top.wisely.repository.CustomerRepository;
import top.wisely.repository.OrderRepository;

/**
 * @author 潘峰
 * @date 2017/12/3 上午11:10
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(value = "/addOrder")
    public Order addOrder(@RequestBody Order order) {
        Order order1 = orderRepository.save(order);
        return order1;
    }


}
