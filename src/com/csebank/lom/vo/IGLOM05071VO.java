/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 食堂接待管理VO
 *
 */
public class IGLOM05071VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 食堂接待管理检索结果
	 */
	protected List<Eentertainment> eentertainmentList;

	/**
	 * 食堂接待管理检索结果取得
	 * @return 食堂接待管理检索结果
	 */
	public List<Eentertainment> getEentertainmentList() {
		return eentertainmentList;
	}

	/**
	 * 食堂接待管理检索结果
	 * @param eentertainmentList 食堂接待管理检索结果
	 */
	public void setEentertainmentList(List<Eentertainment> eentertainmentList) {
		this.eentertainmentList = eentertainmentList;
	}

}
