/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ���̼�ʱ���������ʵ��
  * ��������: ���̼�ʱ���������ʵ��
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public class ProcessTimeSearchCondImpl implements
		ProcessTimeSearchCond {
	
	protected String year;
	
	protected Integer prid;
	
	//��ѯ�û�id
	protected String userId;
	
	//��ѯ��ʱ��ʼʱ��
	protected String prtstartTime_le;
	
	//��ѯ��ʱ����ʱ��
	protected String prtEndTime_ge;

	/**
	 * �û�id��ȡ
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * �û�id�趨
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ��ʱ��ʼʱ���ȡ
	 */
	public String getPrtstartTime_le() {
		return prtstartTime_le;
	}

	/**
	 * ��ʱ��ʼʱ���趨
	 * @param prtstartTime_like
	 */
	public void setPrtstartTime_le(String prtstartTime_le) {
		this.prtstartTime_le = prtstartTime_le;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ʱ����ʱ���ȡ
	 */
	public String getPrtEndTime_ge() {
		return prtEndTime_ge;
	}

	/**
	 * ��ʱ����ʱ���趨
	 */
	public void setPrtEndTime_ge(String prtEndTime_ge) {
		this.prtEndTime_ge = prtEndTime_ge;
	}

}