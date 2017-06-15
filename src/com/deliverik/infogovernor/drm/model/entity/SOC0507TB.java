package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLInsert;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.infogovernor.drm.model.SOC0507Info;


/**
 * </p>
 * �ʲ�������Ϣʵ��
 *</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SOC0507")
@SQLInsert(sql="insert into SOC0507 (fingerPrint, cicurver, cid, ciexpire, cismallversion, cistatus, ciupdtime, civalue, civerinfo, civersion, eid, eiid, esyscoding, ciid) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", check=ResultCheckStyle.NONE)

public class SOC0507TB extends BaseEntity implements Serializable, Cloneable, SOC0507Info {

	/** �ʲ�����ID */
	@Id
	@TableGenerator(
			name="SOC0507_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="SOC0507_SEQUENCE", initialValue=1, allocationSize=1
		)
		@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0507_TABLE_GENERATOR")
	protected Integer ciid;
	
	/** �ʲ�ID�������*/
	protected Integer eiid;
	
	/** �ʲ�ģ������ID�������*/
	protected String cid;
	
	/** �ʲ�ģ��ID*/
	protected String eid;
	
	/** �ʲ�����ֵ */
	protected String civalue;
	
	/** �ʲ����Ը���ʱ�� */
	protected String ciupdtime;
	
	/** �ʲ�����ʧЧʱ�� */
	protected String ciexpire;
	
	/** �ʲ�����״̬ */
	protected String cistatus;
	
	/** �ʲ����Ե�ǰ�汾�� */
	protected String cicurver;
	
	/** �ʲ����԰汾�� */
	protected Integer civersion;
	
	/** �ʲ����԰汾��Ϣ */
	protected String civerinfo;
	
	/** �ʲ�ģ�Ͳ���� */
	protected String esyscoding;
	
	/** �ʲ�����С�汾 */
	protected Integer cismallversion;

	/** �ʲ�ģ��������Ϣ */
	@ManyToOne
	@JoinColumn(name="cid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0109TB configuration;


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
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return ciid;
	}

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�������ID
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * �ʲ�����ID�趨
	 *
	 * @param ciid �ʲ�������ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ���ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 *
	 * @param eiid �ʲ���ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	 * �ʲ�����ֵȡ��
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
	 * �ʲ�����ʧЧʱ��ȡ��
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
	 * @return �ʲ�����״̬
	 */
	public String getCistatus() {
		return cistatus;
	}

	/**
	 * �ʲ�����״̬�趨
	 *
	 * @param eistatus �ʲ�����״̬
	 */
	public void setCistatus(String cistatus) {
		this.cistatus = cistatus;
	}

	/**
	 * �ʲ����Ե�ǰ�汾��ȡ��
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
	 * @return �ʲ����԰汾��
	 */
	public Integer getCiversion() {
		return civersion;
	}

	/**
	 * �ʲ����԰汾���趨
	 *
	 * @param civersion �ʲ����԰汾��
	 */
	public void setCiversion(Integer civersion) {
		this.civersion = civersion;
	}

	/**
	 * �ʲ����԰汾��Ϣȡ��
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
	 * �ʲ�ģ��������Ϣȡ��
	 * @return �ʲ�ģ��������Ϣ
	 */
	public SOC0109Info getConfiguration() {
	    return configuration;
	}
	
	/**
	 * �ʲ�����С�汾ȡ��
	 * @return �ʲ�����С�汾
	 */
	public Integer getCismallversion() {
		return cismallversion;
	}

	/**
	 * �ʲ�����С�汾�趨
	 *
	 * @param cismallversion �ʲ�����С�汾
	 */
	public void setCismallversion(Integer cismallversion) {
		this.cismallversion = cismallversion;
	}
	
}
