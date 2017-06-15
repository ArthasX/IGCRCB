/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskAudit;


/**
 * ��ư汾��ѯForm
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0102Form extends BaseForm implements RiskAudit {

	/** �������ID */
	protected Integer raid;

	/** ������ư汾 */
	protected String raversion;
	
	/** ������ƴ������� */
	protected String radate;
	
	/** ������ƴ�����ID */
	protected String rauserid;
	
	/** ������ƴ��������� */
	protected String rausername;

	/** ����������� */
	protected String radesc;
	
	/** �������״̬ */
	protected String rastatus;
	
	/** ������Ƽ�¼��ʱ��� */
	protected String fingerPrint;
	
	/** ������Ƹ���ʶ */
	protected String racode;
	
	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * �������ID�趨
	 * @param raid �������ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * ������ư汾ȡ��
	 * @return ������ư汾
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * ������ư汾�趨
	 * @param raversion ������ư汾
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}

	/**
	 * ������ƴ�������ȡ��
	 * @return ������ƴ�������
	 */
	public String getRadate() {
		return radate;
	}

	/**
	 * ������ƴ��������趨
	 * @param radate ������ƴ�������
	 */
	public void setRadate(String radate) {
		this.radate = radate;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String getRadesc() {
		return radesc;
	}

	/**
	 * ������������趨
	 * @param radesc �����������
	 */
	public void setRadesc(String radesc) {
		this.radesc = radesc;
	}

	/**
	 * �������״̬ȡ��
	 * @return �������״̬
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * �������״̬�趨
	 * @param rastatus �������״̬
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}

	/**
	 * ������Ƽ�¼��ʱ���ȡ��
	 * 
	 * @return ������Ƽ�¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ������Ƽ�¼��ʱ����趨
	 *
	 * @param fingerPrint ������Ƽ�¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ������ƴ�����IDȡ��
	 * @return ������ƴ�����ID
	 */
	public String getRauserid() {
		return rauserid;
	}

	/**
	 * ������ƴ�����ID�趨
	 * @param rauserid ������ƴ�����ID
	 */
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}

	/**
	 * ������ƴ���������ȡ��
	 * @return ������ƴ���������
	 */
	public String getRausername() {
		return rausername;
	}

	/**
	 * ������ƴ����������趨
	 * @param rausername ������ƴ���������
	 */
	public void setRausername(String rausername) {
		this.rausername = rausername;
	}
	
	/**
	 * ������Ƹ���ʶȡ��
	 * @return ������Ƹ���ʶ
	 */
	public String getRacode() {
		return racode;
	}

	/**
	 * ������Ƹ���ʶ�趨
	 * @param racode ������Ƹ���ʶ
	 */
	public void setRacode(String racode) {
		this.racode = racode;
	}
	
}
