/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
 * 概述:监控对象显示VO
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01041VO extends BaseVO implements Serializable {
	/**
	 * 监控对象集合
	 */
	protected List<MonitorObjectInfo> monitorObjectList;

	/**
	 * 构造函数
	 * @param monitorObjectList
	 */
	public IGMNT01041VO(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList=monitorObjectList;
	}

	/**
	 * 监控对象集合获取
	 * @return
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}
	
}
