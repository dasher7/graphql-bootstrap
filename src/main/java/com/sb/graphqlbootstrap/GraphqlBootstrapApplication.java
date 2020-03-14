package com.sb.graphqlbootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sb.graphqlbootstrap.model.Author;
import com.sb.graphqlbootstrap.model.Book;
import com.sb.graphqlbootstrap.repository.AuthorRepository;
import com.sb.graphqlbootstrap.repository.BookRepository;
import com.sb.graphqlbootstrap.resolver.BookResolver;
import com.sb.graphqlbootstrap.resolver.Mutation;
import com.sb.graphqlbootstrap.resolver.Query;

@SpringBootApplication
public class GraphqlBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlBootstrapApplication.class, args);
	}
	
	/*
	 * we need to instantiate all the bean to set up our working pieces
	 * we alsways need to setup:
	 * 	- resolvers
	 * 	- query (there could be only one)
	 * 	- mutation (there could be only one)
	 */
	
	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Query(bookRepository, authorRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		return new Mutation(authorRepository, bookRepository);
	}
	
	/*
	 * we are going to use a basic command to setup some date into our H2 database
	 */
	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookResolver bookResolver, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author("Edgar Allan", "Poe");
			authorRepository.save(author);
			Book book = new Book("The adventure of Gordon Pym", "00000000000007", 176, author);
			bookRepository.save(book);
		};
	}

}
