/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;

 
/**
 * @Description: ����״̬��־�鿴Form
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0110Form extends BaseForm implements IG224SearchCond {

	/** ����ID */
	protected Integer prid;
	
	/** �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ */
	protected boolean currentPrstatus;

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public boolean isCurrentPrstatus() {
		return currentPrstatus;
	}

	/**
	 * �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ�趨
	 * 
	 * @param currentPrstatus �Ƿ��ѯ���̵�ǰ״̬��¼��ʶ
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
