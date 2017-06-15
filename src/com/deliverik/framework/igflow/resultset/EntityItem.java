/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * �ʲ���Ϣ
 */
public class EntityItem implements EntityItemInfo {

	/** �ʲ�ID */
	protected Integer eiid;
	
	/** �ʲ����� */
	protected String einame;

	/** �ʲ��� */
	protected String eilabel;

	/** �ʲ�������������� */
	protected String eiorgsyscoding;

	/** �ʲ�����ģ�Ͳ���� */
	protected String esyscoding;

	/** �ʲ�������ID */
	protected String eiuserid;

	/** �ʲ����������� */
	protected String eiusername;
	
	/** �ʲ��汾 */
	protected Integer eiversion;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;

	/** �ʲ�������Ϣ�б� */
	protected List<ConfigItemInfo> configItems;
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

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
	 * �ʲ���ȡ��
	 * 
	 * @return �ʲ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ����趨
	 * 
	 * @param eilabel �ʲ���
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
	 * �ʲ�������ID��Ϣ�趨
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
	 * �ʲ��汾ȡ��
	 * @return �ʲ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾�趨
	 *
	 * @param eiversion �ʲ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * �ʲ�������Ϣ�б�ȡ��
	 * 
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<ConfigItemInfo> getConfigItems() {
		return configItems;
	}

	/**
	 * �ʲ�������Ϣ�б�
	 * 
	 * @param configItems �ʲ�������Ϣ�б��趨
	 */
	public void setConfigItems(List<ConfigItemInfo> configItems) {
		this.configItems = configItems;
	}
	
}
