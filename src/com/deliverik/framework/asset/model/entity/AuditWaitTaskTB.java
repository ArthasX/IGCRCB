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

import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * ����: ��ƴ���������ʵ��
  * ��������: ��ƴ���������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AuditWaitTask")
public class AuditWaitTaskTB extends BaseEntity implements Serializable,
		Cloneable, AuditWaitTaskInfo, LogicalDelete {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="AUDITWAITTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="AUDITWAITTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITWAITTASK_TABLE_GENERATOR")
	protected Integer auwtid;

	/** ���񴴽�ʱ�� */
	protected String auwtcreatetime;

	/** Դ�ļ��� */
	protected String auwtfilename;
	
	/** ����CI */
	protected String auwttopci;
	
	/** ����CI���� */
	protected Integer impTypeid;

	/** ״̬ */
	protected String auwtstatus;

	/** ������ʼʱ�� */
	protected String auwtparsestart;

	/** ��������ʱ�� */
	protected String auwtparseend;

	/** CIʵ�����ɿ�ʼʱ�� */
	protected String auwtcistart;

	/** CIʵ�����ɽ���ʱ�� */
	protected String auwtciend;

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
	public Integer getAuwtid() {
		return auwtid;
	}

	/**
	 * �߼������趨
	 *
	 * @param auwtid �߼�����
	 */
	public void setAuwtid(Integer auwtid) {
		this.auwtid = auwtid;
	}

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getAuwtcreatetime() {
		return auwtcreatetime;
	}

	/**
	 * ���񴴽�ʱ���趨
	 *
	 * @param auwtcreatetime ���񴴽�ʱ��
	 */
	public void setAuwtcreatetime(String auwtcreatetime) {
		this.auwtcreatetime = auwtcreatetime;
	}

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getAuwtfilename() {
		return auwtfilename;
	}

	/**
	 * Դ�ļ����趨
	 *
	 * @param auwtfilename Դ�ļ���
	 */
	public void setAuwtfilename(String auwtfilename) {
		this.auwtfilename = auwtfilename;
	}
	
	/**
	 * ����CIȡ��
	 * 
	 * @return ����CI
	 */
	public String getAuwttopci() {
		return auwttopci;
	}

	/**
	 * ����CI�趨
	 * 
	 * @param auwttopci ����CI
	 */
	public void setAuwttopci(String auwttopci) {
		this.auwttopci = auwttopci;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getAuwtstatus() {
		return auwtstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param auwtstatus ״̬
	 */
	public void setAuwtstatus(String auwtstatus) {
		this.auwtstatus = auwtstatus;
	}

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getAuwtparsestart() {
		return auwtparsestart;
	}

	/**
	 * ������ʼʱ���趨
	 *
	 * @param auwtparsestart ������ʼʱ��
	 */
	public void setAuwtparsestart(String auwtparsestart) {
		this.auwtparsestart = auwtparsestart;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getAuwtparseend() {
		return auwtparseend;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param auwtparseend ��������ʱ��
	 */
	public void setAuwtparseend(String auwtparseend) {
		this.auwtparseend = auwtparseend;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getAuwtcistart() {
		return auwtcistart;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ���趨
	 *
	 * @param auwtcistart CIʵ�����ɿ�ʼʱ��
	 */
	public void setAuwtcistart(String auwtcistart) {
		this.auwtcistart = auwtcistart;
	}

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getAuwtciend() {
		return auwtciend;
	}

	/**
	 * CIʵ�����ɽ���ʱ���趨
	 *
	 * @param auwtciend CIʵ�����ɽ���ʱ��
	 */
	public void setAuwtciend(String auwtciend) {
		this.auwtciend = auwtciend;
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
		return auwtid;
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
	 * 
	 * @param eiImportProgrammeTB �������������Ϣ
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

}