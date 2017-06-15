/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.EworkingLunch;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ʳ�ù����͵ǼǱ��Form
 *
 */
public class IGLOM0503Form extends BaseForm  implements EworkingLunch {


	private static final long serialVersionUID = 1L;

	/** �������������� */
	protected Integer ewlid;

	/** ���� */
	protected String ewldate;
	
	/** �Ϳ����� */
	protected String lunchcardname;
	
	/** �Ϳ����� */
	protected Integer lunchcardnum;
	
	/** �Ϳ����� */
	protected String[] lunchcardnameList;
	
	/** �Ϳ����� */
	protected Integer[] lunchcardnumList;
	
	/** �Ϳ���� */
	protected Integer[] icidList;
	
	/** �Ϳ���Ǯ */
	protected BigDecimal lunchcardprince;
	
	/** �Ϳ���� */
	protected Integer icid;
	
	/** ʳ�óɱ���Ϣ��ʼʱ�� */
	protected String ewltime_from;
	
	/** ʳ�óɱ���Ϣ����ʱ�� */
	protected String ewltime_to;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";	
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public Integer getEwlid() {
		return ewlid;
	}
	
	/**
	 * ��������������
	 * @return ��������������
	 */
	public void setEwlid(Integer ewlid) {
		this.ewlid = ewlid;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getEwldate() {
		return ewldate;
	}
	/**
	 * ����
	 * @param ewldate ����
	 */
	public void setEwldate(String ewldate) {
		this.ewldate = ewldate;
	}

	/**
	 * ʳ�óɱ���Ϣ��ʼʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String getEwltime_from() {
		return ewltime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ��ʼʱ���ѯ�趨
	 * @param ewltime_from ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public void setEwltime_from(String ewltime_from) {
		this.ewltime_from = ewltime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public String getEwltime_to() {
		return ewltime_to;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯ�趨
	 * @param ewltime_to ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public void setEwltime_to(String ewltime_to) {
		this.ewltime_to = ewltime_to;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ҳ�������ʾȡ��
	 * @return ҳ�������ʾ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ�������ʾ�趨
	 * @param mode ҳ�������ʾ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public BigDecimal getLunchcardprince() {
		return lunchcardprince;
	}

	public void setLunchcardprince(BigDecimal lunchcardprince) {
		this.lunchcardprince = lunchcardprince;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public String[] getLunchcardnameList() {
		return lunchcardnameList;
	}

	public void setLunchcardnameList(String[] lunchcardnameList) {
		this.lunchcardnameList = lunchcardnameList;
	}

	public Integer[] getLunchcardnumList() {
		return lunchcardnumList;
	}

	public void setLunchcardnumList(Integer[] lunchcardnumList) {
		this.lunchcardnumList = lunchcardnumList;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public Integer getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(Integer lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public Integer[] getIcidList() {
		return icidList;
	}

	public void setIcidList(Integer[] icidList) {
		this.icidList = icidList;
	}

}
