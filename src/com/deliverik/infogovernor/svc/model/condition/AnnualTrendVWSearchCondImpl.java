/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ�Ʋ�ѯ����ʵ��;
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class AnnualTrendVWSearchCondImpl implements AnnualTrendVWSearchCond{
	
	/** ��� */
	protected String year;
	
	/** ����id */
	protected String orgid;

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
	 * ����idȡ��
	 * @return orgid ����id
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ����id�趨
	 * @param orgid ����id
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
}
