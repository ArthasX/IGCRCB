/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: CI����ԱȽ����Ϣ��ʵ��
  * ��������: CI����ԱȽ����Ϣ��ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CIResult")
public class CIResultTB extends BaseEntity implements Serializable,
		Cloneable, CIResultInfo {

	/** CI����ԱȽ�� */
	@Id
	@TableGenerator(
		name="CIRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CIRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CIRESULT_TABLE_GENERATOR")
	protected Integer cirid;

	/** CI�������ID */
	protected Integer citid;

	/** CI���ʱ��� */
	protected String citime;

	/** �ԱȽ������ */
	protected String cicmptype;

	/** �ʲ�ID */
	protected Integer eiid;

	/** ��汾 */
	protected Integer eiversion;

	/** С�汾 */
	protected Integer eismallversion;

	/** �ʲ����� */
	protected String einame;

	/** ����CI��ʶ */
	protected Integer eirootmark;

	/** ����ID */
	protected Integer ciid;

	/** ������ */
	protected String cname;

	/** ��ǰ�汾ֵ */
	protected String civalue;

	/** �ɼ�ֵ */
	protected String auvalue;

	/** �����ʶ */
	protected String ciflag;

	/** CI������˵�� */
	protected String ciresultdesc;
	
	/** �ʲ������ */
	protected String esyscoding;

	/**
	 * CI����ԱȽ��ȡ��
	 *
	 * @return CI����ԱȽ��
	 */
	public Integer getCirid() {
		return cirid;
	}

	/**
	 * CI����ԱȽ���趨
	 *
	 * @param cirid CI����ԱȽ��
	 */
	public void setCirid(Integer cirid) {
		this.cirid = cirid;
	}

	/**
	 * CI�������IDȡ��
	 *
	 * @return CI�������ID
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * CI�������ID�趨
	 *
	 * @param citid CI�������ID
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI���ʱ���ȡ��
	 *
	 * @return CI���ʱ���
	 */
	public String getCitime() {
		return citime;
	}

	/**
	 * CI���ʱ����趨
	 *
	 * @param citime CI���ʱ���
	 */
	public void setCitime(String citime) {
		this.citime = citime;
	}

	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getCicmptype() {
		return cicmptype;
	}

	/**
	 * �ԱȽ�������趨
	 *
	 * @param cicmptype �ԱȽ������
	 */
	public void setCicmptype(String cicmptype) {
		this.cicmptype = cicmptype;
	}

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
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * ����CI��ʶȡ��
	 *
	 * @return ����CI��ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * ����CI��ʶ�趨
	 *
	 * @param eirootmark ����CI��ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param ciid ����ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * �������趨
	 *
	 * @param cname ������
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * ��ǰ�汾ֵȡ��
	 *
	 * @return ��ǰ�汾ֵ
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * ��ǰ�汾ֵ�趨
	 *
	 * @param civalue ��ǰ�汾ֵ
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ɼ�ֵȡ��
	 *
	 * @return �ɼ�ֵ
	 */
	public String getAuvalue() {
		return auvalue;
	}

	/**
	 * �ɼ�ֵ�趨
	 *
	 * @param civalue �ɼ�ֵ
	 */
	public void setAuvalue(String auvalue) {
		this.auvalue = auvalue;
	}

	/**
	 * �����ʶȡ��
	 *
	 * @return �����ʶ
	 */
	public String getCiflag() {
		return ciflag;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param ciflag �����ʶ
	 */
	public void setCiflag(String ciflag) {
		this.ciflag = ciflag;
	}

	/**
	 * CI������˵��ȡ��
	 *
	 * @return CI������˵��
	 */
	public String getCiresultdesc() {
		return ciresultdesc;
	}

	/**
	 * CI������˵���趨
	 *
	 * @param ciresultdesc CI������˵��
	 */
	public void setCiresultdesc(String ciresultdesc) {
		this.ciresultdesc = ciresultdesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cirid;
	}

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ�������趨
	 * @param esyscoding �ʲ������
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}