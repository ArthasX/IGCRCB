/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.room.model.condition;

import java.io.Serializable;

/**
  * ����: compareTemplate��������ʵ��
  * ��������: compareTemplate��������ʵ��
  * ������¼: 2011/05/23
  * �޸ļ�¼: 
  */
public class CompareTemplateSearchCondImpl implements CompareTemplateSearchCond {
	protected Integer ctid;

	/** ���ID */
	protected String category;

	/** ���� */
	protected String type;
	
	/** ����Ϊ���� */
	protected String cabtype;

	/** ������ */
	protected String xwidth;

	/** ������ */
	protected String ywidth;

	/** ֵ */
	protected String value;
	
	/** ͼ������ */
	protected String[] legendArray;

	/**�豸�ʲ�ID*/
	protected String cteiid;
	
	/** ���Ͳ�����  */
	protected String netype;
	
	/** ����������� */
	protected String ctZoneId;
	
	/** type��Ϊzone��naf��ʶ	"ok":��Ϊzone��naf */
	protected String notZoneAndNotNafFlag;
	
	/**�豸�����ذ�x*/
	protected String ctfloorx;
	
	/**�豸�����ذ�y*/
	protected String ctfloory;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCtid() {
		return ctid;
	}

	/**
	 * �����趨
	 *
	 * @param ctid ����
	 */
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}

	/**
	 * ���IDȡ��
	 *
	 * @return ���ID
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * ���ID�趨
	 *
	 * @param category ���ID
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getType() {
		return type;
	}

	/**
	 * �����趨
	 *
	 * @param type ����
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getXwidth() {
		return xwidth;
	}

	/**
	 * �������趨
	 *
	 * @param xwidth ������
	 */
	public void setXwidth(String xwidth) {
		this.xwidth = xwidth;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getYwidth() {
		return ywidth;
	}

	/**
	 * �������趨
	 *
	 * @param ywidth ������
	 */
	public void setYwidth(String ywidth) {
		this.ywidth = ywidth;
	}

	/**
	 * ֵȡ��
	 *
	 * @return ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * ֵ�趨
	 *
	 * @param value ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ctid;
	}

	public String getCabtype() {
		return cabtype;
	}

	public void setCabtype(String cabtype) {
		this.cabtype = cabtype;
	}

	public String[] getLegendArray() {
		return legendArray;
	}

	public void setLegendArray(String[] legendArray) {
		this.legendArray = legendArray;
	}
	
	/**
	 * cteiidȡ��
	 *
	 * @return cteiid cteiid
	 */
	public String getCteiid() {
		return cteiid;
	}
	/**
	 * cteiid�趨
	 *
	 * @param cteiid cteiid
	 */
	public void setCteiid(String cteiid) {
		this.cteiid = cteiid;
	}
	
	/**
	 * netypeȡ��
	 *
	 * @return netype netype
	 */
	public String getNetype() {
		return netype;
	}

	/**
	 * netype�趨
	 *
	 * @param netype netype
	 */
	public void setNetype(String netype) {
		this.netype = netype;
	}
	
	/**
	 * ctZoneIdȡ��
	 *
	 * @return ctZoneId ctZoneId
	 */
	public String getCtZoneId() {
		return ctZoneId;
	}

	/**
	 * ctZoneId�趨
	 *
	 * @param ctZoneId ctZoneId
	 */
	public void setCtZoneId(String ctZoneId) {
		this.ctZoneId = ctZoneId;
	}

	/**
	 * type��Ϊzone��naf��ʶ ȡ��
	 *
	 * @return notZoneAndNotNafFlag
	 */
	public String getNotZoneAndNotNafFlag() {
		return notZoneAndNotNafFlag;
	}

	/**
	 * type��Ϊzone��naf��ʶ �趨
	 *
	 * @param notZoneAndNotNafFlag
	 */
	public void setNotZoneAndNotNafFlag(String notZoneAndNotNafFlag) {
		this.notZoneAndNotNafFlag = notZoneAndNotNafFlag;
	}

	public String getCtfloorx() {
		return ctfloorx;
	}

	public void setCtfloorx(String ctfloorx) {
		this.ctfloorx = ctfloorx;
	}

	public String getCtfloory() {
		return ctfloory;
	}

	public void setCtfloory(String ctfloory) {
		this.ctfloory = ctfloory;
	}
	
	
	
	
}