/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-26�½� 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGASM3116Form extends BaseForm{
	
	/**������*/
	protected String esyscoding;
	
	/**����*/
	protected String rimid;
	
	protected String asmxml;
	/** ����ָ����� */
	protected String RIMTYPE;

	/** ����ָ��˵�� */
	protected String RIMDESC;

	/** ָ��ά����� */
	protected String RIMSQL;
	
	/** �����ID */
	protected String eiid;
	
	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;
	
	/** ҳ����ʾ��ʶ  */	
	protected boolean flag = true;
	
	/**
	 * rIMTYPEȡ��
	 * @return rIMTYPE rIMTYPE
	 */
	public String getRIMTYPE() {
		return RIMTYPE;
	}

	/**
	 * rIMTYPE�趨
	 * @param rIMTYPE rIMTYPE
	 */
	public void setRIMTYPE(String rIMTYPE) {
		RIMTYPE = rIMTYPE;
	}

	/**
	 * rIMDESCȡ��
	 * @return rIMDESC rIMDESC
	 */
	public String getRIMDESC() {
		return RIMDESC;
	}

	/**
	 * rIMDESC�趨
	 * @param rIMDESC rIMDESC
	 */
	public void setRIMDESC(String rIMDESC) {
		RIMDESC = rIMDESC;
	}

	/**
	 * rIMSQLȡ��
	 * @return rIMSQL rIMSQL
	 */
	public String getRIMSQL() {
		return RIMSQL;
	}

	/**
	 * rIMSQL�趨
	 * @param rIMSQL rIMSQL
	 */
	public void setRIMSQL(String rIMSQL) {
		RIMSQL = rIMSQL;
	}

	/**
	 * asmxmlȡ��
	 * @return asmxml asmxml
	 */
	public String getAsmxml() {
		return asmxml;
	}

	/**
	 * asmxml�趨
	 * @param asmxml asmxml
	 */
	public void setAsmxml(String asmxml) {
		this.asmxml = asmxml;
	}

	/**
	 * ����ȡ��
	 * @return rimid ����
	 */
	public String getRimid() {
		return rimid;
	}

	/**
	 * �����趨
	 * @param rimid ����
	 */
	public void setRimid(String rimid) {
		this.rimid = rimid;
	}

	/**
	 * ������ȡ��
	 * @return esyscoding ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �������趨
	 * @param esyscoding ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �����IDȡ��
	 * @return eiid  �����ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �����ID�趨
	 * @param eiid  �����ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * ���ȡ��
	 * @return year  ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year  ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �·�ȡ��
	 * @return month  �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month  �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ҳ����ʾ��ʶȡ��
	 * @return flag  ҳ����ʾ��ʶ
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * ҳ����ʾ��ʶ�趨
	 * @param flag  ҳ����ʾ��ʶ
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
