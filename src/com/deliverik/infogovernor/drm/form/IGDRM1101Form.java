/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.form;
import com.deliverik.framework.base.BaseForm;

/**
 * ǩ��Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM1101Form extends BaseForm  {
	/** ��������id */
	protected Integer drillprid;

	protected Integer prid;
	
	protected Integer siPrid;
	
	/**
	 * siPrid   ȡ��
	 * @return siPrid siPrid
	 */
	public Integer getSiPrid() {
		return siPrid;
	}

	/**
	 * siPrid   �趨
	 * @param siPrid siPrid
	 */
	public void setSiPrid(Integer siPrid) {
		this.siPrid = siPrid;
	}

	/** �û�id */
	protected String siuserid;

	/** �Ƿ���ǩ�� */
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
	 * prid   ȡ��
	 * @return prid prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * prid   �趨
	 * @param prid prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * isDrill   ȡ��
	 * @return isDrill isDrill
	 */
	public boolean getIsDrill() {
		return isDrill;
	}

	/**
	 * isDrill   �趨
	 * @param isDrill isDrill
	 */
	public void setIsDrill(boolean isDrill) {
		this.isDrill = isDrill;
	}
	
}
