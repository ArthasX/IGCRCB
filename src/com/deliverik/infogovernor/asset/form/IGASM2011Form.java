/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 导入对象版本查询画面FORM
 * 功能描述: 导入对象版本查询画面FORM
 * 创建记录: 2011/05/05
 * 修改记录: 
 */
public class IGASM2011Form extends BaseForm implements ImportVersionSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 实体名 */
	protected String impeiname;
	
	/** 版本号 */
	protected Integer impversion;
	
	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * 实体名设定
	 * @param impeiname实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}
	
	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 版本号设定
	 * @param impversion版本号
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	public String getDeleteflag_eq() {
		return null;
	}

	public String getImpeiname_like() {
		return null;
	}

	public String getImpeiname_eq() {
		return null;
	}


	public String getEilabel() {
		return null;
	}

	public String getEiddid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

}
