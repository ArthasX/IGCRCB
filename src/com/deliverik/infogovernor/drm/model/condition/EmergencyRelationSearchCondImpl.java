/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * ���̹�ϵ��ѯ����ʵ��
 */
public class EmergencyRelationSearchCondImpl implements EmergencyRelationSearchCond {

	/** ��������ID */
	protected Integer parprid;

	/** ��������ID */
	protected Integer cldprid;
	
	protected String relatetype;
	/** ������ϵ */
	public String getRelatetype() {
		return relatetype;
	}

	public void setRelatetype(String relatetype) {
		this.relatetype = relatetype;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param parprid ��������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param cldprid ��������ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

}
