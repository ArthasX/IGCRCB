/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * ����: �������ݰ汾�����ʵ��
  * ��������: �������ݰ汾�����ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(ImportVersionPK.class)
@Table(name="ImportVersion")
public class ImportVersionTB extends BaseEntity implements Serializable,
		Cloneable, ImportVersionInfo, LogicalDelete {

	/** ����ʵ��ID */
	protected Integer impeiid;

	/** ����汾 */
	@Id
	protected Integer impversion;

	/** ʵ���� */
	@Id
	protected String impeiname;
	
	/** ����CI���� */
	protected Integer impcitype;
	
	/** �����ļ��� */
	protected String impfilename;

	/** ����ʱ�� */
	protected String impcreatetime;
	
	/** �ʲ�ģ�Ͳ����*/
	protected String esyscoding;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** IP */
	protected String impip;
	
	/** �û��� */
	protected String impuserid;
	
	/** ���� */
	protected String imppassword;
	
	/** ״̬ */
	protected String impstatus;
	
	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="impcitype", referencedColumnName="impTypeid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected EiImportProgrammeTB eiImportProgrammeTB;
	
	@OneToOne
	@JoinColumn(name="impeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG013TB entityItemTB;

	public IG013TB getEntityItemTB()
	{
		return entityItemTB;
	}

	public void setEntityItemTB(IG013TB entityItemTB)
	{
		this.entityItemTB = entityItemTB;
	}
	
	/**
	 * ����ʵ��IDȡ��
	 *
	 * @return ����ʵ��ID
	 */
	public Integer getImpeiid() {
		return impeiid;
	}

	/**
	 * ����ʵ��ID�趨
	 *
	 * @param impeiid����ʵ��ID
	 */
	public void setImpeiid(Integer impeiid) {
		this.impeiid = impeiid;
	}

	/**
	 * ����汾ȡ��
	 *
	 * @return ����汾
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * ����汾�趨
	 *
	 * @param impversion����汾
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * ʵ�����趨
	 *
	 * @param impeinameʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * �����ļ���ȡ��
	 *
	 * @return �����ļ���
	 */
	public String getImpfilename() {
		return impfilename;
	}

	/**
	 * �����ļ����趨
	 *
	 * @param impfilename�����ļ���
	 */
	public void setImpfilename(String impfilename) {
		this.impfilename = impfilename;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getImpcreatetime() {
		return impcreatetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param impcreatetime����ʱ��
	 */
	public void setImpcreatetime(String impcreatetime) {
		this.impcreatetime = impcreatetime;
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
		return new ImportVersionPK(impversion, impeiname);
	}
	
	/** �ʲ�ģ�Ͳ�����ȡ*/
	public String getEsyscoding() {
		return esyscoding;
	}
	
	/** �ʲ�ģ�Ͳ�����趨*/
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**
	 * ��������
	 * @return ��������
	 */
	public Integer getImpcitype() {
		return impcitype;
	}
	/**
	 * ��������
	 * @param impcitype��������
	 */
	public void setImpcitype(Integer impcitype) {
		this.impcitype = impcitype;
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
	 * @param eiImportProgrammeTB�������������Ϣ
	 */
	public void setEiImportProgrammeTB(EiImportProgrammeTB eiImportProgrammeTB) {
		this.eiImportProgrammeTB = eiImportProgrammeTB;
	}

	/**
	 * IPȡ��
	 * 
	 * @return IP
	 */
	public String getImpip() {
		return impip;
	}

	/**
	 * IP�趨
	 * 
	 * @param impip IP
	 */
	public void setImpip(String impip) {
		this.impip = impip;
	}

	/**
	 * �û���ȡ��
	 * 
	 * @return �û���
	 */
	public String getImpuserid() {
		return impuserid;
	}

	/**
	 * �û����趨
	 * 
	 * @param impuserid �û���
	 */
	public void setImpuserid(String impuserid) {
		this.impuserid = impuserid;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getImppassword() {
		return imppassword;
	}

	/**
	 * �����趨
	 * 
	 * @param imppassword ����
	 */
	public void setImppassword(String imppassword) {
		this.imppassword = imppassword;
	}

	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getImpstatus() {
		return impstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param impstatus ״̬
	 */
	public void setImpstatus(String impstatus) {
		this.impstatus = impstatus;
	}

	public Integer getEircount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBelongcount() {
		// TODO Auto-generated method stub
		return null;
	}

}