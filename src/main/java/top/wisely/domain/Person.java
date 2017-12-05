package top.wisely.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import top.wisely.domain.base.BaseAuditingDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by wangyunfei on 2017/6/6.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseAuditingDomain {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer height;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;



}
