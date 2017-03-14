/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.asset.model.IG612Info;

/**
  * ����: �ʲ�ģ������ȱʡֵ��ͼ
  * ��������: �ʲ�ģ������ȱʡֵ��ͼ
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class IG612VW implements Serializable,
		Cloneable, IG612Info {

	/** �ʲ�ģ������ID */
	@Id
	protected String cid;
	
	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ�ģ���������� */
	protected String cname;
	
	/** �ʲ�ģ�����Ա�� */
	protected String clabel;

	/** �ʲ�ģ������˵�� */
	protected String cdesc;
	
	/** �ʲ�ģ�����Ե�λ */
	protected String cunit;
	
	/** �ʲ�ģ������״̬��1���ã�2ͣ�ã� */
	protected String cstatus;
	
	/** �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ��0����ʾ�� */
	protected String cseq;

	/** �ʲ�ģ���������� */
	protected String ccategory;
	
	/** �ʲ�ģ������ȡֵ��Χ */
	protected String coption;

	/** �ʲ�ģ�����Ը�����ʶ */
	protected String cattach;
	
	/** �ʲ�ģ�Ͳ����*/
	public String esyscoding;
	
	/** �ʲ�ģ�����Ա����� */
	protected String crequired;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;
	
	/** �ʲ�ģ������Ĭ��ֵ */
	protected String cvalue;
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	
	/**
	 * �ʲ�ģ�Ͳ�����趨
	 *
	 * @param esyscoding �ʲ�ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
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
	public String getCseq() {
		return cseq;
	}

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶ�趨
	 *
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ���������� 
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * �ʲ�ģ�����������趨
	 *
	 * @param ccategory �ʲ�ģ����������
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
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
	 * �ʲ�ģ������ȡֵ��Χȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ�趨
	 *
	 * @param coption �ʲ�ģ������ȡֵ��Χ
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * �ʲ�ģ�����Ը�����ʶȡ��
	 * @return �ʲ�ģ�����Ը�����ʶ
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * �ʲ�ģ�����Ը�����ʶ�趨
	 *
	 * @param cattach �ʲ�ģ�����Ը�����ʶ
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
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}
	
	/**
	 * ��¼ʱ����趨
	 *
	 * @param crequired ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * �ʲ�ģ������Ĭ��ֵȡ��
	 * @return �ʲ�ģ������Ĭ��ֵ
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * �ʲ�ģ������Ĭ��ֵ�趨
	 *
	 * @param cvalue �ʲ�ģ������Ĭ��ֵ
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	
}