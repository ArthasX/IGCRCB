/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG506Info;

/**
  * ����: ��Ա���ֵ��ʵ��
  * ��������: ��Ա���ֵ��ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG506")
public class IG506TB extends BaseEntity implements Serializable,
		Cloneable, IG506Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG506_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG506_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG506_TABLE_GENERATOR")
	protected Integer piuid;

	/** �������� */
	protected Integer prid;

	/** �û�id */
	protected String piuserid;

	/** �û��� */
	protected String piusername;

	/** ������ */
	protected String piorgid;

	/** �������� */
	protected String piorgname;

	/** ��ɫid */
	protected Integer piroleid;

	/** ��ɫ���� */
	protected String pirolename;
	
	/** �绰 */
	protected String piphone;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPiuid() {
		return piuid;
	}

	/**
	 * �����趨
	 *
	 * @param piuid ����
	 */
	public void setPiuid(Integer piuid) {
		this.piuid = piuid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getPiuserid() {
		return piuserid;
	}

	/**
	 * �û�id�趨
	 *
	 * @param piuserid �û�id
	 */
	public void setPiuserid(String piuserid) {
		this.piuserid = piuserid;
	}

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getPiusername() {
		return piusername;
	}

	/**
	 * �û����趨
	 *
	 * @param piusername �û���
	 */
	public void setPiusername(String piusername) {
		this.piusername = piusername;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPiorgid() {
		return piorgid;
	}

	/**
	 * �������趨
	 *
	 * @param piorgid ������
	 */
	public void setPiorgid(String piorgid) {
		this.piorgid = piorgid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPiorgname() {
		return piorgname;
	}

	/**
	 * ���������趨
	 *
	 * @param piorgname ��������
	 */
	public void setPiorgname(String piorgname) {
		this.piorgname = piorgname;
	}

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public Integer getPiroleid() {
		return piroleid;
	}

	/**
	 * ��ɫid�趨
	 *
	 * @param piroleid ��ɫid
	 */
	public void setPiroleid(Integer piroleid) {
		this.piroleid = piroleid;
	}

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getPirolename() {
		return pirolename;
	}

	/**
	 * ��ɫ�����趨
	 *
	 * @param pirolename ��ɫ����
	 */
	public void setPirolename(String pirolename) {
		this.pirolename = pirolename;
	}

	/**
	 * �绰ȡ��
	 * @return piphone �绰
	 */
	public String getPiphone() {
		return piphone;
	}

	/**
	 * �绰�趨
	 * @param piphone �绰
	 */
	public void setPiphone(String piphone) {
		this.piphone = piphone;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return piuid;
	}

}