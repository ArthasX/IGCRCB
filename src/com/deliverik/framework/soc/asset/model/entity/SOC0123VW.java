/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.soc.asset.model.SOC0123Info;

/**
  * ����: �ʲ�ģ����ͼʵ��
  * ��������: �ʲ�ģ����ͼʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name="SOC0123")
public class SOC0123VW implements Serializable,
		Cloneable, SOC0123Info {

	/** �ʲ�ID */
	@Id
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected String eid;

	/** �ʲ����� */
	protected String einame;

	/** �ʲ���� */
	protected String eilabel;

	/** �ʲ�˵�� */
	protected String eidesc;

	/** �ʲ�����ʱ�� */
	protected String eiupdtime;

	/** �ʲ�״̬ */
	protected String eistatus;

	/** �ʲ��汾 */
	protected Integer eiversion;

	/** �ʲ��Ǽ�ʱ�� */
	protected String eiinsdate;

	/** �ʲ�������������� */
	protected String eiorgsyscoding;

	/** �ʲ�����ģ�Ͳ���� */
	protected String esyscoding;

	/** �ʲ�������ID */
	protected String eiuserid;

	/** �ʲ����������� */
	protected String eiusername;

	/** �ʲ�ģ������ */
	protected String ename;

	/** ģ�ͱ�ʶ */
	protected String elabel;

	/** ģ�ͷ��� */
	protected String ecategory;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	protected Integer eirootmark;

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid�ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid�ʲ�ģ��ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 *
	 * @param einame�ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ����ȡ��
	 *
	 * @return �ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����趨
	 *
	 * @param eilabel�ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�˵��ȡ��
	 *
	 * @return �ʲ�˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �ʲ�˵���趨
	 *
	 * @param eidesc�ʲ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �ʲ�����ʱ��ȡ��
	 *
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �ʲ�����ʱ���趨
	 *
	 * @param eiupdtime�ʲ�����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �ʲ�״̬ȡ��
	 *
	 * @return �ʲ�״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �ʲ�״̬�趨
	 *
	 * @param eistatus�ʲ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �ʲ��汾ȡ��
	 *
	 * @return �ʲ��汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾�趨
	 *
	 * @param eiversion�ʲ��汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ʲ��Ǽ�ʱ��ȡ��
	 *
	 * @return �ʲ��Ǽ�ʱ��
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �ʲ��Ǽ�ʱ���趨
	 *
	 * @param eiinsdate�ʲ��Ǽ�ʱ��
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * �ʲ��������������ȡ��
	 *
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �ʲ���������������趨
	 *
	 * @param eiorgsyscoding�ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�����ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�����ģ�Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�����ģ�Ͳ�����趨
	 *
	 * @param esyscoding�ʲ�����ģ�Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * �ʲ�������IDȡ��
	 *
	 * @return �ʲ�������ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �ʲ�������ID�趨
	 *
	 * @param eiuserid�ʲ�������ID
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * �ʲ�����������ȡ��
	 *
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername�ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * �ʲ�ģ������ȡ��
	 *
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename�ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * ģ�ͱ�ʶȡ��
	 *
	 * @return ģ�ͱ�ʶ
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * ģ�ͱ�ʶ�趨
	 *
	 * @param elabelģ�ͱ�ʶ
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * ģ�ͷ���ȡ��
	 *
	 * @return ģ�ͷ���
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * ģ�ͷ����趨
	 *
	 * @param ecategoryģ�ͷ���
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	public Integer getEirootmark() {
		return eirootmark;
	}

	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

}