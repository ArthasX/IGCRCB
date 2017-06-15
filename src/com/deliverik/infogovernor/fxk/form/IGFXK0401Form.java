/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 模型树查询Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0401Form extends BaseForm{
	
	/** 流程ID */
	protected Integer prid;

	/** 资产一级模型 */
	protected String subtype;
	
	/** 模型信息 */
	protected String esyscoding;

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 资产一级模型取得
	 * @return subtype 资产一级模型
	 */
	public String getSubtype() {
		return subtype;
	}

	/**
	 * 资产一级模型设定
	 * @param subtype 资产一级模型
	 */
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * 模型信息取得
	 * @return esyscoding 模型信息
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 模型信息设定
	 * @param esyscoding 模型信息
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}
