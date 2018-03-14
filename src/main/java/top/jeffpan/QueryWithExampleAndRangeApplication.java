package top.jeffpan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.jeffpan.repository.support.WiselyRepositoryImpl;

import java.io.Serializable;
import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
@EnableScheduling
@EnableJpaAuditing // 这里，启用审计
public class QueryWithExampleAndRangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryWithExampleAndRangeApplication.class, args);
	}

	@Bean
	public ObjectMapper serializingObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}


}
