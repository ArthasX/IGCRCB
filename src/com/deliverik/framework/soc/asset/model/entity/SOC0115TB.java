/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0115Info;

/**
  * ����: ����������ʵ��
  * ��������: ����������ʵ��
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0115")
public class SOC0115TB extends BaseEntity implements Serializable,
		Cloneable, SOC0115Info, LogicalDelete {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="SOC0115_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0115_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0115_TABLE_GENERATOR")
	protected Integer eitid;

	/** ���񴴽�ʱ�� */
	protected String eitcreatetime;

	/** ����ci */
	protected String eittopci;
	
	/** ����CI���� */
	protected Integer impTypeid;

	/** Դ�ļ��� */
	protected String eitfilename;

	/** ״̬ */
	protected String eitstatus;

	/** ������ʼʱ�� */
	protected String eitparsestart;

	/** ��������ʱ�� */
	protected String eitparseend;

	/** CIʵ�����ɿ�ʼʱ�� */
	protected String eitcistart;

	/** CIʵ�����ɽ���ʱ�� */
	protected String eitciend;

	/** ��ϵ������ʼʱ�� */
	protected String eitrelationstart;

	/** ��ϵ��������ʱ�� */
	protected String eitrelationend;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="impTypeid", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0113TB eiImportProgrammeTB;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * �߼������趨
	 *
	 * @param eitid�߼�����
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

	/**
	 * ���񴴽�ʱ��ȡ��
	 *
	 * @return ���񴴽�ʱ��
	 */
	public String getEitcreatetime() {
		return eitcreatetime;
	}

	/**
	 * ���񴴽�ʱ���趨
	 *
	 * @param eitcreatetime���񴴽�ʱ��
	 */
	public void setEitcreatetime(String eitcreatetime) {
		this.eitcreatetime = eitcreatetime;
	}

	/**
	 * ����ciȡ��
	 *
	 * @return ����ci
	 */
	public String getEittopci() {
		return eittopci;
	}

	/**
	 * ����ci�趨
	 *
	 * @param eittopci����ci
	 */
	public void setEittopci(String eittopci) {
		this.eittopci = eittopci;
	}

	/**
	 * Դ�ļ���ȡ��
	 *
	 * @return Դ�ļ���
	 */
	public String getEitfilename() {
		return eitfilename;
	}

	/**
	 * Դ�ļ����趨
	 *
	 * @param eitfilenameԴ�ļ���
	 */
	public void setEitfilename(String eitfilename) {
		this.eitfilename = eitfilename;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getEitstatus() {
		return eitstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param eitstatus״̬
	 */
	public void setEitstatus(String eitstatus) {
		this.eitstatus = eitstatus;
	}

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getEitparsestart() {
		return eitparsestart;
	}

	/**
	 * ������ʼʱ���趨
	 *
	 * @param eitparsestart������ʼʱ��
	 */
	public void setEitparsestart(String eitparsestart) {
		this.eitparsestart = eitparsestart;
	}

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getEitparseend() {
		return eitparseend;
	}

	/**
	 * ��������ʱ���趨
	 *
	 * @param eitparseend��������ʱ��
	 */
	public void setEitparseend(String eitparseend) {
		this.eitparseend = eitparseend;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ��ȡ��
	 *
	 * @return CIʵ�����ɿ�ʼʱ��
	 */
	public String getEitcistart() {
		return eitcistart;
	}

	/**
	 * CIʵ�����ɿ�ʼʱ���趨
	 *
	 * @param eitcistartCIʵ�����ɿ�ʼʱ��
	 */
	public void setEitcistart(String eitcistart) {
		this.eitcistart = eitcistart;
	}

	/**
	 * CIʵ�����ɽ���ʱ��ȡ��
	 *
	 * @return CIʵ�����ɽ���ʱ��
	 */
	public String getEitciend() {
		return eitciend;
	}

	/**
	 * CIʵ�����ɽ���ʱ���趨
	 *
	 * @param eitciendCIʵ�����ɽ���ʱ��
	 */
	public void setEitciend(String eitciend) {
		this.eitciend = eitciend;
	}

	/**
	 * ��ϵ������ʼʱ��ȡ��
	 *
	 * @return ��ϵ������ʼʱ��
	 */
	public String getEitrelationstart() {
		return eitrelationstart;
	}

	/**
	 * ��ϵ������ʼʱ���趨
	 *
	 * @param eitrelationstart��ϵ������ʼʱ��
	 */
	public void setEitrelationstart(String eitrelationstart) {
		this.eitrelationstart = eitrelationstart;
	}

	/**
	 * ��ϵ��������ʱ��ȡ��
	 *
	 * @return ��ϵ��������ʱ��
	 */
	public String getEitrelationend() {
		return eitrelationend;
	}

	/**
	 * ��ϵ��������ʱ���趨
	 *
	 * @param eitrelationend��ϵ��������ʱ��
	 */
	public void setEitrelationend(String eitrelationend) {
		this.eitrelationend = eitrelationend;
	}
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param brdeleteflag�߼�ɾ����ʶ
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
		return eitid;
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
	public SOC0113TB getEiImportProgrammeTB() {
		return eiImportProgrammeTB;
	}

	/**
	 * �������������Ϣ�趨
	 * 
	 * @param eiImportProgrammeTB �������������Ϣ
	 */
	public void setEiImportProgrammeTB(SOC0113TB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}
	
}