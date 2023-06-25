package base.model;

public class BaseResponse {
	private String statusMessage;
	private String statusCode;
	
	public BaseResponse(String statusMessage, String statusCode) {
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
	}
	
	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
