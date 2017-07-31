/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作日志接口
  * 功能描述: 工作日志接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkLogInfo extends BaseModel {

	/**
	 * 取得 主键
	 * 
	 * @return wlid
	*/
	public Integer getPK() ;
	

	/**
	 * 取得 主键
	 * 
	 * @return wlid
	*/
	public Integer getWlid() ;
	

	/**
	 * 取得 工作实例表主键
	 * 
	 * @return wiid
	*/
	public Integer getWiid() ;
	

	/**
	 * 取得 执行人
	 * 
	 * @return excutorId
	*/
	public String getExcutorId();
	

	/**
	 * 取得 执行人名称
	 * 
	 * @return excutorName
	*/
	public String getExcutorName() ;
	

	/**
	 * 取得 日期栏日期
	 * 
	 * @return titleDate
	*/
	public String getTitleDate() ;
	

	/**
	 * 取得 执行时间（小时）
	 * 
	 * @return excuteTime
	*/
	public String getExcuteTime() ;

	/**
	 * 取得 实际处理日期
	 * 
	 * @return actualDealwithDate
	*/
	public String getActualDealwithDate();
	

	/**
	 * 取得 执行情况描述
	 * 
	 * @return wlDescription
	*/
	public String getWlDescription() ;
	

	/**
	 * 取得 表记录创建日期
	 * 
	 * @return crtDate
	*/
	public String getCrtDate();

	/**
	 * 取得 按钮动作
	 * 
	 * @return btnAction
	*/
	public String getBtnAction();
	
}