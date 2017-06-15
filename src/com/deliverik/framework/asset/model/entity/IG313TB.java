package com.deliverik.framework.asset.model.entity;

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
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;

/**
 * <p>
 * �ʲ���ϵ��Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG313")
public class IG313TB extends BaseEntity implements Serializable, Cloneable, IG313Info, LogicalDelete {

	/** �ʲ���ϵ��ϢID */
	@Id
	@TableGenerator(
		    name="IG313_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG313_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG313_TABLE_GENERATOR")
	protected Integer eirid;
	
	/** �ʲ�ID����������� */
	protected Integer pareiid;

	/** �ʲ�ģ��ID������ */
	protected Integer pareid;

	/** �ʲ�ID����������� */
	protected Integer cldeiid;

	/** �ʲ�ģ��ID������ */
	protected Integer cldeid;

	/** �ʲ���ϵ��Ϣ����ʱ�� */
	protected String eirupdtime;
	
	/** �ʲ���ϵ�Ƿ����ɾ����ʶ��"C"��ʶ����ɾ���� */
	protected String eirstatus;
	
	/** �ʲ���ϵ˵�� */
	protected String eirdesc;
	
	/** �ʲ���ϵID */
	protected String eirrelation;
	
	/** �ʲ���ϵ���� */
	protected String eirrelationcode;
	
	/** �ʲ���ϵ����0����1����*/
	@Transient
	protected String parflag;
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	protected String eirinfo;
	
	
	/** �ʲ���������Ϣ */
	@ManyToOne
	@JoinColumn(name="pareiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW parEntityItemVW;

	/** �ʲ���������Ϣ */
	@ManyToOne
	@JoinColumn(name="cldeiid", referencedColumnName="eiid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG749VW cldEntityItemVW;
	
	/** �����ʲ���汾 */
	protected Integer parversion;
	
	/** �����ʲ�С�汾 */
	protected Integer parsmallversion;
	
	/** �����ʲ���汾 */
	protected Integer cldversion;
	
	/** �����ʲ�С�汾 */
	protected Integer cldsmallversion;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eirid;
	}

	/**
	 * �ʲ���ϵ��ϢIDȡ��
	 * @return �ʲ���ϵ��ϢID
	 */
	public Integer getEirid() {
		return eirid;
	}

	/**
	 * �ʲ���ϵ��ϢID�趨
	 *
	 * @param eirid �ʲ���ϵ��ϢID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}


	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getPareiid() {
		return pareiid;
	}


	/**
	 * �ʲ�ID�������趨
	 *
	 * @param pareiid �ʲ�ID������
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getPareid() {
		return pareid;
	}


	/**
	 * �ʲ�ģ��ID�������趨
	 *
	 * @param pareid �ʲ�ģ��ID������
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}


	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}


	/**
	 * �ʲ�ID�������趨
	 *
	 * @param cldeiid �ʲ�ID������
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}


	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getCldeid() {
		return cldeid;
	}


	/**
	 * �ʲ�ģ��ID�������趨
	 *
	 * @param cldeid �ʲ�ģ��ID������
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}


	/**
	 * �ʲ���ϵ��Ϣ����ʱ��ȡ��
	 * @return �ʲ���ϵ��Ϣ����ʱ��
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}


	/**
	 * �ʲ���ϵ��Ϣ����ʱ���趨
	 *
	 * @param eirupdtime �ʲ���ϵ��Ϣ����ʱ��
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}


	/**
	 * �ʲ���ϵ��Ϣ�Ƿ����ɾ����ʶȡ��
	 * @return �ʲ���ϵ��Ϣ�Ƿ����ɾ����ʶ
	 */
	public String getEirstatus() {
		return eirstatus;
	}


	/**
	 * �ʲ���ϵ��Ϣ�Ƿ����ɾ����ʶ�趨
	 *
	 * @param eirstatus �ʲ���ϵ��Ϣ�Ƿ����ɾ����ʶ
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}



	/**
	 * �ʲ���ϵIDȡ��
	 * @return �ʲ���ϵID״̬
	 */
	public String getEirrelation() {
		return eirrelation;
	}


	/**
	 * �ʲ���ϵID 
	 *
	 * @param eirrelation �ʲ���ϵID
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}


	/**
	 * �ʲ���ϵ˵��ȡ��
	 * @return �ʲ���ϵ˵��
	 */
	public String getEirdesc() {
		return eirdesc;
	}


	/**
	 * �ʲ���ϵ˵���趨
	 *
	 * @param eirdesc �ʲ���ϵ˵��
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
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


	/**
	 * �ʲ���ϵ����ȡ��
	 * @return �ʲ���ϵ����
	 */
	public String getEirrelationcode() {
		return eirrelationcode;
	}

	/**
	 * �ʲ���ϵ�����趨
	 *
	 * @param eirrelationcode �ʲ���ϵ����
	 */
	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}


	/**
	 * �ʲ���ϵ����ȡ��
	 * @return �ʲ���ϵ����
	 */
	public String getParflag() {
		return parflag;
	}

	/**
	 * �ʲ���ϵ�����趨
	 *
	 * @param parflag �ʲ���ϵ����
	 */
	public void setParflag(String parflag) {
		this.parflag = parflag;
	}
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣȡ��
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public String getEirinfo() {
		return eirinfo;
	}

	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ�趨
	 *
	 * @param eirinfo ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}

	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getParversion() {
		return parversion;
	}

	/**
	 * �����ʲ���汾�趨
	 *
	 * @param parversion �����ʲ���汾
	 */
	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}
	
	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getParsmallversion() {
		return parsmallversion;
	}

	/**
	 * �����ʲ�С�汾�趨
	 *
	 * @param parsmallversion �����ʲ�С�汾
	 */
	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getCldversion() {
		return cldversion;
	}

	/**
	 * �����ʲ���汾�趨
	 *
	 * @param cldversion �����ʲ���汾
	 */
	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	/**
	 * �����ʲ�С�汾�趨
	 *
	 * @param cldsmallversion �����ʲ�С�汾
	 */
	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	/**
	 * �߼�ɾ����ʶȡ��
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ�������趨
	 *
	 * @param deleteflag �߼�ɾ����ʶ������
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
}
