/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;

/**
  * ����: �澯ϵͳ��ʾ�����ʵ��
  * ��������: �澯ϵͳ��ʾ�����ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IndicatorLightsXml")
public class IndicatorLightsXmlTB extends BaseEntity implements Serializable,
		Cloneable, IndicatorLightsXmlInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="INDICATORLIGHTSXML_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INDICATORLIGHTSXML_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INDICATORLIGHTSXML_TABLE_GENERATOR")
	protected Integer ixid;

	/** �������� */
	protected String ixtitle;

	/** λ��X���� */
	protected String ixplacex;

	/** λ��Y���� */
	protected String ixplacey;

	/** ��� */
	protected Integer ixwidth;

	/** �߶� */
	protected Integer ixheight;

	/** rotation */
	protected String rotation;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getIxid() {
		return ixid;
	}

	/**
	 * �����趨
	 *
	 * @param ixid ����
	 */
	public void setIxid(Integer ixid) {
		this.ixid = ixid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getIxtitle() {
		return ixtitle;
	}

	/**
	 * ���������趨
	 *
	 * @param ixtitle ��������
	 */
	public void setIxtitle(String ixtitle) {
		this.ixtitle = ixtitle;
	}

	/**
	 * λ��X����ȡ��
	 *
	 * @return λ��X����
	 */
	public String getIxplacex() {
		return ixplacex;
	}

	/**
	 * λ��X�����趨
	 *
	 * @param ixplacex λ��X����
	 */
	public void setIxplacex(String ixplacex) {
		this.ixplacex = ixplacex;
	}

	/**
	 * λ��Y����ȡ��
	 *
	 * @return λ��Y����
	 */
	public String getIxplacey() {
		return ixplacey;
	}

	/**
	 * λ��Y�����趨
	 *
	 * @param ixplacey λ��Y����
	 */
	public void setIxplacey(String ixplacey) {
		this.ixplacey = ixplacey;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public Integer getIxwidth() {
		return ixwidth;
	}

	/**
	 * ����趨
	 *
	 * @param ixwidth ���
	 */
	public void setIxwidth(Integer ixwidth) {
		this.ixwidth = ixwidth;
	}

	/**
	 * �߶�ȡ��
	 *
	 * @return �߶�
	 */
	public Integer getIxheight() {
		return ixheight;
	}

	/**
	 * �߶��趨
	 *
	 * @param ixheight �߶�
	 */
	public void setIxheight(Integer ixheight) {
		this.ixheight = ixheight;
	}

	/**
	 * rotationȡ��
	 *
	 * @return rotation
	 */
	public String getRotation() {
		return rotation;
	}

	/**
	 * rotation�趨
	 *
	 * @param rotation rotation
	 */
	public void setRotation(String rotation) {
		this.rotation = rotation;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ixid;
	}

}