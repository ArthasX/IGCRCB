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
public class IG335PK extends BasePK implements Serializable {

	/** ״̬����ID */
	protected String psdid;

	/** ������ID */
	protected String pidid;

	/** ��ֵ */
	protected String pivalue;
	
	/** ȷ�Ͻڵ��Ƿ����ʼ� */
	protected String psdconfirm;

	/**���̶���ID*/
	protected String pdid;

	/**
	 * ���캯��
	 */
	public IG335PK() {

	}

	/**
	 * ���캯��
	 */
	public IG335PK(String psdid, String pdid, String pidid, String pivalue, String psdconfirm) {
		super();
		this.psdid = psdid;
		this.pdid = pdid;
		this.pidid = pidid;
		this.pivalue = pivalue;
		this.psdconfirm = psdconfirm;
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

	/**
	 * ȷ�Ͻڵ��Ƿ����ʼ�ȡ��
	 * @return psdconfirm ȷ�Ͻڵ��Ƿ����ʼ�
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * ȷ�Ͻڵ��Ƿ����ʼ��趨
	 * @param psdconfirm ȷ�Ͻڵ��Ƿ����ʼ�
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
 
	/**
	 * ���̶���IDȡ��
	 * @return pdid
	 */
	public String getPdid() {
		return pdid;
	}
	/**
	 * ���̶���ID�趨
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

}