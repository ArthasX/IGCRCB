package com.deliverik.framework.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.model.Attachment;


/**
 * <p>
 * ������Ϣʵ��
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Attachment")
public class AttachmentTB extends BaseEntity implements Serializable, Cloneable, Attachment {
	
	/** ����ID */
	@Id
	@TableGenerator(
		    name="ATTACHMENT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="ATTACHMENT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ATTACHMENT_TABLE_GENERATOR")
	protected Integer attid;
	
	/** �������� */
	protected String attkey;
	
	/** �������� */
	protected String attname;
	
	/** ������������ */
	protected String attdesc;
	
	/** �������λ�� */
	protected String atturl;

	
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Serializable getPK() {
		return attid;
	}

	/**
	 * �Ƚ����������Ƿ���ͬ
	 * @param obj
	 * @return �ȽϽ����true��ͬ��false��ͬ��
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof AttachmentTB))
			return false;
		Attachment target = (Attachment) obj;
		if (!(getAttid()==target.getAttid()))
			return false;

		return true;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getAttid() {
		return attid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param attid ����ID
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * ���������趨
	 *
	 * @param attkey ��������
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttname() {
		return attname;
	}

	/**
	 * ���������趨
	 *
	 * @param attname ��������
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttdesc() {
		return attdesc;
	}

	/**
	 * ���������趨
	 *
	 * @param attdesc ��������
	 */
	public void setAttdesc(String attdesc) {
		this.attdesc = attdesc;
	}

	/**
	 * �������λ��ȡ��
	 * @return �������λ��
	 */
	public String getAtturl() {
		return atturl;
	}

	/**
	 * �������λ���趨
	 *
	 * @param atturl �������λ��
	 */
	public void setAtturl(String atturl) {
		this.atturl = atturl;
	}

}
