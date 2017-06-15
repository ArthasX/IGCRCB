/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;

/**
 * 概述:监控类型阀值显示VO
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT01021VO extends BaseVO implements Serializable {
	/**
	 * 监控类型阀值信息集合
	 */
	protected List<MonitorTypeDefInfo> monitorTypeDefInfoList;
	
	/**
	 * 监控类型阀值信息集合获取
	 * @return
	 */
	public List<MonitorTypeDefInfo> getMonitorTypeDefInfoList() {
		return monitorTypeDefInfoList;
	}

	/**
	 * 构造函数
	 * @param monitorTypeDefInfoList
	 */
	public IGMNT01021VO(List<MonitorTypeDefInfo> monitorTypeDefInfoList){
		this.monitorTypeDefInfoList=monitorTypeDefInfoList;
	}

	
}
