/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �����Ա�ʵ������
  * ��������: �����Ա�ʵ������
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG334VWPK extends BasePK implements Serializable {

	/** ״̬����ID */
	protected String psdid;

	/** ������ID */
	protected String pidid;

	/** ��ֵ */
	protected String pivalue;

	/**
	 * ���캯��
	 */
	public IG334VWPK() {

	}

	/**
	 * ���캯��
	 */
	public IG334VWPK(String psdid, String pidid, String pivalue) {
		super();
		this.psdid = psdid;
		this.pidid = pidid;
		this.pivalue = pivalue;
	}

	/**
	 * ״̬����IDȡ��
	 *
	 * @return ״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬����ID�趨
	 *
	 * @param psdid ״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��ֵȡ��
	 * @return pivalue ��ֵ
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivalue ��ֵ
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
	}
 
}