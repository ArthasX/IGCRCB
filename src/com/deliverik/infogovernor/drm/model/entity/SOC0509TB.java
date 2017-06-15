/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

/**
  * ����: Ԥ���½���Ϣʵ��
  * ��������: Ԥ���½���Ϣʵ��
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0509")
public class SOC0509TB extends BaseEntity implements Serializable,
		Cloneable, SOC0509Info {

	/** cid */
	@Id
	protected String cid;

	/** eid */
	protected String eid;

	/** pcid */
	protected String pcid;

	/** cname */
	protected String cname;

	/** clabel */
	protected String clabel;

	/** cdesc */
	protected String cdesc;

	/** cunit */
	protected String cunit;

	/** cstatus */
	protected String cstatus;

	/** �����㼶(��ʶ�������еĲ㼶) */
	protected Integer cseq;

	/** ccategory */
	protected String ccategory;

	/** coption */
	protected String coption;

	/** cattach */
	protected String cattach;

	/** esyscoding */
	protected String esyscoding;

	protected String corder;
	/**
	 * cidȡ��
	 *
	 * @return cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * cid�趨
	 *
	 * @param cid cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * eidȡ��
	 *
	 * @return eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid�趨
	 *
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * pcidȡ��
	 *
	 * @return pcid
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * pcid�趨
	 *
	 * @param pcid pcid
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * cnameȡ��
	 *
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * cname�趨
	 *
	 * @param cname cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * clabelȡ��
	 *
	 * @return clabel
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * clabel�趨
	 *
	 * @param clabel clabel
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * cdescȡ��
	 *
	 * @return cdesc
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * cdesc�趨
	 *
	 * @param cdesc cdesc
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * cunitȡ��
	 *
	 * @return cunit
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * cunit�趨
	 *
	 * @param cunit cunit
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * cstatusȡ��
	 *
	 * @return cstatus
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * cstatus�趨
	 *
	 * @param cstatus cstatus
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/** �����㼶(��ʶ�������еĲ㼶) */
	public Integer getCseq() {
		return cseq;
	}

	/** �����㼶(��ʶ�������еĲ㼶) */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}

	/**
	 * ccategoryȡ��
	 *
	 * @return ccategory
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * ccategory�趨
	 *
	 * @param ccategory ccategory
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * coptionȡ��
	 *
	 * @return coption
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * coption�趨
	 *
	 * @param coption coption
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * cattachȡ��
	 *
	 * @return cattach
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * cattach�趨
	 *
	 * @param cattach cattach
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * esyscodingȡ��
	 *
	 * @return esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * esyscoding�趨
	 *
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getCorder() {
		return corder;
	}

	public void setCorder(String corder) {
		this.corder = corder;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cid;
	}

}