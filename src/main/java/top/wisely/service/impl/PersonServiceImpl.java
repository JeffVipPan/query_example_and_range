package top.wisely.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.wisely.domain.Person;
import top.wisely.repository.PersonRepository;
import top.wisely.service.PersonService;

/**
 * @author 潘峰
 * @date 09/02/2018 9:46 AM
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Person unCommit(Long id) {
        Person person = find(id);
        try {
            Person update = update(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person person1 = find(id);
        return person1;
    }



    public Person find(Long id) {
        return personRepository.findOne(id);
    }

//    @Transactional(rollbackFor = Exception.class)
    public Person update(Long id) throws Exception {
        Person one = personRepository.findOne(id);
        one.setHeight(2120);
        Person person = personRepository.save(one);
        throw new RuntimeException("11");
    }

}
