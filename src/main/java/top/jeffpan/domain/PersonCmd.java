package top.jeffpan.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 潘峰
 * @date 2017/11/12 下午4:36
 */
@Data
public class PersonCmd {

    private Long id;
    private String name;
    private Integer height;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
