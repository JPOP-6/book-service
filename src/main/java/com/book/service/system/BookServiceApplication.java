package com.book.service.system;

import com.book.service.system.model.mapper.BookModelMapperImpl;
import com.book.service.system.repositories.BookRepository;
import com.book.service.system.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		BookRepository.class
})
@EntityScan("com.book.service.system.model")
@Import(value = {
		BookService.class,
		BookModelMapperImpl.class
})
@EnableDiscoveryClient
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
