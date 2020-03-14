package com.sb.graphqlbootstrap.error;

import java.util.List;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/*
 * Note: by using an escpetion as a GraphQLError, the client will recieve
 * all the stack trace, other than the message we have set.
 * 
 * In order to avoid that behavior, we can use wrapper (adapter in GraphQL terms)
 * which goal is to hide the exception stacktrace.
 * (message will be wrapepd into ExceptionWhileDataFetching)
 * 
 * In order to use the adapter you need to set it up in your main Spring Boot class
 */

public class GRaphQLErrorAdapter implements GraphQLError {

	private static final long serialVersionUID = 4902456190925672443L;
	private GraphQLError error;
	
	public GRaphQLErrorAdapter(GraphQLError error) {
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error.getMessage();
	}

	@Override
	public List<SourceLocation> getLocations() {
		return error.getLocations();
	}

	@Override
	public ErrorType getErrorType() {
		return error.getErrorType();
	}

}
