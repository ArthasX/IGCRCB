/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ���̲���֪ͨ��ʵ������
  * ��������: ���̲���֪ͨ��ʵ������
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG237PK extends BasePK implements Serializable {

	/** ״̬ID */
	protected String psdid;

	/** �Ƿ�ȷ�� */
	protected String psdconfirm;

	/** �û�ID */
	protected String userid;
	
	/** ��ֵ */
	protected String pivalue;

	/**
	 * ���캯��
	 */
	public IG237PK() {

	}

	/**
	 * ���캯��
	 */
	public IG237PK(String psdid, String psdconfirm, String userid, String pivalue) {
		super();
		this.psdid = psdid;
		this.psdconfirm = psdconfirm;
		this.userid = userid;
		this.pivalue = pivalue;
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

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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