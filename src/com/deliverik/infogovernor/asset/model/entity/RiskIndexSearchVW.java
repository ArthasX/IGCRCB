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
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
  * ����: ����ָ���ѯʵ��
  * ��������: ����ָ���ѯʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskIndexSearchVW")
public class RiskIndexSearchVW extends BaseEntity implements Serializable,
		Cloneable, RiskIndexSearchVWInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKINDEXSEARCHVW_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKINDEXSEARCHVW_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKINDEXSEARCHVW_TABLE_GENERATOR")
	protected Integer eiid;

	/** ���β��� */
	protected String dutydepartment;

	/**  */
	protected String esyscoding;

	/** ָ���� */
	protected String einame;

	/** �Ǽ����� */
	protected String eiinsdate;

	/** ��� */
	protected String eilabel;

	/** �������� */
	protected String eiupdtime;

	/** С�汾 */
	protected String eismallversion;

	/** ��ֵ */
	protected String zbfz;

	/** ״̬ */
	protected String eistatus;

	/** �Ǽ���ID */
	protected String eiuserid;

	/** �Ǽ������� */
	protected String eiusername;

	/** eid */
	protected String eid;

	/**  */
	protected String eirootmark;

	/** ������ID */
	protected String mguserid;

	/** ��; */
	protected String indexused;

	/** �Ƿ�ؼ�ָ�� */
	protected String keyindex;

	/** ָ��˵�� */
	protected String eidesc;

	/** ������ */
	protected String eiorgsyscoding;

	/** �汾�� */
	protected String eiversion;

	/** ������ */
	protected String dutyuser;

	/** �������� */
	protected String riskly;

	/** ������ */
	protected String riskarea;

	/** ������ */
	protected String riskitem;

	/** �������� */
	protected String mgusername;

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
	 * ���β���ȡ��
	 *
	 * @return ���β���
	 */
	public String getDutydepartment() {
		return dutydepartment;
	}

	/**
	 * ���β����趨
	 *
	 * @param dutydepartment ���β���
	 */
	public void setDutydepartment(String dutydepartment) {
		this.dutydepartment = dutydepartment;
	}

	/**
	 * ȡ��
	 *
	 * @return 
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �趨
	 *
	 * @param esyscoding 
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ָ����ȡ��
	 *
	 * @return ָ����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ָ�����趨
	 *
	 * @param einame ָ����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �Ǽ�����ȡ��
	 *
	 * @return �Ǽ�����
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �Ǽ������趨
	 *
	 * @param eiinsdate �Ǽ�����
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ����趨
	 *
	 * @param eilabel ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * ���������趨
	 *
	 * @param eiupdtime ��������
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public String getEismallversion() {
		return eismallversion;
	}

	/**
	 * С�汾�趨
	 *
	 * @param eismallversion С�汾
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getZbfz() {
		return zbfz;
	}

	/**
	 * ��ֵ�趨
	 *
	 * @param zbfz ��ֵ
	 */
	public void setZbfz(String zbfz) {
		this.zbfz = zbfz;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param eistatus ״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �Ǽ���IDȡ��
	 *
	 * @return �Ǽ���ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * �Ǽ���ID�趨
	 *
	 * @param eiuserid �Ǽ���ID
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * �Ǽ�������ȡ��
	 *
	 * @return �Ǽ�������
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * �Ǽ��������趨
	 *
	 * @param eiusername �Ǽ�������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
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
	 * ȡ��
	 *
	 * @return 
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * �趨
	 *
	 * @param eirootmark 
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param mguserid ������ID
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * ��;ȡ��
	 *
	 * @return ��;
	 */
	public String getIndexused() {
		return indexused;
	}

	/**
	 * ��;�趨
	 *
	 * @param indexused ��;
	 */
	public void setIndexused(String indexused) {
		this.indexused = indexused;
	}

	/**
	 * �Ƿ�ؼ�ָ��ȡ��
	 *
	 * @return �Ƿ�ؼ�ָ��
	 */
	public String getKeyindex() {
		return keyindex;
	}

	/**
	 * �Ƿ�ؼ�ָ���趨
	 *
	 * @param keyindex �Ƿ�ؼ�ָ��
	 */
	public void setKeyindex(String keyindex) {
		this.keyindex = keyindex;
	}

	/**
	 * ָ��˵��ȡ��
	 *
	 * @return ָ��˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ָ��˵���趨
	 *
	 * @param eidesc ָ��˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * �������趨
	 *
	 * @param eiorgsyscoding ������
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * �汾��ȡ��
	 *
	 * @return �汾��
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * �汾���趨
	 *
	 * @param eiversion �汾��
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDutyuser() {
		return dutyuser;
	}

	/**
	 * �������趨
	 *
	 * @param dutyuser ������
	 */
	public void setDutyuser(String dutyuser) {
		this.dutyuser = dutyuser;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * ���������趨
	 *
	 * @param riskly ��������
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * �������趨
	 *
	 * @param riskarea ������
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * �������趨
	 *
	 * @param riskitem ������
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMgusername() {
		return mgusername;
	}

	/**
	 * ���������趨
	 *
	 * @param mgusername ��������
	 */
	public void setMgusername(String mgusername) {
		this.mgusername = mgusername;
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