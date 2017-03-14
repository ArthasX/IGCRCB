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
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;

/**
  * ����: SOC0109VWʵ��
  * ��������: SOC0109VWʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0109VWPK.class)
@Table(name="SOC0109VW")
public class SOC0109VW extends BaseEntity implements Serializable,
		Cloneable, SOC0109VWInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** �ʲ�ģ������ID                            */
	@Id
	protected String cid;

	/** �ʲ�ģ��ID�������                        */
	protected String eid;

	/** �ʲ�ģ����������                          */
	protected String cname;

	/** CLABEL                                    */
	protected String clabel;

	/** �ʲ�ģ������˵��                          */
	protected String cdesc;

	/** �ʲ�ģ�����Ե�λ                          */
	protected String cunit;

	/** �ʲ�ģ������״̬                          */
	protected String cstatus;

	/** �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ? */
	protected String cseq;

	/** �ʲ�ģ����������ģ�͵�ģ�ͷ���            */
	protected String ccategory;

	/** �ʲ�ģ������ȡֵ��ΧID                    */
	protected String coption;

	/** �ʲ�ģ��������������                      */
	protected String cattach;

	/** �ʲ�ģ����������ģ�Ͳ����                */
	protected String esyscoding;
	/** �ʲ�ģ�����Ա����� */
	protected String crequired;
	
	/** �����ʶ */
	protected Integer corder;
	
	/**
	 * @return the crequired
	 */
	public String getCrequired() {
		return crequired;
	}

	/**
	 * @param crequired the crequired to set
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	/**
	 * @return the corder
	 */
	public Integer getCorder() {
		return corder;
	}

	/**
	 * @param corder the corder to set
	 */
	public void setCorder(Integer corder) {
		this.corder = corder;
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
	 * �ʲ�ģ������ID                           ȡ��
	 *
	 * @return �ʲ�ģ������ID                           
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID                           �趨
	 *
	 * @param cid �ʲ�ģ������ID                           
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * �ʲ�ģ��ID�������                       ȡ��
	 *
	 * @return �ʲ�ģ��ID�������                       
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�������                       �趨
	 *
	 * @param eid �ʲ�ģ��ID�������                       
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ����������                         ȡ��
	 *
	 * @return �ʲ�ģ����������                         
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �ʲ�ģ����������                         �趨
	 *
	 * @param cname �ʲ�ģ����������                         
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * CLABEL                                   ȡ��
	 *
	 * @return CLABEL                                   
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * CLABEL                                   �趨
	 *
	 * @param clabel CLABEL                                   
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * �ʲ�ģ������˵��                         ȡ��
	 *
	 * @return �ʲ�ģ������˵��                         
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * �ʲ�ģ������˵��                         �趨
	 *
	 * @param cdesc �ʲ�ģ������˵��                         
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * �ʲ�ģ�����Ե�λ                         ȡ��
	 *
	 * @return �ʲ�ģ�����Ե�λ                         
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * �ʲ�ģ�����Ե�λ                         �趨
	 *
	 * @param cunit �ʲ�ģ�����Ե�λ                         
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * �ʲ�ģ������״̬                         ȡ��
	 *
	 * @return �ʲ�ģ������״̬                         
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * �ʲ�ģ������״̬                         �趨
	 *
	 * @param cstatus �ʲ�ģ������״̬                         
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?ȡ��
	 *
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?
	 */
	public String getCseq() {
		return cseq;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?�趨
	 *
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ?
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * �ʲ�ģ����������ģ�͵�ģ�ͷ���           ȡ��
	 *
	 * @return �ʲ�ģ����������ģ�͵�ģ�ͷ���           
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * �ʲ�ģ����������ģ�͵�ģ�ͷ���           �趨
	 *
	 * @param ccategory �ʲ�ģ����������ģ�͵�ģ�ͷ���           
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧID                   ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��ΧID                   
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧID                   �趨
	 *
	 * @param coption �ʲ�ģ������ȡֵ��ΧID                   
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * �ʲ�ģ��������������                     ȡ��
	 *
	 * @return �ʲ�ģ��������������                     
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * �ʲ�ģ��������������                     �趨
	 *
	 * @param cattach �ʲ�ģ��������������                     
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * �ʲ�ģ����������ģ�Ͳ����               ȡ��
	 *
	 * @return �ʲ�ģ����������ģ�Ͳ����               
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ����������ģ�Ͳ����               �趨
	 *
	 * @param esyscoding �ʲ�ģ����������ģ�Ͳ����               
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0109VWPK(id, cid);
	}

}