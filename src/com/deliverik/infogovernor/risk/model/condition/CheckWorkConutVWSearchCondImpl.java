/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * ����: ��鹤��ͳ�Ʊ����������ʵ��
  * ��������: ��鹤��ͳ�Ʊ����������ʵ��
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public class CheckWorkConutVWSearchCondImpl implements
		CheckWorkConutVWSearchCond {
	/** ��鷽ʽ */
	protected String rcrtestmode;
	
	
	/**���ʱ��*/
	public String datetime;
	/**�����������*/
	public String halfyear;
	/**���������*/
	public String year;
	/**��������*/
	public String cg;
	
	/**
	 * cgȡ��
	 * @return cg cg
	 */
	public String getCg() {
		return cg;
	}

	/**
	 * cg�趨
	 * @param cg cg
	 */
	public void setCg(String cg) {
		this.cg = cg;
	}

	/**
	 * yearȡ��
	 * @return year year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * year�趨
	 * @param year year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**���Ȳ�ѯ*/
	public String quart;

	/**
	 * ���Ȳ�ѯȡ��
	 * @return quart ���Ȳ�ѯ
	 */
	public String getQuart() {
		return quart;
	}

	/**
	 * ���Ȳ�ѯ�趨
	 * @param quart ���Ȳ�ѯ
	 */
	public void setQuart(String quart) {
		this.quart = quart;
	}

	/**
	 * halfyearȡ��
	 * @return halfyear halfyear
	 */
	public String getHalfyear() {
		return halfyear;
	}

	/**
	 * halfyear�趨
	 * @param halfyear halfyear
	 */
	public void setHalfyear(String halfyear) {
		this.halfyear = halfyear;
	}

	/**
	 * ���ʱ��ȡ��
	 * @return datetime ���ʱ��
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * ���ʱ���趨
	 * @param datetime ���ʱ��
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * ��鷽ʽȡ��
	 * @return rcrtestmode ��鷽ʽ
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * ��鷽ʽ�趨
	 * @param rcrtestmode ��鷽ʽ
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
}