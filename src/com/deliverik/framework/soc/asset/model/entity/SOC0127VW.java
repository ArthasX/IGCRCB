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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.soc.asset.model.SOC0127Info;

/**
  * ����: ����������ϵ��ͼ
  * ��������: ����������ϵ��ͼ
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0127PK.class)
public class SOC0127VW implements Serializable, Cloneable, SOC0127Info {

	/** Դ�ʲ�ID */
	@Id
	protected Integer brpareiid;

	/** Դ�ʲ���汾 */
	protected Integer brparversion;

	/** Դ�ʲ�С�汾 */
	protected Integer brparsmallversion;

	/** Ŀ���ʲ�ID */
	@Id
	protected Integer brcldeiid;

	/** Ŀ���ʲ���汾 */
	protected Integer brcldversion;

	/** Ŀ���ʲ�С�汾 */
	protected Integer brcldsmallversion;

	/** Դ�ʲ���Ϣ */
	@ManyToOne
	@JoinColumn(name="brpareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW parEntityItemVW;

	/** Ŀ���ʲ���Ϣ */
	@ManyToOne
	@JoinColumn(name="brcldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0123VW cldEntityItemVW;

	/**
	 * Դ�ʲ�ȡ��
	 *
	 * @return Դ�ʲ�
	 */
	public SOC0123VW getParEntityItemVW() {
		return parEntityItemVW;
	}
	/**
	 * Դ�ʲ��趨
	 *
	 * @param parEntityItemVW Դ�ʲ�
	 */
	public void setParEntityItemVW(SOC0123VW parEntityItemVW) {
		this.parEntityItemVW = parEntityItemVW;
	}
	
	/**
	 * Ŀ���ʲ�ȡ��
	 *
	 * @return Ŀ���ʲ�
	 */
	public SOC0123VW getCldEntityItemVW() {
		return cldEntityItemVW;
	}
	/**
	 * Ŀ���ʲ��趨
	 *
	 * @param cldEntityItemVW Ŀ���ʲ�
	 */
	public void setCldEntityItemVW(SOC0123VW cldEntityItemVW) {
		this.cldEntityItemVW = cldEntityItemVW;
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

}