package com.wptexcelintegration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Url {

	private String url;

	private String location;

	@Override
	public String toString() {

		return "Url [url=" + url + ", location=" + location + "]";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
