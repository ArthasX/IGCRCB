/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �����������Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0201Form extends BaseForm {
	
	/** ����������� */
	protected Integer id;
	
	/** ���̱��������� */
	protected String pidid;
	
	/** �������� */
	protected Integer prid;
	
	/** ״̬��ʶ */
	protected String psdcode;
	
	/** ״̬���� */
	protected String psdname;
	
	/** ������� */
	protected String suggestion;
	
	/** ���ʽ��������� */
	protected String rownumber;

	/**
	 * �����������ȡ��
	 *
	 * @return id �����������
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * ������������趨
	 *
	 * @param id �����������
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ���̱���������ȡ��
	 *
	 * @return pidid ���̱���������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱����������趨
	 *
	 * @param pidid ���̱���������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬��ʶȡ��
	 *
	 * @return psdcode ״̬��ʶ
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ״̬��ʶ�趨
	 *
	 * @param psdcode ״̬��ʶ
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ״̬����ȡ��
	 *
	 * @return psdname ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ״̬�����趨
	 *
	 * @param psdname ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * �������ȡ��
	 *
	 * @return suggestion �������
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * ��������趨
	 *
	 * @param suggestion �������
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * ���ʽ���������ȡ��
	 * @return rownumber ���ʽ���������
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * ���ʽ����������趨
	 * @param rownumber ���ʽ���������
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
	

}