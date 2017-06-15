/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作统计接口
 * </p>
 * 
 */
public interface IGCRC2401VWInfo {
	
	public String getUserId();
	
	public String getMainId();

	public String getUserName();
	
	public String getStartTime();
	
	public String getEndTime();
	
	public String getGrade();
	
	public String getConfirmtime();
	/**
	 * 流程主键获取
	 * @return the prid
	 */
	public Integer getPrid();
}
