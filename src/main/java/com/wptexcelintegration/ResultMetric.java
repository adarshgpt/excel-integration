package com.wptexcelintegration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultMetric {

	private String requestData1;

	private String requestData2;

	private String requestData3;

	private String requestData4;

	private String requestData5;

	private String requestData6;

	private String requestData7;

	@Override
	public String toString() {

		return "Request [requestData1=" + requestData1 + ", requestData2=" + requestData2 + ", requestData3="
				+ requestData3 + ", requestData4=" + requestData4 + ", requestData5=" + requestData5
				+ ", requestData6=" + requestData6 + ", requestData7=" + requestData7 + "]";
	}

	public String getRequestData1() {
		return requestData1;
	}

	public void setRequestData1(String requestData1) {
		this.requestData1 = requestData1;
	}

	public String getRequestData2() {
		return requestData2;
	}

	public void setRequestData2(String requestData2) {
		this.requestData2 = requestData2;
	}

	public String getRequestData3() {
		return requestData3;
	}

	public void setRequestData3(String requestData3) {
		this.requestData3 = requestData3;
	}

	public String getRequestData4() {
		return requestData4;
	}

	public void setRequestData4(String requestData4) {
		this.requestData4 = requestData4;
	}

	public String getRequestData5() {
		return requestData5;
	}

	public void setRequestData5(String requestData5) {
		this.requestData5 = requestData5;
	}

	public String getRequestData6() {
		return requestData6;
	}

	public void setRequestData6(String requestData6) {
		this.requestData6 = requestData6;
	}

	public String getRequestData7() {
		return requestData7;
	}

	public void setRequestData7(String requestData7) {
		this.requestData7 = requestData7;
	}

	

}
