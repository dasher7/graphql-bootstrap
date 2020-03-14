package com.sb.graphqlbootstrap.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/*
 * Please note that GraphQL has its own particular way of handling errors.
 * 
 * if a generic error, like a NullPointerException will be throw in a method
 * it will be translated into an Internal Server Error on the client side.
 * 
 * The thing is: any unhandled exception happening on the server side will be treated as
 * a generic Internal Server Error.
 * 
 * If we want the client to throw a correct error to help debug and better understanding
 * of how our GraphQL works, it's suggested to create a specific error class, implementing GraphQLError
 */

public class BookNotFoundException extends RuntimeException implements GraphQLError{

	private static final long serialVersionUID = 57939694790439690L;
	private Map<String, Object> errorMap = new HashMap<String, Object>();
	
	public BookNotFoundException(String message, Long invalidBookId) {
		super(message);
		errorMap.put("InvalidBookId", invalidBookId);
	}
	
	public Map<String, Object> getErrorMap() {
		return errorMap;
	}
	
	@Override
	public List<SourceLocation> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		// TODO Auto-generated method stub
		return ErrorType.DataFetchingException;
	}

}
