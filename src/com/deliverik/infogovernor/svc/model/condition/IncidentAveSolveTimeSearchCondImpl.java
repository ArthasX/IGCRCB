/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ�����ʱ��ͳ�Ʋ�ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentAveSolveTimeSearchCondImpl implements IncidentAveSolveTimeSearchCond{

	/** �¼����̶���ID */
	protected String ipdid;
	
	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;

	/**
	 * �¼����̶���IDȡ��
	 * @return ipdid �¼����̶���ID
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * �¼����̶���ID�趨
	 * @param ipdid �¼����̶���ID
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}

	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}
}
