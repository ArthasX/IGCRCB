/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.emo.dto;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;

/**
 * oracle性能监控DTO
 *
 */
@SuppressWarnings("serial")
public class IGEMO01DTO extends BaseDTO implements Serializable {
	
	/** 类型 */
	protected String em_type;
	
	/** 资产ID */
	protected String eiid;
	
	/** 监控数据 */
	protected Map<String,Object> EmData;

	/**
	 * 类型取得
	 * @return em_type 类型
	 */
	public String getEm_type() {
		return em_type;
	}

	/**
	 * 类型设定
	 * @param em_type 类型
	 */
	public void setEm_type(String em_type) {
		this.em_type = em_type;
	}

	/**
	 * emData取得
	 * @return emData emData
	 */
	public Map<String, Object> getEmData() {
		return EmData;
	}

	/**
	 * emData设定
	 * @param emData emData
	 */
	public void setEmData(Map<String, Object> emData) {
		EmData = emData;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
