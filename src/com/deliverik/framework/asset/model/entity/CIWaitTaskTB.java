/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * ����: CI�������������ʵ��
  * ��������: CI�������������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CIWaitTask")
public class CIWaitTaskTB extends BaseEntity implements Serializable,
		Cloneable, CIWaitTaskInfo, LogicalDelete {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="CIWAITTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CIWAITTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CIWAITTASK_TABLE_GENERATOR")
	protected Integer ciwtid;

	/** ���񴴽�ʱ�� */
	protected String ciwtcreatetime;

	/** Դ�ļ��� */
	protected String ciwtfilename;
	
	/** ����CI */
	protected String ciwttopci;
	
	/** ����CI���� */
	protected Integer impTypeid;

	/** ״̬ */
	protected String ciwtstatus;

	/** ������ʼʱ�� */
	protected String ciwtparsestart;

	/** ��������ʱ�� */
	protected String ciwtparseend;

	/** CIʵ�����ɿ�ʼʱ�� */
	protected String ciwtcistart;

	/** CIʵ�����ɽ���ʱ�� */
	protected String ciwtciend;

	/** ɾ����ʶ */
	protected String deleteflag;
	
	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="impTypeid", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected EiImportProgrammeTB eiImportProgrammeTB;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getCiwtid() {
		return ciwtid;
	}

	/**
	 * �߼������趨
	 *
	 * @param ciwtid �߼�����
	 */
	public void setCiwtid(Integer ciwtid) {
		this.ciwtid = ciwtid;
	}

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getCiwtcreatetime() {
		return ciwtcreatetime;
	}

	/**
	 * ���񴴽�ʱ���趨
	 *
	 * @param ciwtcreatetime ���񴴽�ʱ��
	 */
	public void setCiwtcreatetime(String ciwtcreatetime) {
		this.ciwtcreatetime = ciwtcreatetime;
	}

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getCiwtfilename() {
		return ciwtfilename;
	}

	/**
	 * Դ�ļ����趨
	 *
	 * @param ciwtfilename Դ�ļ���
	 */
	public void setCiwtfilename(String ciwtfilename) {
		this.ciwtfilename = ciwtfilename;
	}
	
	/**
	 * ����CIȡ��
	 * 
	 * @return ����CI
	 */
	public String getCiwttopci() {
		return ciwttopci;
	}

	/**
	 * ����CI�趨
	 * 
	 * @param ciwttopci ����CI
	 */
	public void setCiwttopci(String ciwttopci) {
		this.ciwttopci = ciwttopci;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getCiwtstatus() {
		return ciwtstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param ciwtstatus ״̬
	 */
	public void setCiwtstatus(String ciwtstatus) {
		this.ciwtstatus = ciwtstatus;
	}

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getCiwtparsestart() {
		return ciwtparsestart;
	}

	/**
	 * ������ʼʱ���趨
	 *
	 * @param ciwtparsestart ������ʼʱ��
	 */
	public void setCiwtparsestart(String ciwtparsestart) {
		this.ciwtparsestart = ciwtparsestart;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getCiwtparseend() {
		return ciwtparseend;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param ciwtparseend ��������ʱ��
	 */
	public void setCiwtparseend(String ciwtparseend) {
		this.ciwtparseend = ciwtparseend;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getCiwtcistart() {
		return ciwtcistart;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ���趨
	 *
	 * @param ciwtcistart CIʵ�����ɿ�ʼʱ��
	 */
	public void setCiwtcistart(String ciwtcistart) {
		this.ciwtcistart = ciwtcistart;
	}

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getCiwtciend() {
		return ciwtciend;
	}

	/**
	 * CIʵ�����ɽ���ʱ���趨
	 *
	 * @param ciwtciend CIʵ�����ɽ���ʱ��
	 */
	public void setCiwtciend(String ciwtciend) {
		this.ciwtciend = ciwtciend;
	}

	/**
	 * ɾ����ʶȡ��
	 *
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * ɾ����ʶ�趨
	 *
	 * @param deleteflag ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ciwtid;
	}
	
	/**
	 * ����CI����ȡ��
	 *
	 * @return ����CI����
	 */
	public Integer getImpTypeid() {
		return impTypeid;
	}

	/**
	 * ����CI�����趨
	 *
	 * @param impTypeid ����CI����
	 */
	public void setImpTypeid(Integer impTypeid) {
		this.impTypeid = impTypeid;
	}
	
	/**
	 * �������������Ϣȡ��
	 * @return �������������Ϣ
	 */
	public EiImportProgrammeTB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * �������������Ϣ�趨
	 * @param eiImportProgrammeTB �������������Ϣ
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

}