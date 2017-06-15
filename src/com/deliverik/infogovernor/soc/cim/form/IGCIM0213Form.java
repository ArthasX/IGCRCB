/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;

/**
 * ����: ��CI��ѯ����FORM
 * ��������: ��CI��ѯ����FORM
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class IGCIM0213Form extends BaseForm implements SOC0126SearchCond{
	private static final long serialVersionUID = 1L;
	
	/** ��ID */
	protected String eiddid;
	
	/** ��ѯ���� */
	protected String typeId;
	
	protected String eilabel;
	
	/** �汾 */
	protected String eiddversion;
	
	protected String einame;
	
	protected String eiid;
	
	
	/**
	 * ��IDȡ��
	 * @return ��ID
	 */
	public String getEiddid() {
		return eiddid;
	}

	/**
	 * ��ID�趨
	 * @param eiddid��ID
	 */
	public void setEiddid(String eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * ��ѯ����ȡ��
	 * @return ��ѯ����
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * ��ѯ�����趨
	 * @param typeId��ѯ����
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getEilabel() {
		return eilabel;
	}
	
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getEiddversion() {
		return eiddversion;
	}

	public void setEiddversion(String eiddversion) {
		this.eiddversion = eiddversion;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}



	
}
