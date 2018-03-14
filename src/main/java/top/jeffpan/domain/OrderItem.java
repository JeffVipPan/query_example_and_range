package top.jeffpan.domain;

import lombok.Data;
import top.jeffpan.domain.base.BaseAuditingDomain;

import javax.persistence.*;

/**
 * @author 潘峰
 * @date 2017/12/5 下午3:59
 */
@Entity
@Data
public class OrderItem extends BaseAuditingDomain {

    @Id
    @GeneratedValue
    @Column(name = "orderitem_id")
    private Integer orderItemId;

    private Float price = 0F;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

}
