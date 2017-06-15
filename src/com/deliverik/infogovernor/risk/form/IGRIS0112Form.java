/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;


/**
 * �����Form
 *
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0112Form extends BaseForm implements RiskAuditDefResultVWSearchCond {
	
	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** ���������״̬ */
	protected String radstatus;
	
	/** ���������ID */
	protected String[] radid;
	
	/** �����������ID */
	protected String[] rarid;
	
	/** �������������ID */
	protected String[] raruserid;
	
	/** ����������������� */
	protected String[] rarusername;
	
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
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radstatus ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public String[] getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(String[] radid) {
		this.radid = radid;
	}

	/**
	 * �����������IDȡ��
	 * @return �����������ID
	 */
	public String[] getRarid() {
		return rarid;
	}

	/**
	 * �����������ID�趨
	 * @param rarid �����������ID
	 */
	public void setRarid(String[] rarid) {
		this.rarid = rarid;
	}

	/**
	 * �������������IDȡ��
	 * @return �������������ID
	 */
	public String[] getRaruserid() {
		return raruserid;
	}

	/**
	 * �������������ID�趨
	 * @param raruserid �������������ID
	 */
	public void setRaruserid(String[] raruserid) {
		this.raruserid = raruserid;
	}

	/**
	 * �����������������ȡ��
	 * @return �����������������
	 */
	public String[] getRarusername() {
		return rarusername;
	}

	/**
	 * ������������������趨
	 * @param rarusername �����������������
	 */
	public void setRarusername(String[] rarusername) {
		this.rarusername = rarusername;
	}
	
}
