package org.system.domain.exception;

public class OperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6897074663031548430L;
	
	public String code = "";
	public String status = "";
	
	public OperationException(String code,String message) {
		super(message);
		this.code = code;
    }
	
	public OperationException(String status,String code,String message) {
		super(message);
		this.status = status;
		this.code = code;
    }
	
	public OperationException(String status,String code,String message,Throwable cause) {
		super(message,cause);
		this.status = status;
		this.code = code;
    }

}
