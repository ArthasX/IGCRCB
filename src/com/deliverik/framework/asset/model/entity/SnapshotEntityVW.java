/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * ����: ���չ�ϵ��ʵ��
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@Entity
public class SnapshotEntityVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/** �߼����� */
	@Id	
	protected Integer srid;

	/** DomainID */
	protected Integer srdomainid;

	/** ��չ�㷨���� */
	protected String srarithmetictype;

	/** Domain�汾 */
	protected Integer srdomainversion;

	/** Դ�ʲ�ID */
	protected Integer srpareiid;

	/** Դ�ʲ���汾 */
	protected Integer srparversion;

	/** Դ�ʲ�С�汾 */
	protected Integer srparsmallversion;
	
	/** Դ�ʲ�Einame */
	protected String srpareiname;

	/** Դ�ʲ�Eilabel */
	protected String srpareilabel;

	/** Ŀ���ʲ�ID */
	protected Integer srcldeiid;

	/** Ŀ���ʲ���汾 */
	protected Integer srcldversion;

	/** Ŀ���ʲ�С�汾 */
	protected Integer srcldsmallversion;
	
	/** Ŀ���ʲ�Einame */
	protected String srcldeiname;

	/** Ŀ���ʲ�Eilabel */
	protected String srcldeilabel;

	/** ����ʱ�� */
	protected String srcreatetime;

	/** �ʲ���ϵ�� */
	protected String srassetrelation;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
		
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
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getSrid() {
		return srid;
	}

	/**
	 * �߼������趨
	 *
	 * @param srid�߼�����
	 */
	public void setSrid(Integer srid) {
		this.srid = srid;
	}

	/**
	 * DomainIDȡ��
	 *
	 * @return DomainID
	 */
	public Integer getSrdomainid() {
		return srdomainid;
	}

	/**
	 * DomainID�趨
	 *
	 * @param srdomainidDomainID
	 */
	public void setSrdomainid(Integer srdomainid) {
		this.srdomainid = srdomainid;
	}

	/**
	 * ��չ�㷨����ȡ��
	 *
	 * @return ��չ�㷨����
	 */
	public String getSrarithmetictype() {
		return srarithmetictype;
	}

	/**
	 * ��չ�㷨�����趨
	 *
	 * @param srarithmetictype��չ�㷨����
	 */
	public void setSrarithmetictype(String srarithmetictype) {
		this.srarithmetictype = srarithmetictype;
	}

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getSrdomainversion() {
		return srdomainversion;
	}

	/**
	 * Domain�汾�趨
	 *
	 * @param srdomainversionDomain�汾
	 */
	public void setSrdomainversion(Integer srdomainversion) {
		this.srdomainversion = srdomainversion;
	}

	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public Integer getSrpareiid() {
		return srpareiid;
	}

	/**
	 * Դ�ʲ�ID�趨
	 *
	 * @param srpareiidԴ�ʲ�ID
	 */
	public void setSrpareiid(Integer srpareiid) {
		this.srpareiid = srpareiid;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public Integer getSrparversion() {
		return srparversion;
	}

	/**
	 * Դ�ʲ���汾�趨
	 *
	 * @param srparversionԴ�ʲ���汾
	 */
	public void setSrparversion(Integer srparversion) {
		this.srparversion = srparversion;
	}

	/**
	 * Դ�ʲ�С�汾ȡ��
	 *
	 * @return Դ�ʲ�С�汾
	 */
	public Integer getSrparsmallversion() {
		return srparsmallversion;
	}

	/**
	 * Դ�ʲ�С�汾�趨
	 *
	 * @param srparsmallversionԴ�ʲ�С�汾
	 */
	public void setSrparsmallversion(Integer srparsmallversion) {
		this.srparsmallversion = srparsmallversion;
	}

	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public Integer getSrcldeiid() {
		return srcldeiid;
	}

	/**
	 * Ŀ���ʲ�ID�趨
	 *
	 * @param srcldeiidĿ���ʲ�ID
	 */
	public void setSrcldeiid(Integer srcldeiid) {
		this.srcldeiid = srcldeiid;
	}

	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public Integer getSrcldversion() {
		return srcldversion;
	}

	/**
	 * Ŀ���ʲ���汾�趨
	 *
	 * @param srcldversionĿ���ʲ���汾
	 */
	public void setSrcldversion(Integer srcldversion) {
		this.srcldversion = srcldversion;
	}

	/**
	 * Ŀ���ʲ�С�汾ȡ��
	 *
	 * @return Ŀ���ʲ�С�汾
	 */
	public Integer getSrcldsmallversion() {
		return srcldsmallversion;
	}

	/**
	 * Ŀ���ʲ�С�汾�趨
	 *
	 * @param srcldsmallversionĿ���ʲ�С�汾
	 */
	public void setSrcldsmallversion(Integer srcldsmallversion) {
		this.srcldsmallversion = srcldsmallversion;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSrcreatetime() {
		return srcreatetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param srcreatetime����ʱ��
	 */
	public void setSrcreatetime(String srcreatetime) {
		this.srcreatetime = srcreatetime;
	}

	/**
	 * �ʲ���ϵ��ȡ��
	 *
	 * @return �ʲ���ϵ��
	 */
	public String getSrassetrelation() {
		return srassetrelation;
	}

	/**
	 * �ʲ���ϵ���趨
	 *
	 * @param srassetrelation�ʲ���ϵ��
	 */
	public void setSrassetrelation(String srassetrelation) {
		this.srassetrelation = srassetrelation;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return srid;
	}

	public String getSrpareiname() {
		return srpareiname;
	}

	public void setSrpareiname(String srpareiname) {
		this.srpareiname = srpareiname;
	}

	public String getSrpareilabel() {
		return srpareilabel;
	}

	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	public String getSrcldeiname() {
		return srcldeiname;
	}

	public void setSrcldeiname(String srcldeiname) {
		this.srcldeiname = srcldeiname;
	}

	public String getSrcldeilabel() {
		return srcldeilabel;
	}

	public void setSrcldeilabel(String srcldeilabel) {
		this.srcldeilabel = srcldeilabel;
	}
	
}