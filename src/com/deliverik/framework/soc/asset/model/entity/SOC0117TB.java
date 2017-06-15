package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0117Info;

/**
 * <p>
 * �ʲ�ģ����Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SOC0117")
public class SOC0117TB extends BaseEntity implements Serializable, Cloneable, SOC0117Info {

	/** 
	 * �ʲ�ģ��ID 
	 */
	@Id
	protected String eid;
	
	/** �ʲ�ģ������ */
	protected String ename;
	
	/** �ʲ�ģ�ͱ�� */
	protected String elabel;

	/** �ʲ�ģ��˵�� */
	protected String edesc;

	/** �ʲ�ģ��״̬ */
	protected String estatus;
	
	/** �ʲ�ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�ģ��һ������ */
	protected String ekey1;
	
	/** �ʲ�ģ�Ͷ������� */
	protected String ekey2;
	
	/** �ʲ�ģ���������� */
	protected String ekey3;
	
	/**
	 * �ʲ�ģ�Ͳ����
	 */
	protected String esyscoding;
	
	/**
	 * �ʲ�ģ�͸��������
	 */
	protected String eparcoding;
	
	/**
	 * �ʲ�ģ�����0��һ���ʲ�ģ�� 1�������ʲ�ģ�ͣ�
	 */
	protected String emodeltype;

	/**
	 * �ʲ�ģ�͸��������ȡ��
	 * @return �ʲ�ģ�͸��������
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * �ʲ�ģ�͸���������趨
	 *
	 * @param eparcoding �ʲ�ģ�͸��������
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}
	
	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	

	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * �ʲ�ģ��˵��ȡ��
	 * @return �ʲ�ģ��˵��
	 */
	public String getEdesc() {
		return edesc;
	}


	/**
	 * �ʲ�ģ��˵���趨
	 *
	 * @param edesc �ʲ�ģ��˵��
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * �ʲ�ģ��״̬ȡ��
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
	 * �ʲ�ģ�ͷ���ȡ��
	 * @return �ʲ�ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}


	/**
	 * �ʲ�ģ�ͷ����趨
	 *
	 * @param ecategory �ʲ�ģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}


	/**
	 * �ʲ�ģ��һ������ȡ��
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
	 * �ʲ�ģ�ͱ��ȡ��
	 * @return �ʲ�ģ�ͱ��
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ���趨
	 *
	 * @param elabel �ʲ�ģ�ͱ��
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	
	/**
	 * �ʲ�ģ������趨
	 *
	 * @param eparcoding �ʲ�ģ�����
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

}
