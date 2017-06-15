package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0109Info;


/**
 * �ʲ�ģ��������Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SOC0109")
public class SOC0109TB extends BaseEntity implements Serializable, Cloneable, SOC0109Info {

	/** �ʲ�ģ������ID */
	@Id
	protected String cid;
	
	/** �ʲ�ģ��ID������� */
	protected String eid;
	
	/** �ʲ�ģ���������� */
	protected String cname;

	/** �ʲ�ģ������˵�� */
	protected String cdesc;
	
	/** �ʲ�ģ�����Ե�λ */
	protected String cunit;

	/** �ʲ�ģ������״̬ */
	protected String cstatus;
	
	/** �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ�� */
	protected Integer cseq;
	
	/** �ʲ�ģ����������ģ�͵�ģ�ͷ��� */
	protected String ccategory;
	
	/** �ʲ�ģ������ȡֵ��ΧID */
	protected String coption;
	
	/** �ʲ�ģ�����Ա�� */
	protected String clabel;

	/** �ʲ�ģ�������������� */
	protected String cattach;
	
	/** �ʲ�ģ����������ģ�Ͳ���� */
	public String esyscoding;
	
	/** �ʲ�ģ�����Ա����� */
	protected String crequired;
	
	/** �����ʶ */
	protected Integer corder;

	/**
	 * �ʲ�ģ����������ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ����������ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�ģ����������ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ����������ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return cid;
	}

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param cname �ʲ�ģ����������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * �ʲ�ģ������˵��ȡ��
	 * @return �ʲ�ģ������˵��
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * �ʲ�ģ������˵���趨
	 *
	 * @param cdesc �ʲ�ģ������˵��
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * �ʲ�ģ�����Ե�λȡ��
	 * @return �ʲ�ģ�����Ե�λ
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * �ʲ�ģ�����Ե�λ�趨
	 *
	 * @param cunit �ʲ�ģ�����Ե�λ
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * �ʲ�ģ�����Է���ȡ��
	 * @return �ʲ�ģ�����Է���
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * �ʲ�ģ�����Է����趨
	 *
	 * @param ccategory �ʲ�ģ�����Է���
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * �ʲ�ģ������״̬�趨
	 *
	 * @param cstatus �ʲ�ģ������״̬
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public Integer getCseq() {
		return cseq;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ�趨
	 *
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧIDȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧID
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧID�趨
	 *
	 * @param coption �ʲ�ģ������ȡֵ��ΧID
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * �ʲ�ģ�����Ա���趨
	 *
	 * @param clabel �ʲ�ģ�����Ա��
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * �ʲ�ģ��������������ȡ��
	 * @return �ʲ�ģ��������������
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * �ʲ�ģ���������������趨
	 *
	 * @param cattach �ʲ�ģ��������������
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * �ʲ�ģ�����Ա�����ȡ��
	 * @return �ʲ�ģ�����Ա�����
	 */
	public String getCrequired() {
		return crequired;
	}

	/**
	 * �ʲ�ģ�����Ա������趨
	 *
	 * @param crequired �ʲ�ģ�����Ա�����
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}

	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public Integer getCorder() {
		return corder;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param corder �����ʶ
	 */
	public void setCorder(Integer corder) {
		this.corder = corder;
	}
	
}
