package top.wisely.repository;

import org.springframework.stereotype.Repository;
import top.wisely.domain.Customer;
import top.wisely.repository.support.WiselyRepository;

/**
 * @author 潘峰
 * @date 2017/12/3 上午11:11
 */
@Repository
public interface CustomerRepository extends WiselyRepository<Customer, Integer> {


}
