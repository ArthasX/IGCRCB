/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.form;
import com.deliverik.framework.base.BaseForm;

/**
 * ��ǩ��Form
 * 
 */
@SuppressWarnings("serial")
public class IGDRM1102Form extends BaseForm{
	/** ��������id */
	protected Integer drillprid;
	
	protected Integer prid;
	private String prname;

	protected boolean isDrill;
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

	/** �û�id */
	protected String siuserid;
	/** �Ƿ���ǩ�� */
	protected String signined;
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

	/**
	 * prname   ȡ��
	 * @return prname prname
	 */
	public String getPrname() {
		return prname;
	}

	/**
	 * prname   �趨
	 * @param prname prname
	 */
	public void setPrname(String prname) {
		this.prname = prname;
	}
	
}
