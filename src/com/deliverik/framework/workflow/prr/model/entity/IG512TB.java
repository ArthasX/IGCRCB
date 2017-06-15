/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

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

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;

/**
 * ���̹�ϵʵ��ӿ�
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG512")
public class IG512TB extends BaseEntity implements Serializable, Cloneable, IG512Info {

	/** ���̹�ϵID */
	@Id
	@TableGenerator(
		    name="IG512_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG512_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG512_TABLE_GENERATOR")
	protected Integer prrid;
	
	/** ��������ID */
	protected Integer parprid;

	/** ��������ID */
	protected Integer cldprid;
	
	/** ��ϵ����ʱ�� */
	protected String prrinstime;
	
	/** ����������Ϣ */
	@ManyToOne
	@JoinColumn(name="parprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB parProcess;
	
	/** ����������Ϣ */
	@ManyToOne
	@JoinColumn(name="cldprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB cldProcess;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return prrid;
	}

	/**
	 * ���̹�ϵIDȡ��
	 * 
	 * @return ���̹�ϵID
	 */
	public Integer getPrrid() {
		return prrid;
	}

	/**
	 * ���̹�ϵIDȡ��
	 * 
	 * @param prrid ���̹�ϵID
	 */
	public void setPrrid(Integer prrid) {
		this.prrid = prrid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param parprid ��������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public Integer getCldprid() {
		return cldprid;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @param cldprid ��������ID
	 */
	public void setCldprid(Integer cldprid) {
		this.cldprid = cldprid;
	}

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @return ��ϵ����ʱ��
	 */
	public String getPrrinstime() {
		return prrinstime;
	}

	/**
	 * ��ϵ����ʱ��ȡ��
	 * 
	 * @param prrinstime ��ϵ����ʱ��
	 */
	public void setPrrinstime(String prrinstime) {
		this.prrinstime = prrinstime;
	}

	/**
	 * ����������Ϣȡ��
	 * 
	 * @param parProcess ����������Ϣ
	 */
	public IG500Info getParProcess() {
		return parProcess;
	}

	/**
	 * ����������Ϣȡ��
	 * 
	 * @param cldProcess ����������Ϣ
	 */
	public IG500Info getCldProcess() {
		return cldProcess;
	}
	
}
