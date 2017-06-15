/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ʳ�ù���������ͳ��FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0505Form extends BaseForm implements WorkLunchEaterySearchCond {
	private static final long serialVersionUID = 1L;

	/** ��ѯ���� */
	protected String searchtype;
	
	/** �� */
	protected String year;

	/** �� */
	protected String month;
	
	/** �� */
	protected String yearD;

	/** �� */
	protected String monthD;
	
	/** �� */
	protected String quarter;
	
	/** ��ϸ��ѯ���� */
	protected String detail;	
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 */
	public String etime_to;
	
	/**
	 * ����
	 */
	public String edate;
	
	/**
	 * ��ѯ����
	 * @return ��ѯ����
	 */
	public String getSearchtype() {
		return searchtype;
	}
	
	/**
	 * ��ѯ����
	 * @param searchtype ��ѯ����
	 */
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	/**
	 * ��
	 * @return ��
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * ��
	 * @param year ��
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * ��
	 * @return ��
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * ��
	 * @param year ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * ��
	 * @return ��
	 */
	public String getQuarter() {
		return quarter;
	}
	
	/**
	 * ��
	 * @param quarter ��
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @return ͳ�ƿ�ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 * @param etime_from ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @return ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 * @param etime_to ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * ����
	 * @param edate ����
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getYearD() {
		return yearD;
	}

	public void setYearD(String yearD) {
		this.yearD = yearD;
	}

	public String getMonthD() {
		return monthD;
	}

	public void setMonthD(String monthD) {
		this.monthD = monthD;
	}
}
