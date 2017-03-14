/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.soc.asset.model.SOC0112Info;

/**
  * ����: �ʲ�����ϸ��ʵ��
  * ��������: �ʲ�����ϸ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0112PK.class)
@Table(name="SOC0112")
public class SOC0112TB extends BaseEntity implements Serializable,
		Cloneable, SOC0112Info,LogicalDelete {

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
	
	/**
	 * ����ʱ��
	 */
	protected String createtime;

	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** �Ƿ񱻸��ı�ʶ */
	protected String modifyFlag;
	
	
	
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
	public SOC0112TB(){
		
	}
    public SOC0112TB(Integer eiddid,Integer eiddversion,String einame,Integer eiImportversion,String createtime){
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

	public String getModifyFlag() {
		return modifyFlag;
	}

	public void setModifyFlag(String modifyFlag) {
		this.modifyFlag = modifyFlag;
	}
	
	

}