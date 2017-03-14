/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;

/**
  * ����: �Աȶ���ʵ��
  * ��������: �Աȶ���ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareobject")
public class CompareobjectTB extends BaseEntity implements Serializable,
		Cloneable, CompareobjectInfo {

	/** ���� */
	@Id

	@GeneratedValue(generator = "coid")
	@GenericGenerator(name = "coid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "compareobject_seq") })
	protected Integer coid;

	/** ���� */
	protected String coname;

	/** �Ա�Դ����id */
	protected Integer cosource;
	

	/** �Ա�Ŀ������id */
	protected Integer cotarget;

	@Column(name="fkcrid")
	/** �Աȹ������ */
	protected Integer fkCrid;
	

	/** Դ����IP */
	protected String sourceIP;

	/** targetIP */
	protected String targetIP;

	/** �Աȹ���汾 */
	protected Integer crversion;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getCoid() {
		return coid;
	}

	/**
	 * �����趨
	 *
	 * @param coid ����
	 */
	public void setCoid(Integer coid) {
		this.coid = coid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getConame() {
		return coname;
	}

	/**
	 * �����趨
	 *
	 * @param coname ����
	 */
	public void setConame(String coname) {
		this.coname = coname;
	}

	/**
	 * �Ա�Դ����idȡ��
	 *
	 * @return �Ա�Դ����id
	 */
	public Integer getCosource() {
		return cosource;
	}

	/**
	 * �Ա�Դ����id�趨
	 *
	 * @param cosource �Ա�Դ����id
	 */
	public void setCosource(Integer cosource) {
		this.cosource = cosource;
	}

	/**
	 * �Ա�Ŀ������idȡ��
	 *
	 * @return �Ա�Ŀ������id
	 */
	public Integer getCotarget() {
		return cotarget;
	}

	/**
	 * �Ա�Ŀ������id�趨
	 *
	 * @param cotarget �Ա�Ŀ������id
	 */
	public void setCotarget(Integer cotarget) {
		this.cotarget = cotarget;
	}

	/**
	 * �Աȹ������ȡ��
	 *
	 * @return �Աȹ������
	 */
	public Integer getFkCrid() {
		return fkCrid;
	}

	/**
	 * �Աȹ�������趨
	 *
	 * @param fk_crid �Աȹ������
	 */
	public void setFkCrid(Integer fkCrid) {
		this.fkCrid = fkCrid;
	}

	/**
	 * Դ����IPȡ��
	 *
	 * @return Դ����IP
	 */
	public String getSourceIP() {
		return sourceIP;
	}

	/**
	 * Դ����IP�趨
	 *
	 * @param sourceIP Դ����IP
	 */
	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}

	/**
	 * targetIPȡ��
	 *
	 * @return targetIP
	 */
	public String getTargetIP() {
		return targetIP;
	}

	/**
	 * targetIP�趨
	 *
	 * @param targetIP targetIP
	 */
	public void setTargetIP(String targetIP) {
		this.targetIP = targetIP;
	}

	/** 
     * �Աȹ���汾 ȡ��
     * @return crversion �Աȹ���汾 
     */
    public Integer getCrversion() {
        return crversion;
    }

    /** 
     * �Աȹ���汾 �趨
     * @param crversion �Աȹ���汾 
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }

    /**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return coid;
	}



	
}