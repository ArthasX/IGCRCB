/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;

/**
 * ����: ����ʼ�����ò�ѯForm
 * ��������: ����ʼ�����ò�ѯForm
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGPRD0166Form extends BaseForm implements IG373Info{
	
	/** ���� */
	protected String piidid;

	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** BL���� */
	protected String piidblid;

	/** ���� */
	protected String piiddec;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiidid() {
		return piidid;
	}

	/**
	 * �����趨
	 *
	 * @param piidid ����
	 */
	public void setPiidid(String piidid) {
		this.piidid = piidid;
	}

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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
	 * BL����ȡ��
	 *
	 * @return BL����
	 */
	public String getPiidblid() {
		return piidblid;
	}

	/**
	 * BL�����趨
	 *
	 * @param piidblid BL����
	 */
	public void setPiidblid(String piidblid) {
		this.piidblid = piidblid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiiddec() {
		return piiddec;
	}

	/**
	 * �����趨
	 *
	 * @param piiddec ����
	 */
	public void setPiiddec(String piiddec) {
		this.piiddec = piiddec;
	}

	/**
	 * ��¼ʱ���ȡ��
	 *
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ����趨
	 *
	 * @param fingerPrint ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public IG333Info getIg333Info() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
}
