/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0112PK;

/**
 * ����: ����ϸ��Ϣ
 * ��������: ����ϸ��Ϣ
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0138PK.class)
public class SOC0138 implements Serializable,Cloneable,SOC0138Info{

	
	/** �ʲ���ID */
	@Id
	protected Integer eiddid;

	/** �ʲ���汾 */
	@Id
	protected Integer eiddversion;

	/** �ʲ����� */
	@Id
	protected String einame;

	/** �ʲ�����汾 */
	@Id
	protected Integer eiImportversion;
	
	protected Integer eiid;
	
	/** �ʲ��ѽ�����ϵ���� */
	protected String eircount;
	

	/**
	 * �ʲ��ѽ�����ϵ����ȡ��
	 * @return �ʲ��ѽ�����ϵ����
	 */
	public String getEircount() {
		return eircount;
	}

	/**
	 * �ʲ��ѽ�����ϵ�����趨
	 * @param eircount�ʲ��ѽ�����ϵ����
	 */
	public void setEircount(String eircount) {
		this.eircount = eircount;
	}

	/**
	 * ����ʱ��
	 */
	protected String createtime;

	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	protected String fingerPrint;
	
	/** ����Ϣ */
	@ManyToOne
	@JoinColumns({
		  @JoinColumn(name="eiddid", referencedColumnName="eiddid" ,updatable=false, insertable= false),
		  @JoinColumn(name="eiddversion", referencedColumnName="version",updatable=false, insertable= false)
		      })
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0111TB eiDomainDefTB;
	
	
	
	
	
	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public SOC0111TB getEiDomainDefTB() {
		return eiDomainDefTB;
	}
	
	/**
	 * ����Ϣ�趨
	 * @param eiDomainDefTB����Ϣ
	 */
	public void setEiDomainDefTB(SOC0111TB eiDomainDefTB) {
		this.eiDomainDefTB = eiDomainDefTB;
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
	 * �ʲ���IDȡ��
	 *
	 * @return �ʲ���ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiddid�ʲ���ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * �ʲ���汾ȡ��
	 *
	 * @return �ʲ���汾
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * �ʲ���汾�趨
	 *
	 * @param eiddversion�ʲ���汾
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}



	/**
	 * �ʲ�����汾ȡ��
	 *
	 * @return �ʲ�����汾
	 */
	public Integer getEiImportversion() {
		return eiImportversion;
	}

	/**
	 * �ʲ�����汾�趨
	 *
	 * @param eiImportversion�ʲ�����汾
	 */
	public void setEiImportversion(Integer eiImportversion) {
		this.eiImportversion = eiImportversion;
	}

	public  String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}
	public SOC0138(){
		
	}
    public SOC0138(Integer eiddid,Integer eiddversion,String einame,Integer eiImportversion,String createtime){
    	this.eiddid = eiddid;
    	this.eiddversion = eiddversion;
    	this.einame = einame;
    	this.eiImportversion = eiImportversion;
    	this.createtime = createtime;		
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0112PK(eiddid, eiddversion, einame,eiImportversion);
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	
	
}
