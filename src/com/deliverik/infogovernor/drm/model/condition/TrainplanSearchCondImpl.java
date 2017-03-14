/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训计划表检索条件实现
  * 功能描述: 培训计划表检索条件实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
public class TrainplanSearchCondImpl implements
		TrainplanSearchCond {
	

	/** 发起人姓名 */
	protected String tpusername;

	/** 发起部门名称 */
	protected String tporgname;
	
	/** 发起时间开始时间 */
	protected String startTimeBegin;
	
	/** 发起时间结束时间 */
	protected String startTimeEnd;
	
	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getTpusername() {
		return tpusername;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param tpusername 发起人姓名
	 */
	public void setTpusername(String tpusername) {
		this.tpusername = tpusername;
	}

	/**
	 * 发起部门名称取得
	 *
	 * @return 发起部门名称
	 */
	public String getTporgname() {
		return tporgname;
	}

	/**
	 * 发起部门名称设定
	 *
	 * @param tporgname 发起部门名称
	 */
	public void setTporgname(String tporgname) {
		this.tporgname = tporgname;
	}

	/**
	 * 发起时间开始时间取得
	 *
	 * @return 发起时间开始时间
	 */
	public String getStartTimeBegin() {
		return startTimeBegin;
	}
 
	/**
	 * 发起时间开始时间设定
	 *
	 * @return startTimeBegin 发起时间开始时间
	 */
	public void setStartTimeBegin(String startTimeBegin) {
		this.startTimeBegin = startTimeBegin;
	}

	/**
	 * 发起时间结束时间取得
	 *
	 * @return 发起时间结束时间
	 */
	public String getStartTimeEnd() {
		return startTimeEnd;
	}

	/**
	 * 发起时间结束时间设定
	 *
	 * @return startTimeEnd 发起时间结束时间
	 */
	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}
	
	
}