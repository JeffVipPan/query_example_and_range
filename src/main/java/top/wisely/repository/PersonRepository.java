package top.wisely.repository;


import org.springframework.stereotype.Repository;
import top.wisely.domain.Person;
import top.wisely.domain.projection.PersonProjection;
import top.wisely.repository.support.WiselyRepository;

/**
 * @author: 潘峰
 * @date: 2017/12/2 下午2:59
 */
@Repository
public interface PersonRepository extends WiselyRepository<Person,Long> {

     void deleteById(Long id);

    PersonProjection findById(Long id);

}
