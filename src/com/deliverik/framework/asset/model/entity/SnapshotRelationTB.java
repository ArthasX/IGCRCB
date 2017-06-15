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

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
  * ����: ���չ�ϵ��ʵ��
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SnapshotRelation")
public class SnapshotRelationTB extends BaseEntity implements Serializable,
		Cloneable, SnapshotRelationInfo,LogicalDelete  {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="SNAPSHOTRELATION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SNAPSHOTRELATION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SNAPSHOTRELATION_TABLE_GENERATOR")
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

	/** Ŀ���ʲ�ID */
	protected Integer srcldeiid;

	/** Ŀ���ʲ���汾 */
	protected Integer srcldversion;

	/** Ŀ���ʲ�С�汾 */
	protected Integer srcldsmallversion;

	/** ��ϵ���ͣ�����/�߼��� */
	protected String srtype;

	/** ��ϵ˵�� */
	protected String srdes;

	/** ����ʱ�� */
	protected String srcreatetime;

	/** ������ϵ�� */
	protected String srraletioncode;

	/** �ʲ���ϵ�� */
	protected String srassetrelation;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** �ʲ���������Ϣ */
	@ManyToOne
	@JoinColumn(name="srpareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW parEntityItemVW;

	/** �ʲ���������Ϣ */
	@ManyToOne
	@JoinColumn(name="srcldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW cldEntityItemVW;
	
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
	 * ��ϵ���ͣ�����/�߼���ȡ��
	 *
	 * @return ��ϵ���ͣ�����/�߼���
	 */
	public String getSrtype() {
		return srtype;
	}

	/**
	 * ��ϵ���ͣ�����/�߼����趨
	 *
	 * @param srtype��ϵ���ͣ�����/�߼���
	 */
	public void setSrtype(String srtype) {
		this.srtype = srtype;
	}

	/**
	 * ��ϵ˵��ȡ��
	 *
	 * @return ��ϵ˵��
	 */
	public String getSrdes() {
		return srdes;
	}

	/**
	 * ��ϵ˵���趨
	 *
	 * @param srdes��ϵ˵��
	 */
	public void setSrdes(String srdes) {
		this.srdes = srdes;
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
	 * ������ϵ��ȡ��
	 *
	 * @return ������ϵ��
	 */
	public String getSrraletioncode() {
		return srraletioncode;
	}

	/**
	 * ������ϵ���趨
	 *
	 * @param srraletioncode������ϵ��
	 */
	public void setSrraletioncode(String srraletioncode) {
		this.srraletioncode = srraletioncode;
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
	
	/**
	 * �ʲ�(����)��Ϣȡ��
	 * @return �ʲ�(����)��Ϣ
	 */
	public IG749Info getParEntityItemVW() {
	    return parEntityItemVW;
	}
	
	/**
	 * �ʲ�(����)��Ϣȡ��
	 * @return �ʲ�(����)��Ϣ
	 */
	public IG749Info getCldEntityItemVW() {
	    return cldEntityItemVW;
	}

}