/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;
import com.csebank.lom.model.condition.EESearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż�����ϸ����Form
 * ���ߣ�������
 */
public class IGLOM0521Form extends BaseForm implements EESearchCond {
	
	
	private static final long serialVersionUID = 1L;

	
	/** ��Ҫ���벿�� */
	protected String rapporgid_org;
	
	/** ��ʼ�·� */
	protected String month_from_org;
	
	/** �����·� */
	protected String month_to_org;
	
	/** ��� */
	protected String year_org;
	
	protected String rapporgname;
	

	/**
	 * ���ŽӴ�ͳ�����벿�Ų����ȡ��
	 * @return ���ŽӴ�ͳ�����벿�Ų����
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * ���ŽӴ�ͳ�����벿�Ų�����趨
	 * @param rapporgid_org ���ŽӴ�ͳ�����벿�Ų����
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	/**
	 * ���ŽӴ�ͳ�����ȡ��
	 * @return ���ŽӴ�ͳ�����
	 */
	public String getYear_org() {
		return year_org;
	}

	/**
	 * ���ŽӴ�ͳ������趨
	 * @param year_org ���ŽӴ�ͳ�����
	 */
	public void setYear_org(String year_org) {
		this.year_org = year_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·�ȡ��
	 * @return ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	public String getMonth_from_org() {
		return month_from_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƿ�ʼ�·��趨
	 * @param month_from_org ���ŽӴ�ͳ�ƿ�ʼ�·�
	 */
	public void setMonth_from_org(String month_from_org) {
		this.month_from_org = month_from_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƽ����·�ȡ��
	 * @return ���ŽӴ�ͳ�ƽ����·�
	 */
	public String getMonth_to_org() {
		return month_to_org;
	}

	/**
	 * ���ŽӴ�ͳ�ƽ����·��趨
	 * @param month_to_org ���ŽӴ�ͳ�ƽ����·�
	 */
	public void setMonth_to_org(String month_to_org) {
		this.month_to_org = month_to_org;
	}

	public String getMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRstatus_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRtime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getYear() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	



	

}
