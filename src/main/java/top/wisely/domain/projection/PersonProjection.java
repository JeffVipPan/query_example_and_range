package top.wisely.domain.projection;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author 潘峰
 * @date 24/01/2018 6:00 PM
 */
public interface PersonProjection {


    String getName();

    String getHeight();

    @Value("#{target.name+''+target.height}")
    String getNameAndHeight();

}
