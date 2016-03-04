package com.yash.bean;

/**
 * The Class ServerBean.
 */
public class ServerBean {
	
	/** The method. */
	private String method;
	
	/** The taget url. */
	private String url;
	
	private String status;
	
	/** The payload. */
	private Object payload;
	
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String tagetURL) {
		this.url = tagetURL;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
