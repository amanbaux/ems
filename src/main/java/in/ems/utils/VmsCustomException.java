package in.ems.utils;

public class VmsCustomException extends Exception {
	
	public VmsCustomException() {}
	
	public VmsCustomException(String errorCode, String messageText, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.messageText = messageText;
	}
	
	public VmsCustomException(String errorCode, String messageText) {
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
		return "VmsCustomException [errorCode=" + errorCode + ", messageText=" + messageText + "]";
	}
	
	

}
