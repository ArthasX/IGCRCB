/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;

/**
  * ����: SOC0107VWʵ��
  * ��������: SOC0107VWʵ��
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0107VWPK.class)
@Table(name="SOC0107VW")
public class SOC0107VW extends BaseEntity implements Serializable,
		Cloneable, SOC0107VWInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** ���������� */
	@Id
	protected Integer ciid;

	/** �ʲ�ģ������ID������� */
	protected String cid;

	/** �ʲ�ID������� */
	protected Integer eiid;

	/** �ʲ�ģ��ID */
	protected String eid;

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

	/** �ʲ����԰汾�� */
	protected String civersion;

	/** �ʲ����԰汾��Ϣ */
	protected String civerinfo;
	
	/** �ʲ�����С�汾 */
	protected Integer cismallversion;
	
	
	/**
	 * @return the cismallversion
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * @param cismallversion the cismallversion to set
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
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
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * �����������趨
	 *
	 * @param ciid ����������
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * �ʲ�ģ������ID�������ȡ��
	 *
	 * @return �ʲ�ģ������ID�������
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID��������趨
	 *
	 * @param cid �ʲ�ģ������ID�������
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * �ʲ�ID�������ȡ��
	 *
	 * @return �ʲ�ID�������
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID��������趨
	 *
	 * @param eiid �ʲ�ID�������
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
	 * �ʲ����԰汾��ȡ��
	 *
	 * @return �ʲ����԰汾��
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * �ʲ����԰汾���趨
	 *
	 * @param civersion �ʲ����԰汾��
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
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
		return new SOC0107VWPK(id, ciid);
	}

	/** �ʲ�ģ��������Ϣ */
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id",referencedColumnName = "id",insertable = false, updatable = false),
		@JoinColumn(name="cid",referencedColumnName = "cid",insertable = false, updatable = false)
	})
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0109VW configuration;
	/**
	 * �ʲ�ģ��������Ϣȡ��
	 * @return �ʲ�ģ��������Ϣ
	 */
	public SOC0109VWInfo getConfiguration() {
	    return configuration;
	}
}