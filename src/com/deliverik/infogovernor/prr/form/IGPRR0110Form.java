/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;

 
/**
 * @Description: 流程状态日志查看Form
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0110Form extends BaseForm implements IG224SearchCond {

	/** 流程ID */
	protected Integer prid;
	
	/** 是否查询流程当前状态记录标识 */
	protected boolean currentPrstatus;

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID取得
	 * 
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程状态取得
	 * 
	 * @return 流程状态
	 */
	public boolean isCurrentPrstatus() {
		return currentPrstatus;
	}

	/**
	 * 是否查询流程当前状态记录标识设定
	 * 
	 * @param currentPrstatus 是否查询流程当前状态记录标识
	 */
	public void setCurrentPrstatus(boolean currentPrstatus) {
		this.currentPrstatus = currentPrstatus;
	}

	public String getPrstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrstatus_ne() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPsdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpsdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getVirtualstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPsdnum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNowstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPend() {
		// TODO Auto-generated method stub
		return false;
	}

}
