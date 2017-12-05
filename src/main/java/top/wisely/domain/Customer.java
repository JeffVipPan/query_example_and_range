package top.wisely.domain;

import lombok.Data;
import top.wisely.domain.base.BaseAuditingDomain;

import javax.persistence.*;

/**
 * @author 潘峰
 * @date 2017/12/3 下午3:09
 */
@Entity
@Data
@Table(name = "jpa_customer")
public class Customer extends BaseAuditingDomain {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Integer id;

    private String name;


}
