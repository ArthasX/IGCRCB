/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决事件统计实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class IncidentAveSolveTimeVW implements IncidentAveSolveTimeVWInfo{

	/** 事件类型 */
	@Id
	protected String itype;
	
	/** 平均解决事件 */
	protected String solveTime;

	/**
	 * 事件类型取得
	 * @return itype 事件类型
	 */
	public String getItype() {
		return itype;
	}

	/**
	 * 事件类型设定
	 * @param itype 事件类型
	 */
	public void setItype(String itype) {
		this.itype = itype;
	}

	/**
	 * 平均解决事件取得
	 * @return solveTime 平均解决事件
	 */
	public String getSolveTime() {
		return solveTime;
	}

	/**
	 * 平均解决事件设定
	 * @param solveTime 平均解决事件
	 */
	public void setSolveTime(String solveTime) {
		this.solveTime = solveTime;
	}
}
