/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * 概述: 程序开发统计功能伪视图
 * 创建记录：yukexin    2014-8-12 10:57:13
 * 修改记录：null
 */	
@SuppressWarnings("serial")
@Entity
public class IGCRC2301VW implements Serializable,IGCRC2301VWInfo{

	/** 主键 */
	@Id
	protected String userID;
	
	/** 人员名字 */
	protected String userName;
	   
	/** 处理工单数 */
	protected Integer disposeNum;
	
	/** 测试更新驳回次数 */
	protected int testUpdateRejectNum;
	
	/** 测试驳回次数 */
	protected int testRejectNum;
	
	/** 确认驳回次数 */
	protected int confirmRejectNum;

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
	 * 处理工单数取得
	 * @return disposeNum  处理工单数
	 */
	public Integer getDisposeNum() {
		if(disposeNum == null){
			this.disposeNum = 0;
		}
		return disposeNum;
	}

	/**
	 * 处理工单数设定
	 * @param disposeNum  处理工单数
	 */
	public void setDisposeNum(Integer disposeNum) {
		this.disposeNum = disposeNum;
	}

	/**
	 * 测试更新驳回次数取得
	 * @return testUpdateRejectNum  测试更新驳回次数
	 */
	public int getTestUpdateRejectNum() {
		return testUpdateRejectNum;
	}

	/**
	 * 测试更新驳回次数设定
	 * @param testUpdateRejectNum  测试更新驳回次数
	 */
	public void setTestUpdateRejectNum(int testUpdateRejectNum) {
		this.testUpdateRejectNum = testUpdateRejectNum;
	}

	/**
	 * 测试驳回次数取得
	 * @return testRejectNum  测试驳回次数
	 */
	public int getTestRejectNum() {
		return testRejectNum;
	}

	/**
	 * 测试驳回次数设定
	 * @param testRejectNum  测试驳回次数
	 */
	public void setTestRejectNum(int testRejectNum) {
		this.testRejectNum = testRejectNum;
	}

	/**
	 * 确认驳回次数取得
	 * @return confirmRejectNum  确认驳回次数
	 */
	public int getConfirmRejectNum() {
		return confirmRejectNum;
	}

	/**
	 * 确认驳回次数设定
	 * @param confirmRejectNum  确认驳回次数
	 */
	public void setConfirmRejectNum(int confirmRejectNum) {
		this.confirmRejectNum = confirmRejectNum;
	}


}
