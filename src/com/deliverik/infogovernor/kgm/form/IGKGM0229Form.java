/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 知识日志查询
 * 功能描述：知识日志查询Form
 * 创建记录： 2011-5-30 新建
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGKGM0229Form extends BaseForm {

	/** 知识ID */
	protected Integer klkid;

	/**
	 * 知识ID设定
	 * @param klkid 知识ID
	 */
	public void setKlkid(Integer klkid) {
		this.klkid = klkid;
	}

	/**
	 * 知识ID取得
	 * @return klkid 知识ID
	 */
	public Integer getKlkid() {
		return klkid;
	}

}
