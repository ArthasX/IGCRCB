/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;


/**
  * ����: �ʲ�������������ʵ��
  * ��������: �ʲ�������������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiDomainDefSearchCondImpl implements
		EiDomainDefSearchCond {
	/**
	 * �ʲ���������
	 */
	protected String name_like;
	/**
	 * �ʲ����忪ʼʱ��
	 */
	protected String createtime_from;
	/**
	 * �ʲ������ֹʱ��
	 */
	protected String createtime_to;
	
	/** ����ID */
	protected String eiddid_eq;
	
	/** ���� */
	protected Integer eiddid;
	
	/** �汾�� */
	protected Integer version;
	
	
	/**
	 * �ʲ���������ȡ��
	 */
	public String getName_like() {
		return name_like;
	}
	/**
	 * �ʲ����������趨
	 * @param name�ʲ���������
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	/**
	 * �ʲ����忪ʼʱ��ȡ��
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}
	/**
	 * �ʲ����忪ʼʱ���趨
	 * @param createtime_from�ʲ����忪ʼʱ��
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}
	/**
	 * �ʲ������ֹʱ��ȡ��
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}
	/**
	 * �ʲ������ֹʱ���趨
	 * @param createtime_to�ʲ������ֹʱ��
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public String getEiddid_eq() {
		return eiddid_eq;
	}
	
	/**
	 * ����ID�趨
	 * 
	 * @param eiddid_eq����ID
	 */
	public void setEiddid_eq(String eiddid_eq) {
		this.eiddid_eq = eiddid_eq;
	}
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * ��������
	 * 
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	
	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * �汾������
	 * 
	 * @param version�汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}