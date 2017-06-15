/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划表单信息查询条件实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0003SearchCondImpl implements IGDWP0003SearchCond{

	/** 流程信息ID */
	protected Integer prid;

	/**
	 * 流程信息ID取得
	 * @return prid 流程信息ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程信息ID设定
	 * @param prid 流程信息ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
