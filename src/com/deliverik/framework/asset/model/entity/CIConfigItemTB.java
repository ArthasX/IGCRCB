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

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: CI����ʲ����Ա�ʵ��
  * ��������: CI����ʲ����Ա�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CIConfigItem")
public class CIConfigItemTB extends BaseEntity implements Serializable,
		Cloneable, CIConfigItemInfo {

	/** �ʲ�����ID */
	@Id
	@TableGenerator(
		name="CICONFIGITEM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CICONFIGITEM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CICONFIGITEM_TABLE_GENERATOR")
	protected Integer ciid;

	/** �ʲ�ģ������ID */
	protected Integer cid;

	/** �ʲ�ID */
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected Integer eid;

	/** �ʲ�����ֵ */
	protected String civalue;

	/** �ʲ����Ը���ʱ�� */
	protected String ciupdtime;

	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;

	/** �ʲ�����ʧЧʱ�� */
	protected String ciexpire;

	/** �ʲ�����״̬ */
	protected String cistatus;

	/** �ʲ����Ե�ǰ�汾�� */
	protected String cicurver;

	/** �ʲ����԰汾��Ϣ */
	protected String civerinfo;
	
	/** ��汾 */
	protected Integer civersion;
	
	/** С�汾 */
	protected Integer cismallversion;

	/**
	 * �ʲ�����IDȡ��
	 *
	 * @return �ʲ�����ID
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * �ʲ�����ID�趨
	 *
	 * @param ciid �ʲ�����ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * �ʲ�ģ������IDȡ��
	 *
	 * @return �ʲ�ģ������ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID�趨
	 *
	 * @param cid �ʲ�ģ������ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
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
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�����ֵȡ��
	 *
	 * @return �ʲ�����ֵ
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * �ʲ�����ֵ�趨
	 *
	 * @param civalue �ʲ�����ֵ
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 *
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime() {
		return ciupdtime;
	}

	/**
	 * �ʲ����Ը���ʱ���趨
	 *
	 * @param ciupdtime �ʲ����Ը���ʱ��
	 */
	public void setCiupdtime(String ciupdtime) {
		this.ciupdtime = ciupdtime;
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
	 * �ʲ�����ʧЧʱ��ȡ��
	 *
	 * @return �ʲ�����ʧЧʱ��
	 */
	public String getCiexpire() {
		return ciexpire;
	}

	/**
	 * �ʲ�����ʧЧʱ���趨
	 *
	 * @param ciexpire �ʲ�����ʧЧʱ��
	 */
	public void setCiexpire(String ciexpire) {
		this.ciexpire = ciexpire;
	}

	/**
	 * �ʲ�����״̬ȡ��
	 *
	 * @return �ʲ�����״̬
	 */
	public String getCistatus() {
		return cistatus;
	}

	/**
	 * �ʲ�����״̬�趨
	 *
	 * @param cistatus �ʲ�����״̬
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
	}

	/**
	 * �ʲ����Ե�ǰ�汾��ȡ��
	 *
	 * @return �ʲ����Ե�ǰ�汾��
	 */
	public String getCicurver() {
		return cicurver;
	}

	/**
	 * �ʲ����Ե�ǰ�汾���趨
	 *
	 * @param cicurver �ʲ����Ե�ǰ�汾��
	 */
	public void setCicurver(String cicurver) {
		this.cicurver = cicurver;
	}

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 *
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo() {
		return civerinfo;
	}

	/**
	 * �ʲ����԰汾��Ϣ�趨
	 *
	 * @param civerinfo �ʲ����԰汾��Ϣ
	 */
	public void setCiverinfo(String civerinfo) {
		this.civerinfo = civerinfo;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ciid;
	}

	/**
	 * ��汾ȡ��
	 * @return ��汾
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * ��汾�趨
	 * @param civersion ��汾
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * С�汾ȡ��
	 * @return С�汾
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * С�汾�趨
	 * @param cismallversion С�汾
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}

}