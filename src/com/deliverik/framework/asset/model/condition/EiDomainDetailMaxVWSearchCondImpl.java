/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.condition;

/**
 * ����: �ʲ�����ϸ���������ʵ��
 * ��������: �ʲ�����ϸ���������ʵ��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public class EiDomainDetailMaxVWSearchCondImpl implements
		EiDomainDetailMaxVWSearchCond {
	
	/** ��ID */
	protected String eiddid;
	
	/** ��ѯ���� */
	protected String typeId;
	
	/** Ӱ��CI */
	protected String eilabel;
	
	/** �ʲ���汾 **/
	private String  eiddversion;
	
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

	/**
	 * Ӱ��CIȡ��
	 */
	public String getEilabel() {
		return eilabel;
	}
	
	/**
	 * Ӱ��CI�趨
	 * @param eilabelӰ��CI
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}
	/**
	 * �ʲ���汾ȡ��
	 */

	public String getEiddversion() {
		return eiddversion;
	}

	/**
	 * �ʲ���汾�趨
	 * @param eiddversion�ʲ���汾
	 */
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
