/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * ����״̬��־ʵ��ӿ�
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG224")
public class IG224TB extends BaseEntity implements Serializable, Cloneable, IG224Info {

	/** ����״̬��־ID */
	@Id
	@TableGenerator(
		    name="IG224_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG224_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG224_TABLE_GENERATOR")
	protected Integer rslid;
	
	/** ����ID */
	protected Integer prid;
	
	/** �Զ�����������ID */
	protected String prpdid;
	
	/** �������� */
	protected String prtype;

	/** ����״̬ */
	protected String prstatus;
	
	/** ��ʼʱ�� */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date rslOpenTime;
	
	/** ����ʱ�� */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date rslCloseTime;
	
	/** �Ƿ�ʱ */
	protected String rslExpect;
	
	/** ����״̬����ID */
	protected String psdid;
	
	/** �ϼ�����״̬����ID */
	protected String ppsdid;
	
	/** ����ڵ�״̬ */
	protected String virtualstatus;
	
	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/** ����ʼʱ�� */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date pendOpenTime;
	
	/** �������ʱ�� */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date pendCloseTime;
	
	/** �Ƿ���� */
	protected String pend;
	
	/** ���������״̬ID */
	protected String pendpsdid;
	
	/** ���������״̬ID��Ӧ��NUM */
	protected Integer pendpsdnum;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rslid;
	}

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
	 * �Զ�����������IDȡ��
	 * @return �Զ�����������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * �Զ�����������ID�趨
	 * @param prpdid �Զ�����������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ���������趨
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ����״̬ȡ��
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public Date getRslOpenTime() {
		return rslOpenTime;
	}

	/**
	 * ��ʼʱ���趨
	 * @param rslOpenTime ��ʼʱ��
	 */
	public void setRslOpenTime(Date rslOpenTime) {
		this.rslOpenTime = rslOpenTime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public Date getRslCloseTime() {
		return rslCloseTime;
	}

	/**
	 * ����ʱ���趨
	 * @param rslCloseTime ����ʱ��
	 */
	public void setRslCloseTime(Date rslCloseTime) {
		this.rslCloseTime = rslCloseTime;
	}

	/**
	 * �Ƿ�ʱȡ��
	 * @return �Ƿ�ʱ
	 */
	public String getRslExpect() {
		return rslExpect;
	}

	/**
	 * �Ƿ�ʱ�趨
	 * @param rslExpect �Ƿ�ʱ
	 */
	public void setRslExpect(String rslExpect) {
		this.rslExpect = rslExpect;
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
	 * �ϼ�����״̬����IDȡ��
	 * @return �ϼ�����״̬����ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�����״̬����ID�趨
	 * @param ppsdid �ϼ�����״̬����ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * ����ڵ�״̬ȡ��
	 * @return ����ڵ�״̬
	 */
	public String getVirtualstatus() {
		return virtualstatus;
	}

	/**
	 * ����ڵ�״̬�趨
	 * @param virtualstatus ����ڵ�״̬
	 */
	public void setVirtualstatus(String virtualstatus) {
		this.virtualstatus = virtualstatus;
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
	 * @return the pendOpenTime
	 */
	public Date getPendOpenTime() {
		return pendOpenTime;
	}

	/**
	 * @param pendOpenTime the pendOpenTime to set
	 */
	public void setPendOpenTime(Date pendOpenTime) {
		this.pendOpenTime = pendOpenTime;
	}

	/**
	 * @return the pendCloseTime
	 */
	public Date getPendCloseTime() {
		return pendCloseTime;
	}

	/**
	 * @param pendCloseTime the pendCloseTime to set
	 */
	public void setPendCloseTime(Date pendCloseTime) {
		this.pendCloseTime = pendCloseTime;
	}

	/**
	 * @return the pend
	 */
	public String getPend() {
		return pend;
	}

	/**
	 * @param pend the pend to set
	 */
	public void setPend(String pend) {
		this.pend = pend;
	}

	/**
	 * @return the pendpsdid
	 */
	public String getPendpsdid() {
		return pendpsdid;
	}

	/**
	 * @param pendpsdid the pendpsdid to set
	 */
	public void setPendpsdid(String pendpsdid) {
		this.pendpsdid = pendpsdid;
	}

	/**
	 * @return the pendpsdnum
	 */
	public Integer getPendpsdnum() {
		return pendpsdnum;
	}

	/**
	 * @param pendpsdnum the pendpsdnum to set
	 */
	public void setPendpsdnum(Integer pendpsdnum) {
		this.pendpsdnum = pendpsdnum;
	}
	
}
