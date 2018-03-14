package top.jeffpan.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author 潘峰
 * @date 14/03/2018 9:58 AM
 */
@RestController
public class LocalDateController {
    @PostMapping("/localData")
    public UserDto user(@RequestBody UserDto userDto) {
        return userDto;
    }


    @Data
    static class UserDto implements Serializable {
        private final static long serialVersionUID = 1L;

        private String name;
        private LocalDate localDate;
    }
}

