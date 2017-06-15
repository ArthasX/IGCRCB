package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**	
 * 概述: 检查项信息vo
 * 创建记录：yukexin    2014-9-4 上午10:22:25	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGRIS06141VO extends BaseVO implements Serializable{
	
	/** 检查项id  */	
	private String eiid;
	
	/** 检查项编码  */	
	private String eilabel;
	
	/** 检查项名称  */	
	private String checkitemName;
	
	/** 检查项说明  */	
	private String checkitemDesc;
	
	/** 检查项描述  */	
	private String checkitemMethod;

	/**
	 * 检查项id取得
	 * @return eiid  检查项id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 检查项id设定
	 * @param eiid  检查项id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 检查项编码取得
	 * @return eilabel  检查项编码
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 检查项编码设定
	 * @param eilabel  检查项编码
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 检查项名称取得
	 * @return checkitemName  检查项名称
	 */
	public String getCheckitemName() {
		return checkitemName;
	}

	/**
	 * 检查项名称设定
	 * @param checkitemName  检查项名称
	 */
	public void setCheckitemName(String checkitemName) {
		this.checkitemName = checkitemName;
	}

	/**
	 * 检查项说明取得
	 * @return checkitemDesc  检查项说明
	 */
	public String getCheckitemDesc() {
		return checkitemDesc;
	}

	/**
	 * 检查项说明设定
	 * @param checkitemDesc  检查项说明
	 */
	public void setCheckitemDesc(String checkitemDesc) {
		this.checkitemDesc = checkitemDesc;
	}

	/**
	 * 检查项描述取得
	 * @return checkitemMethod  检查项描述
	 */
	public String getCheckitemMethod() {
		return checkitemMethod;
	}

	/**
	 * 检查项描述设定
	 * @param checkitemMethod  检查项描述
	 */
	public void setCheckitemMethod(String checkitemMethod) {
		this.checkitemMethod = checkitemMethod;
	}
	
}

