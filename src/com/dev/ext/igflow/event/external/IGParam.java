package com.dev.ext.igflow.event.external;

import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;


public class IGParam implements ExternalParameterInfo {
	
	private String param1;
	
	private String param2;
	
	private Integer param3;
	
	private Integer prid;

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public Integer getParam3() {
		return param3;
	}

	public void setParam3(Integer param3) {
		this.param3 = param3;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
}
