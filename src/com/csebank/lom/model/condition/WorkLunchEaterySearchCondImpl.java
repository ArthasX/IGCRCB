/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �����ͳɱ�ͳ��ʵ��
 *
 */
public class WorkLunchEaterySearchCondImpl implements WorkLunchEaterySearchCond {
	
	/**
	 * ��ѯ����
	 */
	protected String searchtype;
	
	/**
	 * ͳ�ƿ�ʼʱ���ѯ
	 */
	protected String etime_from;
	
	/**
	 * ͳ�ƽ���ʱ���ѯ
	 */
	protected String etime_to;
	
	/**
	 * ����
	 */
	protected String edate;
	
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

}
