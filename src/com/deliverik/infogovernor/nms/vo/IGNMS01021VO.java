/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.nms.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.nms.model.NMS02Info;

/**
 * 概述: SNMP配置VO
 * 功能描述: SNMP配置DTO
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGNMS01021VO extends BaseVO implements Serializable {
	
	/** SNMP配置列表 */
	protected List<NMS02Info> lst_NMS02Info;

	/**
	 * SNMP配置列表取得
	 * @return SNMP配置列表
	 */
	public List<NMS02Info> getLst_NMS02Info() {
		return lst_NMS02Info;
	}

	/**
	 * SNMP配置列表设定
	 * @param lst_NMS02Info SNMP配置列表
	 */
	public void setLst_NMS02Info(List<NMS02Info> lst_NMS02Info) {
		this.lst_NMS02Info = lst_NMS02Info;
	}
	
}
