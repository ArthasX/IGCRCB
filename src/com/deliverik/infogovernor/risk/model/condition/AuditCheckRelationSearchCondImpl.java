package com.deliverik.infogovernor.risk.model.condition;



/**
 * ���ռ�������������ϵ��Ϣ��ѯ����ʵ��
 * 
 */
public class AuditCheckRelationSearchCondImpl implements AuditCheckRelationSearchCond {

	/** ���ռ���������ƹ�ϵID */
	protected Integer acrid;
	
	/** ���ռ��ID */
	protected Integer rcid;
	
	/** ���������ID */
	protected Integer radid;

	/** ������������ */
	protected String radcode;
	

	/**
	 * @return the acrid
	 */
	public Integer getAcrid() {
		return acrid;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the radid
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * @return the radcode
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * @param acrid the acrid to set
	 */
	public void setAcrid(Integer acrid) {
		this.acrid = acrid;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param radid the radid to set
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * @param radcode the radcode to set
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
	
	
	
}
