package top.wisely.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.wisely.domain.Person;
import top.wisely.domain.projection.PersonProjection;
import top.wisely.repository.PersonRepository;
import top.wisely.repository.support.Range;
import top.wisely.service.PersonService;

import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author: 潘峰
 * @date: 26/01/2018 4:38 PM
 */
@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        Person p = personRepository.save(person);
        return new ResponseEntity<Person>(p, HttpStatus.CREATED);
    }

    @GetMapping("/query")
    public ResponseEntity<Page<Person>> query(
            Person person,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            Integer startHeight,
            Integer endHeight,
            Pageable pageable) {
        Example<Person> personExample = Example.of(person);

        List<Range<Person>> ranges = newArrayList();
        Range<Person> birthRange = new Range<Person>("birthday", startDate, endDate);
        Range<Person> heightRange = new Range<Person>("height", startHeight, endHeight);
        ranges.add(birthRange);
        ranges.add(heightRange);

        Page<Person> page =
                personRepository.queryByExampleWithRange(personExample, ranges, pageable);

        return new ResponseEntity<Page<Person>>(page, HttpStatus.OK);
    }

    @GetMapping("/find")
    public PersonProjection delete(@RequestParam(value = "id") Long id) {
        PersonProjection projection = personRepository.findById(id);

        System.out.println(
                projection.getHeight()
                        + ","
                        + projection.getName()
                        + ","
                        + projection.getNameAndHeight());

        return projection;
    }


    @GetMapping("/unCommit")
    public ResponseEntity<Person> unCommit(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<Person>(personService.unCommit(id), HttpStatus.OK);
    }


    @GetMapping("/findid")
    public List<Long> findid(@RequestParam(value = "name") String name) {
        List<Long> idByName = personRepository.findIdByName(name);
        return idByName;
    }



}
