/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.GuestRecption;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  �Ӵ����˲�ѯʵ��ӿ�
 * 
 * @author songhaiyang@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class GuestRecptionVW  implements Serializable, Cloneable, GuestRecption {
	
	/** �Ӵ�����ID */
	@Id
	protected Integer rgid;
	
	/** �Ӵ�����ID */
	public Integer rid;
	
	/** �Ӵ��������� */
	protected String rname;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	/** �Ӵ��������� */
	protected String retime;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	
	/**  �Ӵ����˵�λ */
	protected String rgunit;
	
	/** �Ӵ��������� */
	protected String rgname;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;

	/** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rgid;
	}

	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRgid() {
		return rgid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rgid �Ӵ�����ID
	 */
	public void setRgid(Integer rgid) {
		this.rgid = rgid;
	}
	
	/**
	 * �Ӵ�����IDȡ��
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID�趨
	 * @param rgid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * �Ӵ���������
	 * @return �Ӵ���������
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * �Ӵ���������
	 * @param rname �Ӵ���������
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * �Ӵ��������� 
	 * @return �Ӵ��������� 
	 */
	public String getRetime() {
		return retime;
	}

	/**
	 * �Ӵ��������� 
	 * @param retime �Ӵ��������� 
	 */
	public void setRetime(String retime) {
		this.retime = retime;
	}

	/**
	 * �Ӵ���ʼ���� 
	 * @return �Ӵ���ʼ���� 
	 */
	public String getRstime() {
		return rstime;
	}

	/**
	 * �Ӵ���ʼ����
	 * @param rstime �Ӵ���ʼ����
	 */
	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @return ��Ҫ���벿�Ų����
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @param rapporgid ��Ҫ���벿�Ų����
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	/**
	 * �Ӵ����˵�λȡ��
	 * @param rgunit �Ӵ����˵�λ
	 */
	public String getRgunit() {
		return rgunit;
	}
	/**
	 * �Ӵ����˵�λ�趨
	 * @param rgunit �Ӵ����˵�λ
	 */
	public void setRgunit(String rgunit) {
		this.rgunit = rgunit;
	}

	/**
	 * �Ӵ���������ȡ��
	 * @param rapporgid ���Ӵ���������
	 */
	public String getRgname() {
		return rgname;
	}
	
	/**
	 * �Ӵ����������趨
	 * @param rgname �Ӵ���������
	 */
	public void setRgname(String rgname) {
		this.rgname = rgname;
	}
	
	/**
	 * ״̬
	 * @return ״̬
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * ״̬
	 * @param rstatus ״̬
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
}
