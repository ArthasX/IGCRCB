/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.condition;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼ��ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */

public class PbsummaryVWSearchCondImpl implements PbsummaryVWSearchCond{	
	/** ��ĿID*/
	protected Integer pid;
	
	/** Ԥ����Ŀ��ϵ��ID*/
	protected Integer pbid;
	
	/** Ԥ���ID*/
	protected Integer bid;
	
	/** ��ʼԤ�����*/
	protected String byear_begin;
	
	/** ����Ԥ�����*/
	protected String byear_end;
	
	/**
	 * ��ȡ��ĿID
	 * @return ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ������ĿID
	 * @param pid  ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	/**
	 * ��ȡԤ����Ŀ��ϵ��ID
	 * @return Ԥ����Ŀ��ϵ��ID
	 */
	public Integer getPbid() {
		return pbid;
	}

	/**
	 * ����Ԥ����Ŀ��ϵ��ID
	 * @param pbid  Ԥ����Ŀ��ϵ��ID
	 */
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	
	/**
	 * ��ȡԤ���ID
	 * @return Ԥ���ID
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * ����Ԥ���ID
	 * @param bid  Ԥ���ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	
	/**
	 * ��ȡ��ʼԤ�����
	 * @return ��ʼԤ�����
	 */
	public String getByear_begin() {
		return byear_begin;
	}

	/**
	 * ���ÿ�ʼԤ�����
	 * @param setByear_begin ��ʼԤ�����
	 */
	public void setByear_begin(String byear_begin) {
		this.byear_begin = byear_begin;
	}

	/**
	 * ��ȡ����Ԥ�����
	 * @return ����Ԥ�����
	 */
	public String getByear_end() {
		return byear_end;
	}

	/**
	 * ���ý���Ԥ�����
	 * @param setByear_end ����Ԥ�����
	 */
	public void setByear_end(String byear_end) {
		this.byear_end = byear_end;
	}
}
