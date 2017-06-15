/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.IG622Info;

/**
 * 概述: 首页管理检索结果ＶＯ
 * 功能描述：首页管理检索结果ＶＯ
 * 创建记录：崔学志   2012/11/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM18011VO extends BaseVO implements Serializable{
	
	/** 首页管理信息检索结果 */
	protected List<IG622Info> firstJspInfoList;

	/**
	 * 构造函数
	 * @param processDefinition　首页管理信息检索结果
	 */
	public IGSYM18011VO(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}
	
	
	/**
	 * 首页管理信息检索结果 取得
	 * @return the firstJspInfoList
	 */
	public List<IG622Info> getFirstJspInfoList() {
		return firstJspInfoList;
	}

	/**
	 *首页管理信息检索结果设置
	 *	
	 * @param firstJspInfoList the firstJspInfoList to set
	 */
	public void setFirstJspInfoList(List<IG622Info> firstJspInfoList) {
		this.firstJspInfoList = firstJspInfoList;
	}

}


