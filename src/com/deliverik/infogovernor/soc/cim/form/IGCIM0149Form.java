/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���ð�����ϵ��ʾFORM
 * ��������: ���ð�����ϵ��ʾFORM
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0149Form extends BaseForm {

	/** ���������ʲ�ID */
	protected String eirootmark;
	
	/** �豸ID */
	protected String eiid;
	
	/** �豸���ô�汾 */
	protected String eiversion;
	
	/** �豸����С�汾 */
	protected String eismallversion;
	
	protected String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ���������ʲ�IDȡ��
	 * 
	 * @return ���������ʲ�ID
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * ���������ʲ�ID�趨
	 * 
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �豸���ô�汾ȡ��
	 * 
	 * @return �豸���ô�汾
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * �豸���ô�汾�趨
	 *
	 * @param eiversion �豸���ô�汾
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �豸����С�汾ȡ��
	 * @return �豸����С�汾
	 */
	public String getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �豸����С�汾�趨
	 *
	 * @param eismallversion �豸����С�汾
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}
}
