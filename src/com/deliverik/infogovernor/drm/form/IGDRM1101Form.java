/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;
import com.deliverik.framework.base.BaseForm;

/**
 * 签到Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM1101Form extends BaseForm  {
	/** 演练流程id */
	protected Integer drillprid;

	protected Integer prid;
	
	protected Integer siPrid;
	
	/**
	 * siPrid   取得
	 * @return siPrid siPrid
	 */
	public Integer getSiPrid() {
		return siPrid;
	}

	/**
	 * siPrid   设定
	 * @param siPrid siPrid
	 */
	public void setSiPrid(Integer siPrid) {
		this.siPrid = siPrid;
	}

	/** 用户id */
	protected String siuserid;

	/** 是否已签到 */
	protected String signined;
	
	protected boolean isDrill;
	
	public Integer getDrillprid() {
		return drillprid;
	}

	public void setDrillprid(Integer drillprid) {
		this.drillprid = drillprid;
	}

	public String getSiuserid() {
		return siuserid;
	}

	public void setSiuserid(String siuserid) {
		this.siuserid = siuserid;
	}

	public String getSignined() {
		return signined;
	}

	public void setSignined(String signined) {
		this.signined = signined;
	}

	/**
	 * prid   取得
	 * @return prid prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * prid   设定
	 * @param prid prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * isDrill   取得
	 * @return isDrill isDrill
	 */
	public boolean getIsDrill() {
		return isDrill;
	}

	/**
	 * isDrill   设定
	 * @param isDrill isDrill
	 */
	public void setIsDrill(boolean isDrill) {
		this.isDrill = isDrill;
	}
	
}
