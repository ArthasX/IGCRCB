/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 流程处理_按机构查询执行人Form
 * @Author  
 * @History 2013-02-28     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0121Form extends BaseForm {
	
	/** 流程ID */
	protected int prid;

	/** 流程当前状态 */
	protected String prstatus;
	
	/** 当前处理人机构层次码 */
	protected String pporgid;
	
	/** 添加参与人数组 */
	protected String[] ppuserids;
	
	/** 添加参与人角色授权id*/
	protected int[] urids;
	
	/**
	 * 流程ID取得
	 *
	 * @return prid 流程ID
	 */
	public int getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid 流程ID
	 */
	public void setPrid(int prid) {
		this.prid = prid;
	}

	/**
	 * 流程当前状态取得
	 *
	 * @return prstatus 流程当前状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程当前状态设定
	 *
	 * @param prstatus 流程当前状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 当前处理人机构层次码取得
	 *
	 * @return pporgid 当前处理人机构层次码
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * 当前处理人机构层次码设定
	 *
	 * @param pporgid 当前处理人机构层次码
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * 添加参与人数组取得
	 *
	 * @return ppuserids 添加参与人数组
	 */
	
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * 添加参与人数组设定
	 *
	 * @param ppuserids 添加参与人数组
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}

	/**
	 * 添加参与人角色授权id取得
	 *
	 * @return urids 添加参与人角色授权id
	 */
	public int[] getUrids() {
		return urids;
	}

	/**
	 * 添加参与人角色授权id设定
	 *
	 * @param urids 添加参与人角色授权id
	 */
	public void setUrids(int[] urids) {
		this.urids = urids;
	}
	
}
