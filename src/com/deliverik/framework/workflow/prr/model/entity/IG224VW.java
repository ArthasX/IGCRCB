/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * ����״̬��־ʵ��ӿ�
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG224VW implements Serializable, Cloneable {

	/** ����״̬��־ID */
	@Id
	protected Integer rslid;
	
	/** ����ID */
	protected Integer prid;
	
	/** ����״̬����ID */
	protected String psdid;
	
	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/** ���������״̬ID */
	protected String pendpsdid;
	
	/** ���������״̬ID��Ӧ��NUM */
	protected Integer pendpsdnum;
	
	/**
	 * ����״̬��־IDȡ��
	 * @return ����״̬��־ID
	 */
	public Integer getRslid() {
		return rslid;
	}

	/**
	 * ����״̬��־ID�趨
	 * @param rslid ����״̬��־ID
	 */
	public void setRslid(Integer rslid) {
		this.rslid = rslid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * ���������״̬IDȡ��
	 * @return ���������״̬ID
	 */
	public String getPendpsdid() {
		return pendpsdid;
	}

	/**
	 * ���������״̬ID�趨
	 * @param pendpsdid ���������״̬ID
	 */
	public void setPendpsdid(String pendpsdid) {
		this.pendpsdid = pendpsdid;
	}
	
	/**
	 * ���������״̬ID��Ӧ��NUMȡ��
	 * @return ���������״̬ID��Ӧ��NUM
	 */
	public Integer getPendpsdnum() {
		return pendpsdnum;
	}
	
	/**
	 * ���������״̬ID��Ӧ��NUM�趨
	 * @param pendpsdnum ���������״̬ID��Ӧ��NUM
	 */
	public void setPendpsdnum(Integer pendpsdnum) {
		this.pendpsdnum = pendpsdnum;
	}
	
}
