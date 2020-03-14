package com.sb.graphqlbootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sb.graphqlbootstrap.model.Author;
import com.sb.graphqlbootstrap.model.Book;
import com.sb.graphqlbootstrap.repository.AuthorRepository;

/*
 * For scalar fields (int, string, bool etc etc)
 * normal getter and setter are fine to resolve their values
 * 
 * But for complex type like, in this case, Author and Book,
 * you need to implement a Resolver in order to resolve those objects.
 */

public class BookResolver implements GraphQLResolver<Book>{
	
	private AuthorRepository authorRepository;
	
	public BookResolver(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	/*
	 * it would be better to return Optional<Author>
	 * the following method it is used to resolve Authro field into Book class
	 */
	
	public Author getAuthor(Book book) {
		return authorRepository.findById(book.getAuthor().getId()).get();
	}

}
