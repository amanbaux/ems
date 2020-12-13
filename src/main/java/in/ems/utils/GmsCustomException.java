
package in.ems.utils;

public class GmsCustomException extends Exception {
	
	public GmsCustomException() {}
	
	public GmsCustomException(String errorCode, String messageText, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.messageText = messageText;
	} 
	
	public GmsCustomException(String errorCode, String messageText) {
		super();
		this.errorCode = errorCode;
		this.messageText = messageText;
	}

	private String errorCode; 
	private String messageText; 
	
	public String getErrorCode() { 
		return errorCode; 
	}  

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	@Override
	public String toString() {
		return "GmsCustomException [errorCode=" + errorCode + ", messageText=" + messageText + "]";
	}

	
	

}
