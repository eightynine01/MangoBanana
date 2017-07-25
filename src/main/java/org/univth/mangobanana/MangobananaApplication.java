package org.univth.mangobanana;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.univth.mangobanana.article.domain.Article;
import org.univth.mangobanana.article.domain.Reply;
import org.univth.mangobanana.article.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MangobananaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangobananaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ArticleRepository articleRepository) {
		return (args) -> {
			List<Article> articles = new ArrayList<>();
			for(int i = 0 ; i < 10 ; i ++){
				Article article = new Article("테스트"+String.valueOf(i),"컨텐츠"+String.valueOf(i));
				article.addReply(new Reply("테스트"+String.valueOf(i),"컨텐츠"+String.valueOf(i)));
				articles.add(article);
			}

			articleRepository.save(articles);
			for(Article article: articleRepository.findAll()) {
				log.info(article.getArticleTitle());
				log.info(article.getArticleContent());
			}
//			// save a couple of customers
//			repository.save(new Customer("Jack", "Bauer"));
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
		};
	}

}
