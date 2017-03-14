package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG126Info;

/**
 * ����ҳ�涨����Ϣʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG126")
public class IG126TB extends BaseEntity implements Serializable,
		Cloneable, IG126Info {
	
	/** ����ҳ�涨��ID */
	@Id
	protected String pjdid;

	/** ���̶���ID */
	protected String pdid;

	/** ҳ�����ͣ�1-����2-����3-�鿴 */
	protected String pjdtype;

	/** �Զ���BL���� */
	protected String pjdblid;

	/** ҳ��·�� */
	protected String pjdurl;

	/**
	 * ����ҳ�涨��IDȡ��
	 * 
	 * @return ����ҳ�涨��ID
	 */
	public String getPjdid() {
		return pjdid;
	}

	/**
	 * ����ҳ�涨��ID�趨
	 * 
	 * @param pjdid����ҳ�涨��ID
	 */
	public void setPjdid(String pjdid) {
		this.pjdid = pjdid;
	}

	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ҳ������ȡ��
	 * 
	 * @return ҳ������
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * ҳ�������趨
	 * 
	 * @param pjdtypeҳ������
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * �Զ���BL����ȡ��
	 * 
	 * @return �Զ���BL����
	 */
	public String getPjdblid() {
		return pjdblid;
	}

	/**
	 * �Զ���BL�����趨
	 * 
	 * @param pjdblid�Զ���BL����
	 */
	public void setPjdblid(String pjdblid) {
		this.pjdblid = pjdblid;
	}

	/**
	 * ҳ��·��ȡ��
	 * 
	 * @return ҳ��·��
	 */
	public String getPjdurl() {
		return pjdurl;
	}

	/**
	 * ҳ��·���趨
	 * 
	 * @param pjdurlҳ��·��
	 */
	public void setPjdurl(String pjdurl) {
		this.pjdurl = pjdurl;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Serializable getPK() {
		return pjdid;
	}

	/**
	 * �ȽϷ���
	 * 
	 * @param obj����ҳ�涨����Ϣ
	 * @return �ȽϽ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG126TB))
			return false;
		IG126Info target = (IG126Info) obj;
		if (!(getPjdid() == target.getPjdid()))
			return false;
		return true;
	}

}
