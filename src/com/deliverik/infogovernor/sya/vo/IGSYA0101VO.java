/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sya.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;

/**
 * 概述: 制度查询vo
 * 创建记录:  
 * 修改记录: 
 */

@SuppressWarnings("serial")
public class IGSYA0101VO extends BaseVO implements Serializable {
    
	/**查询结果返回*/
    protected List<InstitutionInfo> institutionList;

	/**
	 * 查询结果返回取得
	 * @return institutionList  查询结果返回
	 */
	public List<InstitutionInfo> getInstitutionList() {
		return institutionList;
	}

	/**
	 * 查询结果返回设定
	 * @param institutionList  查询结果返回
	 */
	public void setInstitutionList(List<InstitutionInfo> institutionList) {
		this.institutionList = institutionList;
	}

    
}