/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ����ָ���ѯ��������ʵ��
  * ��������: ����ָ���ѯ��������ʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class RiskIndexSearchVWSearchCondImpl implements
		RiskIndexSearchVWSearchCond {
	
	/**ָ������*/
	protected String einame;
	
	/**ָ����*/
	protected String eilabel;
	
	/**ָ�����*/
	protected String syscoding;
	
	/**ָ����;*/
	protected String indexused;
	
	/**��ֵ*/
	protected String zbfz;
	
	/**ָ��������*/
	protected String dutyuser;
	
	/**ָ�����β���*/
	protected String dutydepartment;
	
	/**�Ƿ�ؼ�ָ��*/
	protected String keyindex;
	
	/**ָ�������*/
	protected String mguserid;
	
	/**�Ǽ����� ��ʱ��*/
	protected String eiStartDate;
	
	/**�Ǽ����� ��ʱ��*/
	protected String eiEndDate;
	
	/**����ʱ�� ��ʱ��*/
	protected String euStartDate;
	
	/**����ʱ�� ��ʱ��*/
	protected String euEndDate;
	
	/**ָ������EIID*/
	protected String eiid;
	
	/** eiid�ų�����*/
	protected String eiid_NotIn;
	
	/** eiid����*/
	protected String eiid_In;

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getSyscoding() {
		return syscoding;
	}

	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	public String getIndexused() {
		return indexused;
	}

	public void setIndexused(String indexused) {
		this.indexused = indexused;
	}

	public String getZbfz() {
		return zbfz;
	}

	public void setZbfz(String zbfz) {
		this.zbfz = zbfz;
	}

	public String getDutyuser() {
		return dutyuser;
	}

	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	public String getDutydepartment() {
		return dutydepartment;
	}

	public void setDutydepartment(String dutydepartment) {
		this.dutydepartment = dutydepartment;
	}

	public String getKeyindex() {
		return keyindex;
	}

	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	public String getMguserid() {
		return mguserid;
	}

	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	public String getEiStartDate() {
		return eiStartDate;
	}

	public void setEiStartDate(String eiStartDate) {
		this.eiStartDate = eiStartDate;
	}

	public String getEiEndDate() {
		return eiEndDate;
	}

	public void setEiEndDate(String eiEndDate) {
		this.eiEndDate = eiEndDate;
	}

	public String getEuStartDate() {
		return euStartDate;
	}

	public void setEuStartDate(String euStartDate) {
		this.euStartDate = euStartDate;
	}

	public String getEuEndDate() {
		return euEndDate;
	}

	public void setEuEndDate(String euEndDate) {
		this.euEndDate = euEndDate;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	/**
	 *  eiid�ų����ϻ�ȡ
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn() {
		return eiid_NotIn;
	}

	/**
	 *  eiid�ų������趨
	 * @param eiid_NotIn the eiid_NotIn to set
	 */
	public void setEiid_NotIn(String eiid_NotIn) {
		this.eiid_NotIn = eiid_NotIn;
	}

	/**
	 * eiid���ϻ�ȡ
	 * @return eiid_In
	 */
	public String getEiid_In() {
		return eiid_In;
	}

	/**
	 * eiid�����趨
	 * @param eiid_In
	 */
	public void setEiid_In(String eiid_In) {
		this.eiid_In = eiid_In;
	}
}