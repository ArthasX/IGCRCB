/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.EentertainmentStatisticsSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ʳ�ýӴ�����ͳ��FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0508Form extends BaseForm implements EentertainmentStatisticsSearchCond {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ѯ����
	 */
	public String ewhere;
	
	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public String etime_to;
	
	/** ͳ�ƿ�ʼ�� */
	protected String yearFrom;

	/** ͳ�ƿ�ʼ�� */
	protected String monthFrom;
	
	/** ͳ�ƽ����� */
	protected String yearTo;

	/** ͳ�ƽ����� */
	protected String monthTo;
	
	/**
	 * ͳ�ƿ�ʼ��ȡ��
	 * @return ͳ�ƿ�ʼ��
	 */
	public String getYearFrom() {
		return yearFrom;
	}
	
	/**
	 * ͳ�ƿ�ʼ���趨
	 * @param yearFrom ͳ�ƿ�ʼ��
	 */
	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}
	
	/**
	 * ͳ�ƿ�ʼ��ȡ��
	 * @return ͳ�ƿ�ʼ��
	 */
	public String getMonthFrom() {
		return monthFrom;
	}
	
	/**
	 * ͳ�ƿ�ʼ���趨
	 * @param monthFrom ͳ�ƿ�ʼ��
	 */
	public void setMonthFrom(String monthFrom) {
		this.monthFrom = monthFrom;
	}
	
	/**
	 * ͳ�ƽ�����ȡ��
	 * @return ͳ�ƽ�����
	 */
	public String getYearTo() {
		return yearTo;
	}
	
	/**
	 * ͳ�ƽ������趨
	 * @param yearTo ͳ�ƽ�����
	 */
	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}
	
	/**
	 * ͳ�ƽ�����ȡ��
	 * @return ͳ�ƽ�����
	 */
	public String getMonthTo() {
		return monthTo;
	}
	
	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ�趨
	 * @param etime_from ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setMonthTo(String monthTo) {
		this.monthTo = monthTo;
	}

	/**
	 * ʳ�óɱ���Ϣʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ�趨
	 * @param etime_from ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯȡ��
	 * @return ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ�趨
	 * @param etime_to ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ��ѯ����
	 * @return ��ѯ����
	 */
	public String getEwhere() {
		return ewhere;
	}
	
	/**
	 * ��ѯ����
	 * @param ewhere ��ѯ����
	 */
	public void setEwhere(String ewhere) {
		this.ewhere = ewhere;
	}
}
