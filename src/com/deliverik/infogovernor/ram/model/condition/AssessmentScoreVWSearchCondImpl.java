/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model.condition;

import java.util.ArrayList;
import java.util.List;

/**
  * 概述: 评分历史查询检索条件实现
  * 功能描述: 评分历史查询检索条件实现
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public class AssessmentScoreVWSearchCondImpl implements
		AssessmentScoreVWSearchCond {
	/** 流程id */
	protected Integer prid;
	
	/**年度报表年度查询条件*/
	protected String currentyear;
	
	/**部门评估报表查询开始时间*/
	protected String begintime;
	
	/**部门评估报表查询开始时间*/
	protected String endtime;
	
	/** 风险评估打分参与者id*/
	protected String userid;
	
	/** 风险评估流程pdids*/
	protected List<String> list;
	
	/** 风险评估部门评估统计 使用toporgid*/
	protected String topOrgid;
	
	/**
	 * prid取得
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * prid设定
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * currentyear取得
	 */
	public String getCurrentyear() {
		return currentyear;
	}

	/**
	 * currentyear设定
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	/**
	 * begintime取得
	 */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * begintime设定
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	/**
	 * endtime取得
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * endtime设定
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * userid取得
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid设定
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 风险评估流程pdidslist取得
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * 风险评估流程pdidslist设定
	 */
	public void setList(List<String> list) {
		this.list = new ArrayList<String>();
		this.list = list;
	}

	/**
	 * topOrgid取得
	 */
	public String getTopOrgid() {
		return topOrgid;
	}

	/**
	 * topOrgid设定
	 */
	public void setTopOrgid(String topOrgid) {
		this.topOrgid = topOrgid;
	}
	
	
}