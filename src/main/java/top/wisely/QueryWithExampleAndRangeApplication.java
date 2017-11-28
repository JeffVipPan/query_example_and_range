package top.wisely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.wisely.repository.support.WiselyRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
@EnableScheduling
@EnableJpaAuditing // 这里，启用审计
public class QueryWithExampleAndRangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryWithExampleAndRangeApplication.class, args);
	}
}
