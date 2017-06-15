/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;


/**
 * ��������鿴�������ϢForm
 *
 * @author maozhipeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0115Form extends BaseForm implements AuditCheckRelation {
	
	
	/** ���ռ�������������ϵID */
	protected Integer acrid;
	
	/** ���ռ��ID */
	protected Integer rcid;
	
	/** ���������ID */
	protected Integer radid;

	/** ������������� */
	protected String radcode;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return acrid;
	}

	/**
	 * ���ռ���������ƹ�ϵIDȡ��
	 * @return ���ռ���������ƹ�ϵID
	 */
	public Integer getAcrid() {
		return acrid;
	}

	/**
	 * ���ռ���������ƹ�ϵID�趨
	 * @param acrid ���ռ���������ƹ�ϵID
	 */
	public void setAcrid(Integer acrid) {
		this.acrid = acrid;
	}

	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * ���ռ��ID�趨
	 * @param rcid ���ռ��ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}


	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * ��������������趨
	 * @param radcode �������������
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

}
