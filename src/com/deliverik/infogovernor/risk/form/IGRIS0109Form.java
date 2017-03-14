/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;


/**
 * ��Ʒ����ѯForm
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0109Form extends BaseForm implements RiskAuditInsSearchCond {
	
	/** �������ID */
	protected Integer raid;
	
	/** ������Ʒ���ID */
	protected Integer raiid;

	/** ������Ʒ����� */
	protected String raicode;
	
	/** ������Ʒ��𴴽����� */
	protected String raistart;
	
	/** ������Ʒ���������� */
	protected String raiend;
	
	/** ������Ʒ���״̬ */
	protected String raistatus;
	
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
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
}
