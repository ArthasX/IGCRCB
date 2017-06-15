/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
  * ����: �����������ϵʵ����ʵ��
  * ��������: �����������ϵʵ����ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG485PK.class)
public class IG485VW implements Serializable, Cloneable {

	/** �����������ϵ���� */
	@Id
	protected String pgreid;

	/**  ������ʵ��ID */
	@Id
	protected Integer pgrid;

	/** �ο�����ʵ��ID */
	@Id
	protected Integer prid;

	/** ״̬ */
	protected String pgrrstatus;

	/** ���ʱ�� */
	protected String pgrtime;
	
	/** �ο�����Ŀ��״̬ID */
	protected String rtpsdid;
	
	/** Ӱ�����̶���ID */
	protected String ipdid;
	
	/** Ӱ������״̬ID */
	protected String ipsdid;
	
	/** Ӱ������ԾǨ����BL */
	protected String transferhandler;

	

	/**
	 * @return the �����������ϵ����
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * @param �����������ϵ���� the pgreid to set
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

	/**
	 *  ������ʵ��idȡ��
	 *
	 * @return  ������ʵ��id
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 *  ������ʵ��id�趨
	 *
	 * @param pgrid  ������ʵ��id
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * �ο�����ʵ��IDȡ��
	 *
	 * @return �ο�����ʵ��ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �ο�����ʵ��ID�趨
	 *
	 * @param prid �ο�����ʵ��ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPgrrstatus() {
		return pgrrstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param pgrrstatus ״̬
	 */
	public void setPgrrstatus(String pgrrstatus) {
		this.pgrrstatus = pgrrstatus;
	}

	/**
	 * ���ʱ��ȡ��
	 *
	 * @return ���ʱ��
	 */
	public String getPgrtime() {
		return pgrtime;
	}

	/**
	 * ���ʱ���趨
	 *
	 * @param pgrtime ���ʱ��
	 */
	public void setPgrtime(String pgrtime) {
		this.pgrtime = pgrtime;
	}

	/**
	 * �ο�����Ŀ��״̬IDȡ��
	 * @return �ο�����Ŀ��״̬ID
	 */
	public String getRtpsdid() {
		return rtpsdid;
	}

	/**
	 * �ο�����Ŀ��״̬ID�趨
	 * @param rtpsdid �ο�����Ŀ��״̬ID
	 */
	public void setRtpsdid(String rtpsdid) {
		this.rtpsdid = rtpsdid;
	}

	/**
	 * Ӱ�����̶���IDȡ��
	 * @return Ӱ�����̶���ID
	 */
	public String getIpdid() {
		return ipdid;
	}

	/**
	 * Ӱ�����̶���ID�趨
	 * @param ipdid Ӱ�����̶���ID
	 */
	public void setIpdid(String ipdid) {
		this.ipdid = ipdid;
	}
	
	/**
	 * Ӱ������״̬IDȡ��
	 * @return Ӱ������״̬ID
	 */
	public String getIpsdid() {
		return ipsdid;
	}
	
	/**
	 * Ӱ������״̬ID�趨
	 * @param ipsdid Ӱ������״̬ID
	 */
	public void setIpsdid(String ipsdid) {
		this.ipsdid = ipsdid;
	}

	/**
	 * Ӱ������ԾǨ����BLȡ��
	 * @return Ӱ������ԾǨ����BL
	 */
	public String getTransferhandler() {
		return transferhandler;
	}

	/**
	 * Ӱ������ԾǨ����BL�趨
	 * @param transferhandler Ӱ������ԾǨ����BL
	 */
	public void setTransferhandler(String transferhandler) {
		this.transferhandler = transferhandler;
	}
	
}