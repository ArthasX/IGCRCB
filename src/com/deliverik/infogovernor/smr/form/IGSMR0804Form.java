/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.smr.form;


import com.deliverik.framework.base.BaseForm;

/**
 * ����:��������ϵͳ�������ҳ form
 * ������������������ϵͳ�������ҳform
 * �����ˣ�
 * ������¼�� 2013/09/17
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0804Form extends BaseForm{

	/** ��ǰҳ�� */
	protected int pagesize;
	
	/** ��ѯ������Ϣ���� */
	protected int countall;
	
	/** ��ѯ�� */
	protected String year;
	
	/** ��ѯ���� */
	protected String quarter;
	
	/** ��ʼ��ѯ��ʶ */
	protected String select_flag;
	
	/**
	 * ��ѯ���ʶ
	 */
	protected String year_flag;
	
	/**
	 * ��ǰҳ��ȡ��
	 *
	 * @return pagesize ��ǰҳ��
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * ��ǰҳ���趨
	 *
	 * @param pagesize ��ǰҳ��
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * ��ѯ������Ϣ����ȡ��
	 *
	 * @return countall ��ѯ������Ϣ����
	 */
	public int getCountall() {
		return countall;
	}

	/**
	 * ��ѯ������Ϣ�����趨
	 *
	 * @param countall ��ѯ������Ϣ����
	 */
	public void setCountall(int countall) {
		this.countall = countall;
	}

	/**
	 * ��ѯ��ȡ��
	 * @return year ��ѯ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ��ѯ���趨
	 * @param year ��ѯ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ѯ����ȡ��
	 * @return quarter ��ѯ����
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * ��ѯ�����趨
	 * @param quarter ��ѯ����
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * ��ѯ���ʶȡ��
	 * @return year_flag ��ѯ���ʶ
	 */
	public String getYear_flag() {
		return year_flag;
	}

	/**
	 * ��ѯ���ʶ�趨
	 * @param year_flag ��ѯ���ʶ
	 */
	public void setYear_flag(String year_flag) {
		this.year_flag = year_flag;
	}

	/**
	 * ��ʼ��ѯ��ʶȡ��
	 * @return select_flag ��ʼ��ѯ��ʶ
	 */
	public String getSelect_flag() {
		return select_flag;
	}

	/**
	 * ��ʼ��ѯ��ʶ�趨
	 * @param select_flag ��ʼ��ѯ��ʶ
	 */
	public void setSelect_flag(String select_flag) {
		this.select_flag = select_flag;
	}


}
