/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ����֪ͨ����ʵ������
  * ��������: ����֪ͨ����ʵ������
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG212PK extends BasePK implements Serializable {

	/** ״̬ID */
	protected String psdid;
	
	/** �Ƿ�ȷ�� */
	protected String psdconfirm;

	/**
	 * ���캯��
	 */
	public IG212PK() {

	}

	/**
	 * ���캯��
	 */
	public IG212PK(String psdid, String psdconfirm) {
		super();
		this.psdid = psdid;
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	
}