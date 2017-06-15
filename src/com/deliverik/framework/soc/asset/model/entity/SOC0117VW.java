/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;

/**
  * ����: SOC0117VWʵ��
  * ��������: SOC0117VWʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0117VWPK.class)
@Table(name="SOC0117VW")
public class SOC0117VW extends BaseEntity implements Serializable,
		Cloneable, SOC0117VWInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** �ʲ�����id */
	@Id
	protected String eid;

	/** �ʲ��������� */
	protected String ename;

	/** ϵͳԤ��ģ�ͱ�ʶ */
	protected String elabel;

	/** �ʲ�ģ�͵�˵�� */
	protected String edesc;

	/** �ʲ�ģ��״̬ */
	protected String estatus;

	/** �ʲ�ģ�͵ķ��� */
	protected String ecategory;

	/** �ʲ�ģ��һ������ */
	protected String ekey1;

	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;

	/** �ʲ�ģ���������� */
	protected String ekey3;

	/** �ʲ�ģ�͵Ĳ���� */
	protected String esyscoding;

	/** �ʲ�ģ�͵��ϼ�ģ�Ͳ���� */
	protected String eparcoding;
	
	/**
	 * �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	protected String emodeltype;

	/**
	 * @return the emodeltype
	 */
	public String getEmodeltype() {
		return emodeltype;
	}

	/**
	 * @param emodeltype the emodeltype to set
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ʲ�����idȡ��
	 *
	 * @return �ʲ�����id
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�����id�趨
	 *
	 * @param eid �ʲ�����id
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ���������ȡ��
	 *
	 * @return �ʲ���������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ����������趨
	 *
	 * @param ename �ʲ���������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * ϵͳԤ��ģ�ͱ�ʶȡ��
	 *
	 * @return ϵͳԤ��ģ�ͱ�ʶ
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * ϵͳԤ��ģ�ͱ�ʶ�趨
	 *
	 * @param elabel ϵͳԤ��ģ�ͱ�ʶ
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ�͵�˵��ȡ��
	 *
	 * @return �ʲ�ģ�͵�˵��
	 */
	public String getEdesc() {
		return edesc;
	}

	/**
	 * �ʲ�ģ�͵�˵���趨
	 *
	 * @param edesc �ʲ�ģ�͵�˵��
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	/**
	 * �ʲ�ģ��״̬ȡ��
	 *
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * �ʲ�ģ��״̬�趨
	 *
	 * @param estatus �ʲ�ģ��״̬
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * �ʲ�ģ�͵ķ���ȡ��
	 *
	 * @return �ʲ�ģ�͵ķ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * �ʲ�ģ�͵ķ����趨
	 *
	 * @param ecategory �ʲ�ģ�͵ķ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * �ʲ�ģ��һ������ȡ��
	 *
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * �ʲ�ģ��һ�������趨
	 *
	 * @param ekey1 �ʲ�ģ��һ������
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 *
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * �ʲ�ģ�Ͷ��������趨
	 *
	 * @param ekey2 �ʲ�ģ�Ͷ�������
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 *
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3() {
		return ekey3;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ekey3 �ʲ�ģ����������
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	/**
	 * �ʲ�ģ�͵Ĳ����ȡ��
	 *
	 * @return �ʲ�ģ�͵Ĳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�͵Ĳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�͵Ĳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�ģ�͵��ϼ�ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�ģ�͵��ϼ�ģ�Ͳ����
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * �ʲ�ģ�͵��ϼ�ģ�Ͳ�����趨
	 *
	 * @param eparcoding �ʲ�ģ�͵��ϼ�ģ�Ͳ����
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0117VWPK(id, eid);
	}

}