/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: ʵ����·ͼʵ��
  * ��������: ʵ����·ͼʵ��
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(EiLinkMapPK.class)
@Table(name="EiLinkMap")
public class EiLinkMapTB extends BaseEntity implements Serializable,
		Cloneable, EiLinkMapInfo {

	/** ��ID */
	@Id
	protected Integer domainid;

	/** Domain�汾 */
	@Id
	protected Integer domainversion;

	/** ��·ID */
	@Id
	protected Integer linkid;

	/** ��·˳�� */
	@Id
	protected Integer linkorder;

	/** ʵ��id */
	protected Integer eiid;

	/** ʵ���� */
	protected String einame;

	/** �ʲ������ */
	protected String esyscoding;

	/** ��汾 */
	protected Integer eiversion;

	/** С�汾 */
	protected Integer eismallversion;
	
	/** ��ͼ��� */
	protected String linkflag;
	
	/** ����ʱ�� */
	protected String createtime;
	
	/** ��·������ʶ */
	protected String endflag;
	
	/**
	 * ��ͼ���ȡ��
	 *
	 * @return ��ͼ���
	 */
	public String getLinkflag() {
		return linkflag;
	}
	
	/**
	 * ��ͼ����趨
	 *
	 * @param linkflag ��ͼ���
	 */
	public void setLinkflag(String linkflag) {
		this.linkflag = linkflag;
	}

	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public Integer getDomainid() {
		return domainid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param domainid ��ID
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getDomainversion() {
		return domainversion;
	}

	/**
	 * Domain�汾�趨
	 *
	 * @param domainversion Domain�汾
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	/**
	 * ��·IDȡ��
	 *
	 * @return ��·ID
	 */
	public Integer getLinkid() {
		return linkid;
	}

	/**
	 * ��·ID�趨
	 *
	 * @param linkid ��·ID
	 */
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}

	/**
	 * ��·˳��ȡ��
	 *
	 * @return ��·˳��
	 */
	public Integer getLinkorder() {
		return linkorder;
	}

	/**
	 * ��·˳���趨
	 *
	 * @param linkorder ��·˳��
	 */
	public void setLinkorder(Integer linkorder) {
		this.linkorder = linkorder;
	}

	/**
	 * ʵ��idȡ��
	 *
	 * @return ʵ��id
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ʵ��id�趨
	 *
	 * @param eiid ʵ��id
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ʵ�����趨
	 *
	 * @param einame ʵ����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ������ȡ��
	 *
	 * @return �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������趨
	 *
	 * @param esyscoding �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ��汾�趨
	 *
	 * @param eiversion ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * С�汾�趨
	 *
	 * @param eismallversion С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	
	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param createtime ����ʱ��
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	/**
	 * ��·������ʶȡ��
	 *
	 * @return ��·������ʶ
	 */
	public String getEndflag() {
		return endflag;
	}

	/**
	 * ��·������ʶ�趨
	 *
	 * @param endflag ��·������ʶ
	 */
	public void setEndflag(String endflag) {
		this.endflag = endflag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new EiLinkMapPK(domainid, domainversion, linkid, linkorder);
	}

}