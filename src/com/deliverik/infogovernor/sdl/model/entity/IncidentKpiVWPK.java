package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * �������_ͳ�ƻ���_�¼�kpi��Ϣ��������
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IncidentKpiVWPK extends BasePK implements Serializable{

	/**�����̶�*/
	protected String urgency;
	
	/**�������*/
	protected String syscoding;

	/**
	 * ���캯��
	 * 
	 */
	public IncidentKpiVWPK(){}
	
	/**
	 * ���캯��
	 * 
	 */
	public IncidentKpiVWPK(String urgency, String syscoding) {
		super();
		this.urgency = urgency;
		this.syscoding = syscoding;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

}
