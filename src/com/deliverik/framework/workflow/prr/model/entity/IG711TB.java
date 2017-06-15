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
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG711Info;

/**
 * <p>����:��Ȩ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG711")
public class IG711TB extends BaseEntity implements Serializable, Cloneable, IG711Info {
	/** ��Ȩ����ID */
	@Id
	@TableGenerator(
		    name="IG711_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG711_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG711_TABLE_GENERATOR")
	
	/** ��ȨID*/
	protected Integer paid;
	
	/** ʹ����ID*/
	protected String paiid;
	
	/** ��Ȩ��ID*/
	protected String pauid;
	
	/** ��Ȩ��ʼ����*/
	protected String pabegintime;
	
	/** ��Ȩ��������*/
	protected String paendtime;
	
	/** ��Ȩ��ʶλ*/
	protected String paflag;
	
	/** ��Ȩ����*/
	protected String patype;
	
	/** ����(����)ID*/
	protected Integer paprocessid ;
	
	/** ����(����)���*/
	protected String paprocessnum ;
	
	/** ��Ȩ�Ǽ�ʱ��*/
	protected String palogintime;
	
	/** ��Ȩ˵��*/
	protected String remarks;
	
	@OneToOne
	@JoinColumn(name="paiid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	/** ��Ȩ��TB*/
	protected UserTB userTB_A;
	@OneToOne
	@JoinColumn(name="pauid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	
	/** ����Ȩ��TB*/
	protected UserTB userTB_B;
	/**
	 * ���ܣ�����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return paid;
	}
	
	/**
	 * ���ܣ���ȨIDȡ��
	 * 
	 * @return ��ȨID
	 */
	
	public Integer getPaid() {
		return paid;
	}

	/**
	 * ���ܣ���ȨID�趨
	 *
	 * @param paid ��ȨID
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	/**
	 * ���ܣ�ʹ����IDȡ��
	 * 
	 * @return ʹ����ID
	 */
	public String getPaiid() {
		return paiid;
	}

	/**
	 * ���ܣ�ʹ����ID�趨
	 *
	 * @param paiid ʹ����ID
	 */
	public void setPaiid(String paiid) {
		this.paiid = paiid;
	}

	/**
	 * ���ܣ���Ȩ��IDȡ��
	 * 
	 * @return ��Ȩ��ID
	 */
	public String getPauid() {
		return pauid;
	}

	/**
	 * ���ܣ���Ȩ��ID�趨
	 *
	 * @param pauid ��Ȩ��ID
	 */
	public void setPauid(String pauid) {
		this.pauid = pauid;
	}

	/**
	 * ���ܣ���Ȩ��ʼ����ȡ��
	 * 
	 * @return ��Ȩ��ʼ����
	 */
	public String getPabegintime() {
		return pabegintime;
	}

	/**
	 * ���ܣ���Ȩ��ʼ�����趨
	 *
	 * @param pabegintime ��Ȩ��ʼ����
	 */
	public void setPabegintime(String pabegintime) {
		this.pabegintime = pabegintime;
	}

	/**
	 * ���ܣ���Ȩ��������ȡ��
	 * 
	 * @return ��Ȩ��������
	 */
	public String getPaendtime() {
		return paendtime;
	}

	/**
	 * ���ܣ���Ȩ���������趨
	 *
	 * @param paendtime ��Ȩ��������
	 */
	public void setPaendtime(String paendtime) {
		this.paendtime = paendtime;
	}

	/**
	 * ���ܣ���Ȩ��ʶλȡ��
	 * 
	 * @return ��Ȩ��ʶλ
	 */
	public String getPaflag() {
		return paflag;
	}

	/**
	 * ���ܣ���Ȩ��ʶλ�趨
	 *
	 * @param paflag ��Ȩ��ʶλ
	 */
	public void setPaflag(String paflag) {
		this.paflag = paflag;
	}

	/**
	 * ���ܣ���Ȩ����ȡ��
	 * 
	 * @return ��Ȩ����
	 */
	public String getPatype() {
		return patype;
	}

	/**
	 * ���ܣ���Ȩ�����趨
	 *
	 * @param paflag ��Ȩ����
	 */
	public void setPatype(String patype) {
		this.patype = patype;
	}

	/**
	 * ���ܣ��������ȡ��
	 * 
	 * @return �������
	 */
	public String getPaprocessnum() {
		return paprocessnum;
	}

	/**
	 * ���ܣ���������趨
	 *
	 * @param paflag �������
	 */
	public void setPaprocessnum(String paprocessnum) {
		this.paprocessnum = paprocessnum;
	}
	
	/**
	 * ���ܣ�����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPaprocessid() {
		return paprocessid;
	}

	/**
	 * ���ܣ�����ID�趨
	 *
	 * @param paflag ����ID
	 */
	public void setPaprocessid(Integer paprocessid) {
		this.paprocessid = paprocessid;
	}

	/**
	 * ���ܣ���Ȩ�Ǽ�ʱ��ȡ��
	 * 
	 * @return ��Ȩ�Ǽ�ʱ��
	 */
	public String getPalogintime() {
		return palogintime;
	}

	/**
	 * ���ܣ���Ȩ�Ǽ�ʱ���趨
	 *
	 * @param paflag ��Ȩ�Ǽ�ʱ��
	 */
	public void setPalogintime(String palogintime) {
		this.palogintime = palogintime;
	}

	/**
	 * ���ܣ���Ȩ��TBȡ��
	 * @return userTB_A ��Ȩ��TB
	 */
	public UserTB getUserTB_A() {
		return userTB_A;
	}
	
	/**
	 * ���ܣ���Ȩ��TB����
	 * @param userTB_A ��Ȩ��TB
	 */
	public void setUserTB_A(UserTB userTB_A) {
		this.userTB_A = userTB_A;
	}

	/**
	 * ���ܣ�����Ȩ��TBȡ��
	 * @return userTB_B ����Ȩ��TB
	 */
	public UserTB getUserTB_B() {
		return userTB_B;
	}

	/**
	 * ���ܣ�����Ȩ��TB����
	 * @param userTB_B ����Ȩ��TB
	 */
	public void setUserTB_B(UserTB userTB_B) {
		this.userTB_B = userTB_B;
	}

	/**
	 * ��Ȩ˵��ȡ��
	 * @return ��Ȩ˵��
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * ��Ȩ˵���趨
	 * @param remarks��Ȩ˵��
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
