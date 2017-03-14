/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

/**
  * ����: ������ѯʵ��
  * ��������: ������ѯʵ��
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CheckItemVW")
public class CheckItemVW extends BaseEntity implements Serializable,
		Cloneable, CheckItemVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="CHECKITEMVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CHECKITEMVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CHECKITEMVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected String eid;

	/** �ʲ����� */
	protected String einame;

	/** �ʲ�˵�� */
	protected String eidesc;

	/** �ʲ���� */
	protected String eilabel;

	/** �ʲ�����ʱ�� */
	protected String eiupdtime;

	/** �ʲ�״̬ */
	protected String eistatus;

	/** �ʲ��汾�� */
	protected Integer eiversion;

	/** �ʲ��Ǽ��� */
	protected String eiinsdate;

	/** �ʲ�������������� */
	protected String eiorgsyscoding;

	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;

	/** �ʲ������� */
	protected String eiuserid;

	/** �ʲ����������� */
	protected String eiusername;

	/** �ʲ�С�汾 */
	protected Integer eismallversion;

	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;

	/** �ʲ������� */
	protected String managername;

	/** ���ϵ��� */
	protected String datady;

	/** ��� */
	protected String bh;

	/** ��̸���� */
	protected String viewobj;

	/** ������������ */
	protected String riskly;

	/** ������������ */
	protected String riskarea;

	/** ���������� */
	protected String riskitem;
	
	/**������Ƶ��*/
	protected String checkfrequency;
	/**ʹ�÷�Χ*/
	protected String mgrange;
	/**������id*/
	protected String  mguserid;
	

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �����趨
	 *
	 * @param eiid ����
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
	 * @param eid �ʲ�ģ��ID
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
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
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
	 * @param eidesc �ʲ�˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
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
	 * @param eilabel �ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * @param eiupdtime �ʲ�����ʱ��
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
	 * @param eistatus �ʲ�״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �ʲ��汾��ȡ��
	 *
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ��汾���趨
	 *
	 * @param eiversion �ʲ��汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ʲ��Ǽ���ȡ��
	 *
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �ʲ��Ǽ����趨
	 *
	 * @param eiinsdate �ʲ��Ǽ���
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
	 * @param eiorgsyscoding �ʲ��������������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 *
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
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
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
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 *
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

	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 *
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * ������Ƶ���趨
	 * @param checkfrequency ������Ƶ��
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * ʹ�÷�Χȡ��
	 * @return mgrange ʹ�÷�Χ
	 */
	public String getMgrange() {
		return mgrange;
	}

	/**
	 * ʹ�÷�Χ�趨
	 * @param mgrange ʹ�÷�Χ
	 */
	public void setMgrange(String mgrange) {
		this.mgrange = mgrange;
	}

	/**
	 * ������idȡ��
	 * @return mguserid ������id
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * ������id�趨
	 * @param mguserid ������id
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * �ʲ�������ȡ��
	 *
	 * @return �ʲ�������
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param managername �ʲ�������
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * ���ϵ���ȡ��
	 *
	 * @return ���ϵ���
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * ���ϵ����趨
	 *
	 * @param datady ���ϵ���
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getBh() {
		return bh;
	}

	/**
	 * ����趨
	 *
	 * @param bh ���
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}

	/**
	 * ��̸����ȡ��
	 *
	 * @return ��̸����
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * ��̸�����趨
	 *
	 * @param viewobj ��̸����
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * �������������趨
	 *
	 * @param riskly ������������
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * �������������趨
	 *
	 * @param riskarea ������������
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * �����������趨
	 *
	 * @param riskitem ����������
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eiid;
	}

}