/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;

/**
  * ����: SOC0118VWʵ��
  * ��������: SOC0118VWʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0118VWPK.class)
@Table(name="SOC0118VW")
public class SOC0118VW extends BaseEntity implements Serializable,
		Cloneable, SOC0118VWInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** �ʲ�ID                   */
	@Id
	protected Integer eiid;

	/** �ʲ�ģ��ID               */
	protected String eid;

	/** �ʲ����˵��             */
	protected String eidesc;

	/** �ʲ�����                 */
	protected String einame;

	/** �ʲ����                 */
	protected String eilabel;

	/** �ʲ��Ǽ���               */
	protected String eiinsdate;

	/** �������������           */
	protected String eiorgsyscoding;

	/** ����ģ�Ͳ����           */
	protected String esyscoding;

	/** ����ʱ��                 */
	protected String eiupdtime;

	/** �ʲ�״̬                 */
	protected String eistatus;

	/** �汾                     */
	protected String eiversion;

	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;
	
	/**
	 * @return the eiuserid
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * @param eiuserid the eiuserid to set
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * @return the eiusername
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * @param eiusername the eiusername to set
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * @return the eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * @param eismallversion the eismallversion to set
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * @return the eirootmark
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * @param eirootmark the eirootmark to set
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ʲ�ID                  ȡ��
	 *
	 * @return �ʲ�ID                  
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID                  �趨
	 *
	 * @param eiid �ʲ�ID                  
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��ID              ȡ��
	 *
	 * @return �ʲ�ģ��ID              
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID              �趨
	 *
	 * @param eid �ʲ�ģ��ID              
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ����˵��            ȡ��
	 *
	 * @return �ʲ����˵��            
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �ʲ����˵��            �趨
	 *
	 * @param eidesc �ʲ����˵��            
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �ʲ�����                ȡ��
	 *
	 * @return �ʲ�����                
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ�����                �趨
	 *
	 * @param einame �ʲ�����                
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ����                ȡ��
	 *
	 * @return �ʲ����                
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ����                �趨
	 *
	 * @param eilabel �ʲ����                
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ��Ǽ���              ȡ��
	 *
	 * @return �ʲ��Ǽ���              
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �ʲ��Ǽ���              �趨
	 *
	 * @param eiinsdate �ʲ��Ǽ���              
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �������������          ȡ��
	 *
	 * @return �������������          
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �������������          �趨
	 *
	 * @param eiorgsyscoding �������������          
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * ����ģ�Ͳ����          ȡ��
	 *
	 * @return ����ģ�Ͳ����          
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ����ģ�Ͳ����          �趨
	 *
	 * @param esyscoding ����ģ�Ͳ����          
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ʱ��                ȡ��
	 *
	 * @return ����ʱ��                
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ����ʱ��                �趨
	 *
	 * @param eiupdtime ����ʱ��                
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �ʲ�״̬                ȡ��
	 *
	 * @return �ʲ�״̬                
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ʲ�״̬                �趨
	 *
	 * @param eistatus �ʲ�״̬                
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �汾                    ȡ��
	 *
	 * @return �汾                    
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * �汾                    �趨
	 *
	 * @param eiversion �汾                    
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0118VWPK(id, eiid);
	}

}