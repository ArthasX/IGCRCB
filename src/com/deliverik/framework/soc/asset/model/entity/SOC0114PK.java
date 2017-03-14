/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ʵ����·ͼʵ������
  * ��������: ʵ����·ͼʵ������
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0114PK extends BasePK implements Serializable {

	/** ��ID */
	protected Integer domainid;

	/** Domain�汾 */
	protected Integer domainversion;

	/** ��·ID */
	protected Integer linkid;

	/** ��·˳�� */
	protected Integer linkorder;

	/**
	 * ���캯��
	 */
	public SOC0114PK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0114PK(Integer domainid, Integer domainversion, Integer linkid, Integer linkorder) {
		super();
		this.domainid = domainid;
		this.domainversion = domainversion;
		this.linkid = linkid;
		this.linkorder = linkorder;
	}

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param domainid ��ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain�汾�趨
	 *
	 * @param domainversion Domain�汾
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	/**
	 * ��·IDȡ��
	 *
	 * @return ��·ID
	 */
	public Integer getLinkid() {
		return linkid;
	}

	/**
	 * ��·ID�趨
	 *
	 * @param linkid ��·ID
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}

	/**
	 * ��·˳��ȡ��
	 *
	 * @return ��·˳��
	 */
	public Integer getLinkorder() {
		return linkorder;
	}

	/**
	 * ��·˳���趨
	 *
	 * @param linkorder ��·˳��
	 */
	public void setLinkorder(Integer linkorder) {
		this.linkorder = linkorder;
	}

}