/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: �����¼���������ʵ��
  * ��������: �����¼���������ʵ��
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public class RiskcaseVWSearchCondImpl implements
		RiskcaseVWSearchCond {
	/** �ʲ�ID */
	protected Integer eiid;
	
	/** �ʲ��汾 */
	protected String version;
	
	/** �����¼����� */
	protected String fcname;
	
	/** �����¼���Դ */
	protected String fcorigin;
	
	/** �����¼��������� */
	protected String fccategory;
	
	/** ����ʶ��ʱ��� */
	protected String riskcatchtime_from;
	
	/** ����ʶ��ʱ�䵽 */
	protected String riskcatchtime_to;
	
	/** ���յ�ID */
	protected String riskid;
	
	/** Ӧ�Բ��� */
	protected String fcpolicy;
	
	/** ������ */
	protected String riskreviewresult;
	
	/** �����¼�״̬ */
	protected String EISTATUS;

	public String getFcorigin() {
		return fcorigin;
	}

	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	public String getFccategory() {
		return fccategory;
	}

	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	public String getRiskcatchtime_from() {
		return riskcatchtime_from;
	}

	public void setRiskcatchtime_from(String riskcatchtime_from) {
		this.riskcatchtime_from = riskcatchtime_from;
	}

	public String getRiskcatchtime_to() {
		return riskcatchtime_to;
	}

	public void setRiskcatchtime_to(String riskcatchtime_to) {
		this.riskcatchtime_to = riskcatchtime_to;
	}

	public String getRiskid() {
		return riskid;
	}

	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	public String getFcpolicy() {
		return fcpolicy;
	}

	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getFcname() {
		return fcname;
	}

	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * �����¼�״̬ȡ��
	 *
	 * @return �����¼�״̬
	 */
	public String getEISTATUS() {
		return EISTATUS;
	}

	/**
	 * �����¼�״̬�趨
	 *
	 * @param EISTATUS �����¼�״̬
	 */
	public void setEISTATUS(String EISTATUS) {
		this.EISTATUS = EISTATUS;
	}
}