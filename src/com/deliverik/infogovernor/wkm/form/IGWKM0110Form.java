/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wkm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ�������ͨ�ò�ѯform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGWKM0110Form extends BaseForm{
	
	/** ������ */
	protected String prserialnum;
	
	/** �������� */
	protected String prtype;
	
	/** ���̱��� */
	protected String prtitle;
	
	/** �������� */
	protected String prdesc;
	
	/** ��ʼʱ�� */
	protected String propentime;
	
	/** ����ʱ�� */
	protected String prclosetime;
	
	/** ���������� */
	protected String prusername;
	
	/** ����ʽ */
	protected String sing;
	
	/** �����ֶ� */
	protected String order;
	
	/** ��ѯ���ͱ�ʶ */
	protected String type;
	
	/** �����˵� */
	protected String pdactname;

	/**
	 * ������ȡ��
	 * @return prserialnum ������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * �������趨
	 * @param prserialnum ������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ��������ȡ��
	 * @return prtype ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���̱���ȡ��
	 * @return prtitle ���̱���
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̱����趨
	 * @param prtitle ���̱���
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���������趨
	 * @param prdesc ��������
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return propentime ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ��ʼʱ���趨
	 * @param propentime ��ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return prclosetime ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ����ʱ���趨
	 * @param prclosetime ����ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ����������ȡ��
	 * @return prusername ����������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * �����������趨
	 * @param prusername ����������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ����ʽȡ��
	 * @return sing ����ʽ
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * ����ʽ�趨
	 * @param sing ����ʽ
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}

	/**
	 * �����ֶ�ȡ��
	 * @return order �����ֶ�
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * �����ֶ��趨
	 * @param order �����ֶ�
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * ��ѯ���ͱ�ʶȡ��
	 * @return type ��ѯ���ͱ�ʶ
	 */
	public String getType() {
		return type;
	}

	/**
	 * ��ѯ���ͱ�ʶ�趨
	 * @param type ��ѯ���ͱ�ʶ
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * �����˵�ȡ��
	 * @return pdactname �����˵�
	 */
	public String getPdactname() {
		return pdactname;
	}

	/**
	 * �����˵��趨
	 * @param pdactname �����˵�
	 */
	public void setPdactname(String pdactname) {
		this.pdactname = pdactname;
	}
}
