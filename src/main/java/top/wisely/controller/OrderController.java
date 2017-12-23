package top.wisely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping(value = "orders/{id}")
    public ResponseEntity changeOrder(@PathVariable Integer id) {
        Order order = orderRepository.findOne(id);
        order.setName("李四");
        orderRepository.save(order);
        System.out.println(order.toString());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}
