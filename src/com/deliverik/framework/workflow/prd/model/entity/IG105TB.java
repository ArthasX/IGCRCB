/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG105Info;

/**
 * ����: ���̲����趨��Ϣʵ��
 * �������������̲����趨��Ϣʵ��
 * ������¼������ 2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG105PK.class)
@Table(name = "IG105")
public class IG105TB extends BaseEntity implements Serializable,
		Cloneable, IG105Info {

	/** ���̶���ID */
	@Id
	protected String pdid;

	/** ����״̬ */
	@Id
	protected String prstatus;

	/** �����̶� */
	@Id
	protected String prurgency;

	/** ���԰汾 */
	@Id
	protected Integer psdversion;

	/** �������ʱ�� */
	protected Double expecttime;
	
	/** ���Դ���ʱ�� */
	protected String createtime;

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * 
	 * @param prstatus����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �����̶�ȡ��
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * �����̶��趨
	 * 
	 * @param prurgency�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
	
	/**
	 * ���԰汾ȡ��
	 * 
	 * @return ���԰汾
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * ���԰汾�趨
	 * 
	 * @param psdversion���԰汾
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}

	/**
	 * �������ʱ��ȡ��
	 * 
	 * @return �������ʱ��
	 */
	public Double getExpecttime() {
		return expecttime;
	}

	/**
	 * �������ʱ���趨
	 * 
	 * @param expecttime�������ʱ��
	 */
	public void setExpecttime(Double expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * ���Դ���ʱ��ȡ��
	 * 
	 * @return ���Դ���ʱ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ���Դ���ʱ���趨
	 * 
	 * @param createtime���Դ���ʱ��
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG105PK(pdid, prstatus, prurgency, psdversion);
	}

}
