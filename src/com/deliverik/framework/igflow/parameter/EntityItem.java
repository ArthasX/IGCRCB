/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.parameter;

import java.util.List;

/**
 * �ʲ������Ϣ
 */
public class EntityItem implements EntityItemInfo {

	/** �ʲ����� */
	protected String einame;

	/** �ʲ�˵�� */
	protected String eidesc;

	/** �ʲ���� */
	protected String eilabel;

	/** �ʲ�������������� */
	protected String eiorgsyscoding;

	/** �ʲ�����ģ�Ͳ���� */
	protected String esyscoding;

	/** �ʲ�������ID */
	protected String eiuserid;

	/** �ʲ����������� */
	protected String eiusername;

	/** �ʲ�״̬ */
	protected String eistatus;

	/** ʱ��� */
	protected String fingerPrint;

	/** �ʲ�����������Ϣ */
	protected List<EntityItemConfigValueInfo> configItems;
	
	/** �����Ǽ��� */
	protected String eiinsdate;
	
	/**
	 * �ʲ�����ȡ��
	 * 
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 * 
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ�˵��ȡ��
	 * 
	 * @return �ʲ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �ʲ�˵���趨
	 * 
	 * @param eidesc �ʲ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �ʲ����ȡ��
	 * 
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 * 
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ��������������ȡ��
	 * 
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �ʲ���������������趨
	 * 
	 * @param eiorgsyscoding �ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�����ģ�Ͳ����ȡ��
	 * 
	 * @return �ʲ�����ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�����ģ�Ͳ�����趨
	 * 
	 * @param esyscoding �ʲ�����ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�������IDȡ��
	 * 
	 * @return �ʲ�������ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �ʲ�������ID�趨
	 * 
	 * @param eiuserid �ʲ�������ID
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * �ʲ�����������ȡ��
	 * 
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * �ʲ������������趨
	 * 
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * �ʲ�״̬ȡ��
	 * 
	 * @return �ʲ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ʲ�״̬�趨
	 * 
	 * @param eistatus �ʲ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * ʱ���ȡ��
	 * 
	 * @return ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ʱ����趨
	 * 
	 * @param fingerPrint ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * �ʲ�����������Ϣȡ��
	 * 
	 * @return �ʲ�����������Ϣ
	 */
	public List<EntityItemConfigValueInfo> getConfigItems() {
		return configItems;
	}

	/**
	 * �ʲ�����������Ϣ�趨
	 * 
	 * @param configItems �ʲ�����������Ϣ
	 */
	public void setConfigItems(List<EntityItemConfigValueInfo> configItems) {
		this.configItems = configItems;
	}

	/**
	 * �����Ǽ���ȡ��
	 * @return eiinsdate  �����Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �����Ǽ����趨
	 * @param eiinsdate  �����Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
}
