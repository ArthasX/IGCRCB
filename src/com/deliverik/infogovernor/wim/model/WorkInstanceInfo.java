/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作实例接口
  * 功能描述: 工作实例接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkInstanceInfo extends BaseModel {

	/**
	 * 取得 主键
	 * 
	 * @return wiid
	*/
	public Integer getPK() ;

	/**
	 * 取得 主键
	 * 
	 * @return wiid
	*/
	public Integer getWiid() ;
	

	/**
	 * 取得 工作定义表主键
	 * 
	 * @return wdid
	*/
	public Integer getWdid() ;
	

	/**
	 * 取得 工作项名称
	 * 
	 * @return wdname
	*/
	public String getWdname() ;
	

	/**
	 * 取得 工作实例名称
	 * 
	 * @return winame
	*/
	public String getWiname();
	

	/**
	 * 取得 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 * 
	 * @return wistatus
	*/
	public String getWistatus() ;
	

	/**
	 * 取得 发起人（userid）
	 * 
	 * @return initiatorId
	*/
	public String getInitiatorId() ;

	/**
	 * 取得 周期频率
	 * 
	 * @return cycle
	*/
	public String getCycle() ;
	

	/**
	 * 取得 工作项描述
	 * 
	 * @return description
	*/
	public String getDescription() ;
	

	/**
	 * 取得 开始日期
	 * 
	 * @return beginDate
	*/
	public String getBeginDate() ;
	

	/**
	 * 取得 负责人
	 * 
	 * @return leaderId
	*/
	public String getLeaderId();
	

	/**
	 * 取得 负责人名称
	 * 
	 * @return leaderName
	*/
	public String getLeaderName() ;
	

	/**
	 * 取得 执行人
	 * 
	 * @return excutorId
	*/
	public String getExcutorId() ;
	

	/**
	 * 取得 执行人名称
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() ;
	

	/**
	 * 取得 发起类型（1，自动发起；2，手动发起）
	 * 
	 * @return wiLunchType
	*/
	public String getWiLunchType();
	

	/**
	 * 取得 执行需所时间（小时）
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() ;
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wiDescription
	*/
	public String getWiDescription() ;
	

	/**
	 * 取得 工作确认日期
	 * 
	 * @return confirmDate
	*/
	public String getConfirmDate() ;
	

	/**
	 * 取得 日期栏日期
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() ;
	

	/**
	 * 取得 表记录创建日期
	 * 
	 * @return crtDate
	*/
	public String getCrtDate() ;
	
}