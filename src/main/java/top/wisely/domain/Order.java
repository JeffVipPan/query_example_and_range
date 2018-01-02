package top.wisely.domain;

import lombok.Data;
import top.wisely.domain.base.BaseAuditingDomain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 潘峰
 * @date 2017/12/3 下午3:47
 */
@Data
@Entity
@Table(name = "jpa_Order")
public class Order extends BaseAuditingDomain {

    private final String age;
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Integer id;

    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    private Set<OrderItem> items = new HashSet<>();
    private String eye;


    public Order(String age) {
        super();
        this.age = age;
    }

    private final static String AGE  = "20";


}
