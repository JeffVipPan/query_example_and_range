package top.jeffpan.repository;

import org.springframework.stereotype.Repository;
import top.jeffpan.domain.Customer;
import top.jeffpan.repository.support.WiselyRepository;

/**
 * @author 潘峰
 * @date 2017/12/3 上午11:11
 */
@Repository
public interface CustomerRepository extends WiselyRepository<Customer, Integer> {


}
