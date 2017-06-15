/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top5统计数据vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06371VO extends BaseVO{
	
	/** 部门服务top5统计数据 */
	protected List<ServiceTopFiveVWInfo> serviceTopFiveList;

	/**
	 * 部门服务top5统计数据取得
	 * @return serviceTopFiveList 部门服务top5统计数据
	 */
	public List<ServiceTopFiveVWInfo> getServiceTopFiveList() {
		return serviceTopFiveList;
	}

	/**
	 * 部门服务top5统计数据设定
	 * @param serviceTopFiveList 部门服务top5统计数据
	 */
	public void setServiceTopFiveList(List<ServiceTopFiveVWInfo> serviceTopFiveList) {
		this.serviceTopFiveList = serviceTopFiveList;
	}
}
