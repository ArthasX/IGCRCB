/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.nms.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * 概述: 任务配置VO
 * 功能描述: 任务配置DTO
 * 创建记录: 2013/12/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGNMS01031VO extends BaseVO implements Serializable {
	
	/** 任务配置列表 */
	protected List<NMS03Info> lst_NMS03Info;

	/**
	 * 任务配置列表取得
	 * @return 任务配置列表
	 */
	public List<NMS03Info> getLst_NMS03Info() {
		return lst_NMS03Info;
	}

	/**
	 * 任务配置列表设定
	 * @param lst_NMS03Info 任务配置列表
	 */
	public void setLst_NMS03Info(List<NMS03Info> lst_NMS03Info) {
		this.lst_NMS03Info = lst_NMS03Info;
	}
	
}
