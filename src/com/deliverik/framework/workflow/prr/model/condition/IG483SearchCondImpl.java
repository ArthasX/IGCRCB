/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;


/**
  * ����: ������ʵ�����������ʵ��
  * ��������: ������ʵ�����������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG483SearchCondImpl implements
		IG483SearchCond {

	/** �����鷢�������� */
	protected String pgrusername_like;

	/** �����鷢��ʱ�俪ʼ */
	protected String pgropentime_begin;
	
	/** �����鷢��ʱ����� */
	protected String pgropentime_end;

	/** ���������к� */
	protected String pgrserialnum_like;

	/** ��������� */
	protected String pgrtitle_like;

	/** ����ģ������ */
	protected String pttype;
	
	/**�����ʶ*/
	protected String order;
	
	/** �����ֶ� */
	protected String sing;
	
	/** �Ƿ�������� */
	protected String istest;

	/** �����鶨��id */
	protected String pgdid;
	
	/** �������Ƿ�ر� */
	protected boolean isActive;

	/**
	 * �����鷢��������ȡ��
	 *
	 * @return �����鷢��������
	 */
	public String getPgrusername_like() {
		return pgrusername_like;
	}

	/**
	 * �����鷢���������趨
	 *
	 * @param pgrusername_like �����鷢��������
	 */
	public void setPgrusername_like(String pgrusername_like) {
		this.pgrusername_like = pgrusername_like;
	}

	/**
	 * �����鷢��ʱ�俪ʼȡ��
	 * @return �����鷢��ʱ�俪ʼ
	 */
	public String getPgropentime_begin() {
		return pgropentime_begin;
	}

	/**
	 * �����鷢��ʱ�俪ʼ�趨
	 * @param pgropentime_begin �����鷢��ʱ�俪ʼ
	 */
	public void setPgropentime_begin(String pgropentime_begin) {
		this.pgropentime_begin = pgropentime_begin;
	}

	/**
	 * �����鷢��ʱ�����ȡ��
	 * @return �����鷢��ʱ�����
	 */
	public String getPgropentime_end() {
		return pgropentime_end;
	}

	/**
	 * �����鷢��ʱ������趨
	 * @param pgropentime_end �����鷢��ʱ�����
	 */
	public void setPgropentime_end(String pgropentime_end) {
		this.pgropentime_end = pgropentime_end;
	}

	/**
	 * ���������к�ȡ��
	 *
	 * @return ���������к�
	 */
	public String getPgrserialnum_like() {
		return pgrserialnum_like;
	}

	/**
	 * ���������к��趨
	 *
	 * @param pgrserialnum_like ���������к�
	 */
	public void setPgrserialnum_like(String pgrserialnum_like) {
		this.pgrserialnum_like = pgrserialnum_like;
	}

	/**
	 * ���������ȡ��
	 *
	 * @return ���������
	 */
	public String getPgrtitle_like() {
		return pgrtitle_like;
	}

	/**
	 * ����������趨
	 *
	 * @param pgrtitle_like ���������
	 */
	public void setPgrtitle_like(String pgrtitle_like) {
		this.pgrtitle_like = pgrtitle_like;
	}
	
	/**
	 * ����ģ������ȡ��
	 * 
	 * @return ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ����ģ�������趨
	 * 
	 * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * �����ʶȡ��
	 * @return order �����ʶ
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * �����ʶ�趨
	 * @param order �����ʶ
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * �����ֶ�ȡ��
	 * @return sing �����ֶ�
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * �����ֶ��趨
	 * @param sing �����ֶ�
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}
	
	/**
	 * �Ƿ���������趨
	 * @return �Ƿ��������
	 */
	public String getIstest() {
		return istest;
	}

	/**
	 * �Ƿ��������ȡ��
	 * @param istest �Ƿ��������
	 */
	public void setIstest(String istest) {
		this.istest = istest;
	}

	/**
	 * �����鶨��idȡ��
	 *
	 * @return �����鶨��id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * �����鶨��id�趨
	 *
	 * @param pgdid �����鶨��id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * �������Ƿ�ر�ȡ��
	 * @return �������Ƿ�ر�
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * �������Ƿ�ر��趨
	 * @param isActive �������Ƿ�ر�
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}