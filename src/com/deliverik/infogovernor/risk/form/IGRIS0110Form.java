/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;


/**
 * ��ư汾��ѯForm
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0110Form extends BaseForm implements RiskAuditIns {
	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** �������ID */
	protected Integer raid;

	/** ������ư汾 */
	protected String raversion;
	
	/** ������Ʒ����� */
	protected String raicode;
	
	/** ������Ʒ��𴴽����� */
	protected String raistart;
	
	/** ������Ʒ���������� */
	protected String raiend;
	
	/** ������Ʒ������� */
	protected String raidesc;
	
	/** ������Ʒ���״̬ */
	protected String raistatus;
	
	/** ������Ʒ����¼��ʱ��� */
	protected String fingerPrint;
	
	/** ģʽ 0�Ǽǣ�1�༭ */
	protected String mode = "0";
	
	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		if(raiid != null && raiid == 0) {
			raiid = null;
		}
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}

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
	 * ������Ʒ��𴴽�����ȡ��
	 * @return ������Ʒ��𴴽�����
	 */
	public String getRaistart() {
		return raistart;
	}

	/**
	 * ������Ʒ��𴴽������趨
	 * @param raistart ������Ʒ��𴴽�����
	 */
	public void setRaistart(String raistart) {
		this.raistart = raistart;
	}

	/**
	 * ������Ʒ����������ȡ��
	 * @return ������Ʒ����������
	 */
	public String getRaiend() {
		return raiend;
	}

	/**
	 * ������Ʒ�����������趨
	 * @param raiend ������Ʒ����������
	 */
	public void setRaiend(String raiend) {
		this.raiend = raiend;
	}

	/**
	 * ������Ʒ�������ȡ��
	 * @return ������Ʒ�������
	 */
	public String getRaidesc() {
		return raidesc;
	}

	/**
	 * ������Ʒ��������趨
	 * @param raidesc ������Ʒ�������
	 */
	public void setRaidesc(String raidesc) {
		this.raidesc = raidesc;
	}

	/**
	 * ������Ʒ���״̬ȡ��
	 * @return ������Ʒ���״̬
	 */
	public String getRaistatus() {
		return raistatus;
	}

	/**
	 * ������Ʒ���״̬�趨
	 * @param raistatus ������Ʒ���״̬
	 */
	public void setRaistatus(String raistatus) {
		this.raistatus = raistatus;
	}

	/**
	 * ������Ʒ�����ȡ��
	 * @return ������Ʒ�����
	 */
	public String getRaicode() {
		return raicode;
	}

	/**
	 * ������Ʒ������趨
	 * @param raicode ������Ʒ�����
	 */
	public void setRaicode(String raicode) {
		this.raicode = raicode;
	}
	
	/**
	 * ������Ʒ����¼��ʱ���ȡ��
	 * 
	 * @return ������Ʒ����¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ������Ʒ����¼��ʱ����趨
	 *
	 * @param fingerPrint ������Ʒ����¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ģʽȡ��
	 * 
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ģʽ�趨
	 *
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
