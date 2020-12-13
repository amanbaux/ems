package in.ems.response;

import in.ems.utils.CommonConstants;

public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = CommonConstants.BEARER;
	private String messageText;
	private String errorCode;
        private String roleId;

	public JwtAuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public JwtAuthenticationResponse(String accessToken, String messageText, String errorCode,String roleId) {
		super();
		this.accessToken = accessToken;
		this.messageText = messageText;
		this.errorCode = errorCode;
                this.roleId=roleId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

}
