/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;

/**
 * @Description: 存放资产信息ＶＯ
 * @Author  
 * @History 2009-8-18     新建
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGASM03171VO extends BaseVO implements Serializable{
	/** 存放资产编号和名称 */
	protected List<LabelValueBean> relationList;

	public List<LabelValueBean> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}
	
}