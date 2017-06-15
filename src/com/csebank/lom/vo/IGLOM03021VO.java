/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 预支费用管理VO
 *
 */
public class IGLOM03021VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 预支费用管理检索结果
	 */
	protected List<AdvanCescost> advanCescostList;

	/**
	 * 预支费用管理检索结果取得
	 * @return 预支费用管理检索结果
	 */
	public List<AdvanCescost> getAdvanCescostList() {
		return advanCescostList;
	}

	/**
	 * 预支费用管理检索结果
	 * @param advanCescostList 预支费用管理检索结果
	 */
	public void setAdvanCescostList(List<AdvanCescost> advanCescostList) {
		this.advanCescostList = advanCescostList;
	}

}
