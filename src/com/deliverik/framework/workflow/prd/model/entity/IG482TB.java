/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG482Info;

/**
  * ����: �����������ϵ�����ʵ��
  * ��������: �����������ϵ�����ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG482")
public class IG482TB extends BaseEntity implements Serializable,
		Cloneable, IG482Info {

	/** ���� */
	@Id
	protected String pgreid;

	/** ������id */
	protected String pgdid;

	/** �ο����̶��� */
	protected String rpdid;

	/** Ӱ�����̶��� */
	protected String ipdid;

	/** ԾǨ���� */
	protected String pgrerule;

	/** �ο�����״̬ */
	protected String rpsdid;
	
	/** �ο�����Ŀ��״̬ */
	protected String rtpsdid;

	/** Ӱ������״̬ */
	protected String ipsdid;

	/** �������⴦�� */
	protected String transferHandler;


	/**
	 * @return the ����
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * @param ���� the pgreid to set
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * ������id�趨
	 *
	 * @param pgdid ������id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * �ο����̶���ȡ��
	 *
	 * @return �ο����̶���
	 */
	public String getRpdid() {
		return rpdid;
	}

	/**
	 * �ο����̶����趨
	 *
	 * @param rpdid �ο����̶���
	 */
	public void setRpdid(String rpdid) {
		this.rpdid = rpdid;
	}

	/**
	 * Ӱ�����̶���ȡ��
	 *
	 * @return Ӱ�����̶���
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * Ӱ�����̶����趨
	 *
	 * @param ipdid Ӱ�����̶���
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}

	/**
	 * ԾǨ����ȡ��
	 *
	 * @return ԾǨ����
	 */
	public String getPgrerule() {
		return pgrerule;
	}

	/**
	 * ԾǨ�����趨
	 *
	 * @param pgrerule ԾǨ����
	 */
	public void setPgrerule(String pgrerule) {
		this.pgrerule = pgrerule;
	}

	/**
	 * �ο�����״̬ȡ��
	 *
	 * @return �ο�����״̬
	 */
	public String getRpsdid() {
		return rpsdid;
	}

	/**
	 * �ο�����״̬�趨
	 *
	 * @param rpsdid �ο�����״̬
	 */
	public void setRpsdid(String rpsdid) {
		this.rpsdid = rpsdid;
	}

	/**
	 * Ӱ������״̬ȡ��
	 *
	 * @return Ӱ������״̬
	 */
	public String getIpsdid() {
		return ipsdid;
	}

	/**
	 * Ӱ������״̬�趨
	 *
	 * @param ipsdid Ӱ������״̬
	 */
	public void setIpsdid(String ipsdid) {
		this.ipsdid = ipsdid;
	}

	/**
	 * �������⴦��ȡ��
	 *
	 * @return �������⴦��
	 */
	public String getTransferHandler() {
		return transferHandler;
	}

	/**
	 * �������⴦���趨
	 *
	 * @param transferHandler �������⴦��
	 */
	public void setTransferHandler(String transferHandler) {
		this.transferHandler = transferHandler;
	}
	
	/**
	 * �ο�����Ŀ��״̬ȡ��
	 * @return �ο�����Ŀ��״̬
	 */
	public String getRtpsdid() {
		return rtpsdid;
	}

	/**
	 * �ο�����Ŀ��״̬�趨
	 * @param rtpsdid �ο�����Ŀ��״̬
	 */
	public void setRtpsdid(String rtpsdid) {
		this.rtpsdid = rtpsdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pgreid;
	}

}