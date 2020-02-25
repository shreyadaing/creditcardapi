package com.creditcard.exceptionhandler;

import java.util.Date;
import java.util.List;

public class ErrorResponse
{
    public ErrorResponse(Date timestamp, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
 
    public ErrorResponse(Date date, String message) {
		// TODO Auto-generated constructor stub
    	super();
    	this.timestamp = date;
    	this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	private Date timestamp;
    
    //General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    } 
}
