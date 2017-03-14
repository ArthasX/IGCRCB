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

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * ����: ����������ϵ��ʵ��
  * ��������: ����������ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="EiBelongRelation")
public class EiBelongRelationTB extends BaseEntity implements Serializable,
		Cloneable, EiBelongRelationInfo,LogicalDelete {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="BELONGRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="BELONGRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="BELONGRELATION_TABLE_GENERATOR")
	protected Integer brid;

	/** Դ�ʲ�ID */
	protected Integer brpareiid;

	/** Դ�ʲ���汾 */
	protected Integer brparversion;

	/** Դ�ʲ�С�汾 */
	protected Integer brparsmallversion;

	/** Ŀ���ʲ�ID */
	protected Integer brcldeiid;

	/** Ŀ���ʲ���汾 */
	protected Integer brcldversion;

	/** Ŀ���ʲ�С�汾 */
	protected Integer brcldsmallversion;

	/** ��ϵ���ͣ�����/�߼��� */
	protected String brtype;

	/** ��ϵ˵�� */
	protected String brdes;

	/** ����ʱ�� */
	protected String brcreatetime;

	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** ������ϵ�� */
	protected String brraletioncode;

	/** �ʲ���ϵ�� */
	protected String brassetrelation;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;
	
	/** Դ�ʲ���Ϣ */
	@ManyToOne
	@JoinColumn(name="brpareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW parEntityItemVW;

	/** Ŀ���ʲ���Ϣ */
	@ManyToOne
	@JoinColumn(name="brcldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW cldEntityItemVW;
	/**
	 * ������ϵ��ȡ��
	 *
	 * @return ������ϵ��
	 */
	public String getBrraletioncode() {
		return brraletioncode;
	}
	/**
	 * ������ϵ���趨
	 *
	 * @param extraletioncode������ϵ��
	 */
	public void setBrraletioncode(String brraletioncode) {
		this.brraletioncode = brraletioncode;
	}
	/**
	 * �ʲ���ϵ��ȡ��
	 *
	 * @return �ʲ���ϵ��
	 */
	public String getBrassetrelation() {
		return brassetrelation;
	}
	/**
	 * �ʲ���ϵ���趨
	 *
	 * @param extassetrelation�ʲ���ϵ��
	 */
	public void setBrassetrelation(String brassetrelation) {
		this.brassetrelation = brassetrelation;
	}
	/**
	 * Դ�ʲ�ȡ��
	 *
	 * @return Դ�ʲ�
	 */
	public IG749VW getParEntityItemVW() {
		return parEntityItemVW;
	}
	/**
	 * Դ�ʲ��趨
	 *
	 * @param parEntityItemVW Դ�ʲ�
	 */
	public void setParEntityItemVW(IG749VW parEntityItemVW) {
		this.parEntityItemVW = parEntityItemVW;
	}
	
	/**
	 * Ŀ���ʲ�ȡ��
	 *
	 * @return Ŀ���ʲ�
	 */
	public IG749VW getCldEntityItemVW() {
		return cldEntityItemVW;
	}
	/**
	 * Ŀ���ʲ��趨
	 *
	 * @param cldEntityItemVW Ŀ���ʲ�
	 */
	public void setCldEntityItemVW(IG749VW cldEntityItemVW) {
		this.cldEntityItemVW = cldEntityItemVW;
	}

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getBrid() {
		return brid;
	}

	/**
	 * �߼������趨
	 *
	 * @param brid�߼�����
	 */
	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public Integer getBrpareiid() {
		return brpareiid;
	}

	/**
	 * Դ�ʲ�ID�趨
	 *
	 * @param brpareiidԴ�ʲ�ID
	 */
	public void setBrpareiid(Integer brpareiid) {
		this.brpareiid = brpareiid;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public Integer getBrparversion() {
		return brparversion;
	}

	/**
	 * Դ�ʲ���汾�趨
	 *
	 * @param brparversionԴ�ʲ���汾
	 */
	public void setBrparversion(Integer brparversion) {
		this.brparversion = brparversion;
	}

	/**
	 * Դ�ʲ�С�汾ȡ��
	 *
	 * @return Դ�ʲ�С�汾
	 */
	public Integer getBrparsmallversion() {
		return brparsmallversion;
	}

	/**
	 * Դ�ʲ�С�汾�趨
	 *
	 * @param brparsmallversionԴ�ʲ�С�汾
	 */
	public void setBrparsmallversion(Integer brparsmallversion) {
		this.brparsmallversion = brparsmallversion;
	}

	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public Integer getBrcldeiid() {
		return brcldeiid;
	}

	/**
	 * Ŀ���ʲ�ID�趨
	 *
	 * @param brcldeiidĿ���ʲ�ID
	 */
	public void setBrcldeiid(Integer brcldeiid) {
		this.brcldeiid = brcldeiid;
	}

	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public Integer getBrcldversion() {
		return brcldversion;
	}

	/**
	 * Ŀ���ʲ���汾�趨
	 *
	 * @param brcldversionĿ���ʲ���汾
	 */
	public void setBrcldversion(Integer brcldversion) {
		this.brcldversion = brcldversion;
	}

	/**
	 * Ŀ���ʲ�С�汾ȡ��
	 *
	 * @return Ŀ���ʲ�С�汾
	 */
	public Integer getBrcldsmallversion() {
		return brcldsmallversion;
	}

	/**
	 * Ŀ���ʲ�С�汾�趨
	 *
	 * @param brcldsmallversionĿ���ʲ�С�汾
	 */
	public void setBrcldsmallversion(Integer brcldsmallversion) {
		this.brcldsmallversion = brcldsmallversion;
	}

	/**
	 * ��ϵ���ͣ�����/�߼���ȡ��
	 *
	 * @return ��ϵ���ͣ�����/�߼���
	 */
	public String getBrtype() {
		return brtype;
	}

	/**
	 * ��ϵ���ͣ�����/�߼����趨
	 *
	 * @param brtype��ϵ���ͣ�����/�߼���
	 */
	public void setBrtype(String brtype) {
		this.brtype = brtype;
	}

	/**
	 * ��ϵ˵��ȡ��
	 *
	 * @return ��ϵ˵��
	 */
	public String getBrdes() {
		return brdes;
	}

	/**
	 * ��ϵ˵���趨
	 *
	 * @param brdes��ϵ˵��
	 */
	public void setBrdes(String brdes) {
		this.brdes = brdes;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getBrcreatetime() {
		return brcreatetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param brcreatetime����ʱ��
	 */
	public void setBrcreatetime(String brcreatetime) {
		this.brcreatetime = brcreatetime;
	}

	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param brdeleteflag�߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return brid;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

}