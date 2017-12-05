package top.wisely.domain.base;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author 潘峰
 * @date 2017/12/5 下午4:01
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)  // 这里注意，启用审计的实体中都必须注册这个 Listener，否则是没有效果的
public class BaseAuditingDomain {

    @CreatedDate // 创建的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @CreatedBy // 创建的用户
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_user")
    private String createUser;


    @LastModifiedBy
    @Column(name = "updated_user")
    private String updatedUser;


    @LastModifiedDate
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
}
