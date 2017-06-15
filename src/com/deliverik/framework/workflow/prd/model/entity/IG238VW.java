/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.workflow.prd.model.IG238Info;

/**
  * ����: ����֪ͨ����ʵ��
  * ��������: ����֪ͨ����ʵ��
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG212PK.class)
public class IG238VW implements Serializable,
		Cloneable, IG238Info {

	/** ״̬ID */
	@Id
	protected String psdid;

	/** �Ƿ�ȷ�� */
	@Id
	protected String psdconfirm;
	
	/** ״̬���� */
	protected String psdname;

	/** �Ƿ��Ͷ��� */
	protected String sms;

	/** �Ƿ����ʼ� */
	protected String email;

	/** ֪ͨ�� */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumns({
		  @JoinColumn(name="psdid", referencedColumnName="psdid" ,updatable=false, insertable= false),
		  @JoinColumn(name="psdconfirm", referencedColumnName="psdconfirm",updatable=false, insertable= false)
		      })
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG237TB> lst_ProcessNoticeStrategyUser;
	
	/** ֪ͨ��ID */
	@Transient
	protected String notifierids;
	
	/** ֪ͨ������ */
	@Transient
	protected String notifiernames;

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 *
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �Ƿ�ȷ��ȡ��
	 *
	 * @return �Ƿ�ȷ��
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * �Ƿ�ȷ���趨
	 *
	 * @param psdconfirm �Ƿ�ȷ��
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * ״̬����ȡ��
	 * 
	 * @return ״̬����
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ״̬�����趨
	 * 
	 * @param psdname ״̬����
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * �Ƿ��Ͷ���ȡ��
	 *
	 * @return �Ƿ��Ͷ���
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * �Ƿ��Ͷ����趨
	 *
	 * @param sms �Ƿ��Ͷ���
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * �Ƿ����ʼ�ȡ��
	 *
	 * @return �Ƿ����ʼ�
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * �Ƿ����ʼ��趨
	 *
	 * @param email �Ƿ����ʼ�
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ֪ͨ���趨
	 * 
	 * @return ֪ͨ��
	 */
	public List<IG237TB> getLst_ProcessNoticeStrategyUser() {
		return lst_ProcessNoticeStrategyUser;
	}
	
	/**
	 * ֪ͨ��IDȡ��
	 * 
	 * @return ֪ͨ��ID
	 */
	public String getNotifierids() {
		if(this.lst_ProcessNoticeStrategyUser != null) {
			StringBuffer sbf_notifierids = new StringBuffer();
			for(IG237TB bean : lst_ProcessNoticeStrategyUser) {
				sbf_notifierids.append(bean.getRoleid()).append("##").append(bean.getUserid()).append("###");
			}
			if(sbf_notifierids.length() > 0) {
				this.notifierids = sbf_notifierids.substring(0, sbf_notifierids.length() - 3);
			}
		}
		return notifierids;
	}

	/**
	 * ֪ͨ��ID�趨
	 * 
	 * @param notifierids ֪ͨ��ID
	 */
	public void setNotifierids(String notifierids) {
		this.notifierids = notifierids;
	}

	/**
	 * ֪ͨ������ȡ��
	 * 
	 * @return ֪ͨ������
	 */
	public String getNotifiernames() {
		if(this.lst_ProcessNoticeStrategyUser != null) {
			StringBuffer sbf_notifiernames = new StringBuffer();
			for(IG237TB bean : lst_ProcessNoticeStrategyUser) {
				sbf_notifiernames.append(bean.getUser().getUsername()).append("��");
			}
			if(sbf_notifiernames.length() > 0) {
				this.notifiernames = sbf_notifiernames.substring(0, sbf_notifiernames.length() - 1);
			}
		}
		return notifiernames;
	}

	/**
	 * ֪ͨ�������趨
	 * 
	 * @param notifiernames ֪ͨ������
	 */
	public void setNotifiernames(String notifiernames) {
		this.notifiernames = notifiernames;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG212PK(psdid, psdconfirm);
	}

}