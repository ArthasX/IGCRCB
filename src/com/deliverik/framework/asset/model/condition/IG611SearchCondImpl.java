/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.utility.CommonDefineUtils;

/**
  * 概述: 资产模型属性缺省值检索条件实现
  * 功能描述: 资产模型属性缺省值检索条件实现
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public class IG611SearchCondImpl implements
		IG611SearchCond {

	/** 模型层次码 */
	protected String esyscoding;
	
	/** 模型id */
	protected String eid;
	
	/** 模型层次码集合 */
	protected List<String> esyscodingList;

	/**
	 * 模型id取得
	 *
	 * @return eid 模型id
	 */
	
	public String getEid() {
		return eid;
	}

	/**
	 * 模型id设定
	 *
	 * @param eid 模型id
	 */
	
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 模型层次码取得
	 * 
	 * @return 模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 模型层次码设定
	 * 
	 * @param esyscoding 模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 模型层次码集合取得
	 * 
	 * @return 模型层次码集合
	 */
	public List<String> getEsyscodingList() {
		if(StringUtils.isNotEmpty(esyscoding)) {
			esyscodingList = new ArrayList<String>();
			int ccid = CommonDefineUtils.CCID_LENGTH + CommonDefineUtils.TREE_LEVEL_CODE;
			esyscodingList.add(esyscoding.substring(0, ccid));
			while(esyscoding.length() > ccid){
				ccid = ccid + CommonDefineUtils.CCID_LENGTH;
				esyscodingList.add(esyscoding.substring(0, ccid));
			}
		}
		return esyscodingList;
	}
	
}