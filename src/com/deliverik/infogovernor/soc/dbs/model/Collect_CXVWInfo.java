/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.model;

import java.math.BigDecimal;
/**
 * 
 * @Description:存储实时信息视图实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_CXVWInfo {

	/** 获取设备 */
	public String getObject_Name();

	/** 获取使用率 */
	public BigDecimal getSysBusy();

	/** 获取时间 */
	public String getSymtime();

	/** 获取设备序列号 */
	public String getDataid();

}
