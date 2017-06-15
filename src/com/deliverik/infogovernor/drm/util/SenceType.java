package com.deliverik.infogovernor.drm.util;

import org.apache.commons.lang.StringUtils;

public enum SenceType{
	
	SINGLE("单一场景","0"), 
	COMBINATION("组合场景","1");
	
	private String code = "";
	private String name = "";
	
	private SenceType(String name,String code){
		this.code = code;
		this.name = name;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 通过code获取场景类型名
	 * @param code String 场景类型CODE 
	 */
	public static String getNameByCode(String code){
		String name = "";
		if(!StringUtils.isBlank(code)){
			for(SenceType typeInfo:SenceType.values()){
				if(code.equals(typeInfo.getCode())){
					name = typeInfo.getName();
				}
			}
		}
		return name;
	}
	
}
