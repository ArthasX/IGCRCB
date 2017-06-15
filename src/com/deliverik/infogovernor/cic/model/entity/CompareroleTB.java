/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;

/**
  * ����: �Աȹ���ʵ��
  * ��������: �Աȹ���ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="comparerole")
public class CompareroleTB extends BaseEntity implements Serializable,
		Cloneable, CompareroleInfo {

	/** crid */
	@Id
	@GeneratedValue(generator = "crid")
	@GenericGenerator(name = "crid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "comparerole_seq") })
	protected Integer crid;

	/** �Ա����� */
	protected String crtype;

	/** ���� */
	protected String crname;

	/** �Ա������ */
	protected Integer fkCsid;
	
	@ManyToOne
	@JoinColumn(name="fkCsid", referencedColumnName="csid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected ComparescopeTB comparescopeTb;
	
	

	/** ҵ��ϵͳid */
	protected Integer crsystemid;

	/** ҵ��ϵͳ���� */
	protected String crsystemname;
	
	/** �Աȹ���汾 */
    protected Integer crversion;

	/**
	 * cridȡ��
	 *
	 * @return crid
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * crid�趨
	 *
	 * @param crid crid
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * �Ա�����ȡ��
	 *
	 * @return �Ա�����
	 */
	public String getCrtype() {
		return crtype;
	}

	/**
	 * �Ա������趨
	 *
	 * @param crtype �Ա�����
	 */
	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCrname() {
		return crname;
	}

	/**
	 * �����趨
	 *
	 * @param crname ����
	 */
	public void setCrname(String crname) {
		this.crname = crname;
	}

	/**
	 * �Ա������ȡ��
	 *
	 * @return �Ա������
	 */
	public Integer getFkCsid() {
		return fkCsid;
	}

	/**
	 * �Ա�������趨
	 *
	 * @param fkCsid �Ա������
	 */
	public void setFkCsid(Integer fkCsid) {
		this.fkCsid = fkCsid;
	}

	/**
	 * ҵ��ϵͳidȡ��
	 *
	 * @return ҵ��ϵͳid
	 */
	public Integer getCrsystemid() {
		return crsystemid;
	}

	/**
	 * ҵ��ϵͳid�趨
	 *
	 * @param crsystemid ҵ��ϵͳid
	 */
	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return ҵ��ϵͳ����
	 */
	public String getCrsystemname() {
		return crsystemname;
	}

	/**
	 * ҵ��ϵͳ�����趨
	 *
	 * @param crsystemname ҵ��ϵͳ����
	 */
	public void setCrsystemname(String crsystemname) {
		this.crsystemname = crsystemname;
	}

	/** 
     * �Աȹ���汾 ȡ��
     * @return crversion �Աȹ���汾 
     */
    public Integer getCrversion() {
        return crversion;
    }

    /** 
     * �Աȹ���汾 �趨
     * @param crversion �Աȹ���汾 
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }

    /**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
	public Serializable getPK() {
		return crid;
	}

}