/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: 日常运维计划VO
 * </p>
 * 
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGMTP01011VO extends BaseVO implements Serializable {

	private String beginDate;
	
	private User user;
	
	private List<IG380Info> pdList;
	
	/**
	 * 需要执行运维计划的日期集合
	 */
	private List<String> dateList;
	
	/**
	 * 运维计划开始日期
	 */
	private String startDate;
	
	/**
	 * 运维计划结束日期
	 */
	private String endDate;
	
	
	
	public List<String> getDateList() {
		return dateList;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<IG380Info> getPdList() {
		return pdList;
	}

	public void setPdList(List<IG380Info> pdList) {
		this.pdList = pdList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
}
