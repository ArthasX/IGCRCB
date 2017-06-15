/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训记录检索条件接口
  * 功能描述: 培训记录检索条件接口
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public interface TrainrecordSearchCond {
	public Integer getTrid();

	/** 培训名称 */
	public String getTrname();

	/** 培训计划id */
	public Integer getTpid();

	/** 培训计划名称 */
	public String getTpname();

	/** 培训内容 */
	public String getTpcontent();

	/** 培训开始时间 */
	public String getTrstime();

	/** 培训结束时间 */
	public String getTretime();

	/** 培训地点 */
	public String getTrside();

	/** 讲师 */
	public String getTrlecturer();

	/** 附件 */
	public String getTratt();
	/**  
	 * 获取培训开始时间起始  
	 * @return trstimeFrom 培训开始时间起始  
	 */
	
	public String getTrstimeFrom() ;

	/**  
	 * 获取培训开始时间终止  
	 * @return trstimeTo 培训开始时间终止  
	 */
	
	public String getTrstimeTo();
}