/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��top��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ServiceTopFiveSearchCondImpl implements ServiceTopFiveSearchCond{

	/** �¼����̶���ID */
	protected String ipdid;
	
	/** �����������̶���ID */
	protected String spdid;
	
	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;
	
	/** ͳ������ */
	protected String type;

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
	 * �����������̶���IDȡ��
	 * @return spdid �����������̶���ID
	 */
	public String getSpdid() {
		return spdid;
	}

	/**
	 * �����������̶���ID�趨
	 * @param spdid �����������̶���ID
	 */
	public void setSpdid(String spdid) {
		this.spdid = spdid;
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

	/**
	 * ͳ������ȡ��
	 * @return type ͳ������
	 */
	public String getType() {
		return type;
	}

	/**
	 * ͳ�������趨
	 * @param type ͳ������
	 */
	public void setType(String type) {
		this.type = type;
	}
}
