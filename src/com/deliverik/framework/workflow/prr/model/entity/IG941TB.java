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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG941Info;

/**
 * <p>����:���񹤵���־ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG941")
public class IG941TB extends BaseEntity implements Serializable, Cloneable, IG941Info {
	
	/** ���񹤵���־ID */
	@Id
	@TableGenerator(
		    name="IG941_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG941_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG941_TABLE_GENERATOR")
	protected Integer sflid;
	
	/** ���񹤵�ID */
	protected Integer sfid;
	
	/** ���񹤵������¼ */
	protected String sfldesc;

	/** ���񹤵�������ID */
	protected String sfluserid;
	
	/** ���񹤵���־�Ǽ�ʱ�� */
	protected String sflinstime;
	/** ���񹤵����� */
	protected String sflattkey;

	/** ���񹤵������� */
	@OneToOne
	@JoinColumn(name="sfluserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB sfluser;
	
	/**
	 * ���ܣ�����ȡ��
	 * @return sflid ����
	 */
	public Serializable getPK() {
		return sflid;
	}

	/**
	 * ���ܣ����񹤵���־IDȡ��
	 * @return ���񹤵���־ID
	 */
	public Integer getSflid() {
		return sflid;
	}

	/**
	 * ���ܣ����񹤵���־ID�趨
	 * @param sflid ���񹤵���־ID
	 */
	public void setSflid(Integer sflid) {
		this.sflid = sflid;
	}

	/**
	 * ���ܣ����񹤵�IDȡ��
	 * @return ���񹤵�ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * ���ܣ����񹤵�ID�趨
	 * @param sfid ���񹤵�ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * ���ܣ����񹤵������¼ȡ��
	 * @return ���񹤵������¼
	 */
	public String getSfldesc() {
		return sfldesc;
	}

	/**
	 * ���ܣ����񹤵������¼�趨
	 * @param sfldesc ���񹤵������¼
	 */
	public void setSfldesc(String sfldesc) {
		this.sfldesc = sfldesc;
	}

	/**
	 * ���ܣ����񹤵�������IDȡ��
	 * @return ���񹤵�������ID
	 */
	public String getSfluserid() {
		return sfluserid;
	}

	/**
	 * ���ܣ����񹤵�������ID�趨
	 * @param sfluserid ���񹤵�������ID
	 */
	public void setSfluserid(String sfluserid) {
		this.sfluserid = sfluserid;
	}

	/**
	 * ���ܣ����񹤵���־�Ǽ�ʱ��ȡ��
	 * @return ���񹤵���־�Ǽ�ʱ��
	 */
	public String getSflinstime() {
		return sflinstime;
	}

	/**
	 * ���ܣ����񹤵���־�Ǽ�ʱ���趨
	 * @param sflinstime ���񹤵���־�Ǽ�ʱ��
	 */
	public void setSflinstime(String sflinstime) {
		this.sflinstime = sflinstime;
	}


	/**
	 * ���ܣ����񹤵�������ȡ��
	 * @return ���񹤵�������
	 */
	public User getSfluser() {
		return sfluser;
	}

	/**
	 * ���ܣ����񹤵�����ȡ��
	 * @return  sflattkey
	 */
	public String getSflattkey() {
		return sflattkey;
	}

	/**
	 * ���ܣ����񹤵���������
	 * @param sflattkey
	 */
	public void setSflattkey(String sflattkey) {
		this.sflattkey = sflattkey;
	}



}
