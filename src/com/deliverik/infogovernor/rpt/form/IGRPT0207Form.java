/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���渽��Form
 * ��������: 
 * ������¼:����ȫ 2012/06/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0207Form extends BaseForm{
	
	/** ����IDS */
	protected String[] anIds;
	
	/**����ID*/
	protected Integer rmId;
	/**ȷ��ɾ����*/
	protected String isDel;
	/**
	 * ����IDSȡ��
	 *
	 * @return anIds ����IDS
	 */
	public String[] getAnIds() {
		return anIds;
	}

	/**
	 * ����IDS�趨
	 *
	 * @param anIds ����IDS
	 */
	public void setAnIds(String[] anIds) {
		this.anIds = anIds;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return rmId ����ID
	 */
	public Integer getRmId() {
		return rmId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param rmId ����ID
	 */
	public void setRmId(Integer rmId) {
		this.rmId = rmId;
	}

	/**
	 * ȷ��ɾ����ȡ��
	 *
	 * @return isDel ȷ��ɾ����
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * ȷ��ɾ�����趨
	 *
	 * @param isDel ȷ��ɾ����
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	
	
}
