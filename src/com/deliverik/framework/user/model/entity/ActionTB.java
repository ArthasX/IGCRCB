package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Action;


/**
 * <p>
 * �˵���Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Action")
public class ActionTB extends BaseEntity implements Serializable, Cloneable, Action {
	
	/** �˵�ID */
	@Id
	protected String actname;

	/** �˵���ʾ���� */
	protected String actlabel;

	/** �˵����� */
	protected String actdesc;

	/** �˵�URL */
	protected String acturl;

	/** �˵����� */
	protected String acttype;

	/** һ���˵�ID */
	protected Integer actl1id;

	/** �����˵�ID */
	protected Integer actl2id;

	/** �����˵�ID */
	protected Integer actl3id;
	
	/** �˵��������ɫ����(���ŷָ�) */
	protected String actroletype;
	
	/** �˵�����ID*/
	protected String actsortid;
	
	/** �˵�URL���� */
	protected String acturltype;
	
	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵������趨
	 *
	 * @param actname �˵�����
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * �˵���ʾ����ȡ��
	 * @return �˵���ʾ����
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * �˵���ʾ�����趨
	 *
	 * @param actlabel �˵���ʾ����
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActdesc() {
		return actdesc;
	}

	/**
	 * �˵������趨
	 *
	 * @param actdesc �˵�����
	 */
	public void setActdesc(String actdesc) {
		this.actdesc = actdesc;
	}

	/**
	 * �˵�URLȡ��
	 * @return �˵�URL
	 */
	public String getActurl() {
		return acturl;
	}

	/**
	 * �˵�URL�趨
	 *
	 * @param acturl �˵�URL
	 */
	public void setActurl(String acturl) {
		this.acturl = acturl;
	}

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActtype() {
		return acttype;
	}

	/**
	 * �˵������趨
	 *
	 * @param acttype �˵�����
	 */
	public void setActtype(String acttype) {
		this.acttype = acttype;
	}

	/**
	 * һ���˵�IDȡ��
	 * @return һ���˵�ID
	 */
	public Integer getActl1id() {
		return actl1id;
	}

	/**
	 * һ���˵�ID�趨
	 *
	 * @param actl1id һ���˵�ID
	 */
	public void setActl1id(Integer actl1id) {
		this.actl1id = actl1id;
	}

	/**
	 * �����˵�IDȡ��
	 * @return �����˵�ID
	 */
	public Integer getActl2id() {
		return actl2id;
	}

	/**
	 * �����˵�ID�趨
	 *
	 * @param actl2id �����˵�ID
	 */
	public void setActl2id(Integer actl2id) {
		this.actl2id = actl2id;
	}

	/**
	 * �����˵�IDȡ��
	 * @return �����˵�ID
	 */
	public Integer getActl3id() {
		return actl3id;
	}

	/**
	 * �����˵�ID�趨
	 *
	 * @param actl3id �����˵�ID
	 */
	public void setActl3id(Integer actl3id) {
		this.actl3id = actl3id;
	}
	
	/**
	 * �˵��������ɫ����(���ŷָ�)ȡ��
	 * @return �˵��������ɫ����(���ŷָ�)
	 */
	public String getActroletype() {
		return actroletype;
	}

	/**
	 * �˵��������ɫ����(���ŷָ�)�趨
	 *
	 * @param actroletype �˵��������ɫ����(���ŷָ�)
	 */
	public void setActroletype(String actroletype) {
		this.actroletype = actroletype;
	}
	
	/**
	 * �˵�����IDȡ��
	 * @return �˵�����ID
	 */
	public String getActsortid() {
		return actsortid;
	}

	/**
	 * �˵�����ID�趨
	 * @param actsortid �˵�����ID
	 */
	public void setActsortid(String actsortid) {
		this.actsortid = actsortid;
	}
	
	/**
	 * �˵�URL����ȡ��
	 * @return �˵�URL����
	 */
	public String getActurltype() {
		return acturltype;
	}

	/**
	 * �˵�URL�����趨
	 *
	 * @param acturltype �˵�URL����
	 */
	public void setActurltype(String acturltype) {
		this.acturltype = acturltype;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return actname;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ActionTB))
			return false;
		Action target = (Action) obj;
		if (!(getActname()==target.getActname()))
			return false;

		return true;
	}
	
	

}
