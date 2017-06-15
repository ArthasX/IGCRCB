/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;

/**
 * 概述: 采集结果信息检索结果ＶＯ
 * 功能描述: 采集结果信息检索结果ＶＯ
 * 创建记录: 2013/05/21
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM08021VO extends BaseVO implements Serializable{
	
	/** 版本列表 */
	protected List<SOC0120Info> soc0120List;
	
	/**采集对象集合*/
	protected List<CR03Info> cr03InfoList;
	
	protected List<CR03VWInfo> cr03VWInfoList;
	
	


	public List<CR03VWInfo> getCr03VWInfoList() {
		return cr03VWInfoList;
	}
	public void setCr03VWInfoList(List<CR03VWInfo> cr03VWInfoList) {
		this.cr03VWInfoList = cr03VWInfoList;
	}
	/**
	 * 版本列表取得
	 *
	 * @return soc0128List 版本列表
	 */
	public List<SOC0120Info> getSoc0120List() {
		return soc0120List;
	}
	/**
	 * 版本列表设定
	 *
	 * @param soc0120List 版本列表
	 */
	public void setSoc0120List(List<SOC0120Info> soc0120List) {
		this.soc0120List = soc0120List;
	}
	/**
	 * 采集对象集合取得
	 *
	 * @return cr03InfoList 采集对象集合
	 */
	
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	/**
	 * 采集对象集合设定
	 *
	 * @param cr03InfoList 采集对象集合
	 */
	
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}

	
}
