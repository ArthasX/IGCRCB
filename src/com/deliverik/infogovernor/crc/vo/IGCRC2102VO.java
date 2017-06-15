/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import javax.persistence.Id;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;

/**	
 * 概述: 人员工作统计页面显示VO 
 * 创建记录：yukexin 2014-8-8 16:33:31
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2102VO extends BaseVO{

	/** 主键 */
	@Id
	protected String userID;
	
	/** 人员名字 */
	protected String userName;
	   
	/** 事件个数 */
	protected Integer incidentNum;
	
	/** 问题个数 */
	protected Integer problemNum;
	
	/** 变更个数 */
	protected Integer changeNum;
	
	/** 服务请求个数 */
	protected Integer serviceNum;

	/** 服务请求个数 */
	protected Integer developNum;
	
	/** 合计个数 */
	protected Integer total;


	public IGCRC2102VO() {
		super();
	}

	public IGCRC2102VO(IGCRC2101VWInfo vwInfo, Integer total) {
		super();
		this.userID = vwInfo.getUserID();
		this.userName = vwInfo.getUserName();
		this.incidentNum = vwInfo.getIncidentNum();
		this.problemNum = vwInfo.getProblemNum();
		this.changeNum = vwInfo.getChangeNum();
		this.serviceNum = vwInfo.getServiceNum();
		this.developNum = vwInfo.getDevelopNum();
		this.total = total;
	}

	public String getFingerPrint() {
		return null;
	}

	/**
	 * 主键取得
	 * @return userID  主键
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * 主键设定
	 * @param userID  主键
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 人员名字取得
	 * @return userName  人员名字
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 人员名字设定
	 * @param userName  人员名字
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 事件个数取得
	 * @return incidentNum  事件个数
	 */
	public Integer getIncidentNum() {
		return incidentNum;
	}

	/**
	 * 事件个数设定
	 * @param incidentNum  事件个数
	 */
	public void setIncidentNum(Integer incidentNum) {
		this.incidentNum = incidentNum;
	}

	/**
	 * 问题个数取得
	 * @return problemNum  问题个数
	 */
	public Integer getProblemNum() {
		return problemNum;
	}

	/**
	 * 问题个数设定
	 * @param problemNum  问题个数
	 */
	public void setProblemNum(Integer problemNum) {
		this.problemNum = problemNum;
	}

	/**
	 * 变更个数取得
	 * @return changeNum  变更个数
	 */
	public Integer getChangeNum() {
		return changeNum;
	}

	/**
	 * 变更个数设定
	 * @param changeNum  变更个数
	 */
	public void setChangeNum(Integer changeNum) {
		this.changeNum = changeNum;
	}

	/**
	 * 服务请求个数取得
	 * @return serviceNum  服务请求个数
	 */
	public Integer getServiceNum() {
		return serviceNum;
	}

	/**
	 * 服务请求个数设定
	 * @param serviceNum  服务请求个数
	 */
	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
	}

	/**
	 * 服务请求个数取得
	 * @return developNum  服务请求个数
	 */
	public Integer getDevelopNum() {
		return developNum;
	}

	/**
	 * 服务请求个数设定
	 * @param developNum  服务请求个数
	 */
	public void setDevelopNum(Integer developNum) {
		this.developNum = developNum;
	}

	/**
	 * 合计个数取得
	 * @return total  合计个数
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 合计个数设定
	 * @param total  合计个数
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}



}
