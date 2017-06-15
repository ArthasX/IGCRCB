/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 合同应付款登记ＶＯ
 * 功能描述: 合同应付款登记ＶＯ
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM04201VO extends BaseVO implements Serializable {
	
	
	/** 合同应付款登记信息检索结果 */
	protected List<IG499Info> entityItemCompactVWList;

	/**
	 * 合同应付款登记信息检索结果取得
	 *
	 * @return entityItemCompactVWList 合同应付款登记信息检索结果
	 */
	public List<IG499Info> getEntityItemCompactVWList() {
		return entityItemCompactVWList;
	}

	/**
	 * 合同应付款登记信息检索结果设定
	 *
	 * @param entityItemCompactVWList 合同应付款登记信息检索结果
	 */
	public void setEntityItemCompactVWList(
			List<IG499Info> entityItemCompactVWList) {
		this.entityItemCompactVWList = entityItemCompactVWList;
	}
	
}
