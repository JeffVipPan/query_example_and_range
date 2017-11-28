package top.wisely.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wangyunfei on 2017/6/6.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // 这里注意，启用审计的实体中都必须注册这个 Listener，否则是没有效果的
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer height;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    @CreatedDate // 创建的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

    @CreatedBy // 创建的用户
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createUser;


    @LastModifiedBy
    private String updatedUser;


    @LastModifiedDate
    private LocalDateTime updatedTime;

}
