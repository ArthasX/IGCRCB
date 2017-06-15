/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0001Info extends BaseModel{

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 计划名称取得
	 * @return pname 计划名称
	 */
	public String getPname();

	/**
	 * 计划描述取得
	 * @return pdesc 计划描述
	 */
	public String getPdesc();
	
	/**
	 * 发起人ID取得
	 * @return puserid 发起人ID
	 */
	public String getPuserid();
	
	/**
	 * 发起人姓名取得
	 * @return pusername 发起人姓名
	 */
	public String getPusername();

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid();

	/**
	 * 流程名称取得
	 * @return pdname 流程名称
	 */
	public String getPdname();

	/**
	 * 短信内容取得
	 * @return smscontent 短信内容
	 */
	public String getSmscontent();

	/**
	 * 开始时间取得
	 * @return startdate 开始时间
	 */
	public String getStartdate();

	/**
	 * 结束时间取得
	 * @return enddate 结束时间
	 */
	public String getEnddate();

	/**
	 * 计划模式取得
	 * @return pmode 计划模式
	 */
	public String getPmode();

	/**
	 * 计划类型取得
	 * @return ptype 计划类型
	 */
	public String getPtype();

	/**
	 * 计划执行时间：小时取得
	 * @return hour 计划执行时间：小时
	 */
	public String getPhour();

	/**
	 * 计划执行时间：分钟取得
	 * @return pminute 计划执行时间：分钟
	 */
	public String getPminute();
	
	/**
	 * 是否添加JOB取得
	 * @return isAddJob 是否添加JOB
	 */
	public String getIsAddJob();
}
