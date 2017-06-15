/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
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

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: ��ƶԱȽ����Ϣ��ʵ��
  * ��������: ��ƶԱȽ����Ϣ��ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AuditResult")
public class AuditResultTB extends BaseEntity implements Serializable,
		Cloneable, AuditResultInfo {

	/** ��ƶԱȽ�� */
	@Id
	@TableGenerator(
		name="AUDITRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="AUDITRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITRESULT_TABLE_GENERATOR")
	protected Integer aurid;

	/** �������ID */
	protected Integer autid;

	/** ���ʱ��� */
	protected String autime;

	/** �ԱȽ������ */
	protected String aucmptype;

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
	protected String auflag;

	/** ��ƽ��˵�� */
	protected String auresultdesc;
	
	/** �ʲ������ */
	protected String esyscoding;
	
	
	/** ģ��ʵ�� */
	@ManyToOne
	@JoinColumn(name="esyscoding", referencedColumnName="esyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG117TB entityTB;

	/**
	 * ��ƶԱȽ��ȡ��
	 *
	 * @return ��ƶԱȽ��
	 */
	public Integer getAurid() {
		return aurid;
	}

	/**
	 * ��ƶԱȽ���趨
	 *
	 * @param aurid ��ƶԱȽ��
	 */
	public void setAurid(Integer aurid) {
		this.aurid = aurid;
	}

	/**
	 * �������IDȡ��
	 *
	 * @return �������ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �������ID�趨
	 *
	 * @param autid �������ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAutime() {
		return autime;
	}

	/**
	 * ���ʱ����趨
	 *
	 * @param autime ���ʱ���
	 */
	public void setAutime(String autime) {
		this.autime = autime;
	}

	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getAucmptype() {
		return aucmptype;
	}

	/**
	 * �ԱȽ�������趨
	 *
	 * @param aucmptype �ԱȽ������
	 */
	public void setAucmptype(String aucmptype) {
		this.aucmptype = aucmptype;
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
	 * @param auvalue �ɼ�ֵ
	 */
	public void setAuvalue(String auvalue) {
		this.auvalue = auvalue;
	}

	/**
	 * �����ʶȡ��
	 *
	 * @return �����ʶ
	 */
	public String getAuflag() {
		return auflag;
	}

	/**
	 * �����ʶ�趨
	 *
	 * @param auflag �����ʶ
	 */
	public void setAuflag(String auflag) {
		this.auflag = auflag;
	}

	/**
	 * ��ƽ��˵��ȡ��
	 *
	 * @return ��ƽ��˵��
	 */
	public String getAuresultdesc() {
		return auresultdesc;
	}

	/**
	 * ��ƽ��˵���趨
	 *
	 * @param auresultdesc ��ƽ��˵��
	 */
	public void setAuresultdesc(String auresultdesc) {
		this.auresultdesc = auresultdesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return aurid;
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

	/**
	 * ģ��ʵ��ȡ��
	 * @return ģ��ʵ��
	 */
	public IG117TB getEntityTB() {
		return entityTB;
	}

}