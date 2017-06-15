/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG243Info;

/**
  * ����: ���̱��ⶨ���ʵ��
  * ��������: ���̱��ⶨ���ʵ��
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG243")
public class IG243TB extends BaseEntity implements Serializable,
		Cloneable, IG243Info {

	/** ���� */
	@Id
	protected String ptdid;

	/** ���̶���ID */
	protected String pdid;

	/** �������ƶ��� */
	protected String ptitlename;

	/** ��������Ȩ�� 0�ɼ���1���ɼ� */
	protected String ptitleaccess;

	/** �����ֶ����� */
	protected String pdescname;

	/** �����ֶ�Ȩ�� 0���ɼ���1���ɼ� */
	protected String pdescaccess;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * �����趨
	 *
	 * @param ptdid ����
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
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
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * �������ƶ���ȡ��
	 *
	 * @return �������ƶ���
	 */
	public String getPtitlename() {
		return ptitlename;
	}

	/**
	 * �������ƶ����趨
	 *
	 * @param ptitlename �������ƶ���
	 */
	public void setPtitlename(String ptitlename) {
		this.ptitlename = ptitlename;
	}

	/**
	 * ��������Ȩ�� 0�ɼ���1���ɼ�ȡ��
	 *
	 * @return ��������Ȩ�� 0�ɼ���1���ɼ�
	 */
	public String getPtitleaccess() {
		return ptitleaccess;
	}

	/**
	 * ��������Ȩ�� 0�ɼ���1���ɼ��趨
	 *
	 * @param ptitleaccess ��������Ȩ�� 0�ɼ���1���ɼ�
	 */
	public void setPtitleaccess(String ptitleaccess) {
		this.ptitleaccess = ptitleaccess;
	}

	/**
	 * �����ֶ�����ȡ��
	 *
	 * @return �����ֶ�����
	 */
	public String getPdescname() {
		return pdescname;
	}

	/**
	 * �����ֶ������趨
	 *
	 * @param pdescname �����ֶ�����
	 */
	public void setPdescname(String pdescname) {
		this.pdescname = pdescname;
	}

	/**
	 * �����ֶ�Ȩ�� 0���ɼ���1���ɼ�ȡ��
	 *
	 * @return �����ֶ�Ȩ�� 0���ɼ���1���ɼ�
	 */
	public String getPdescaccess() {
		return pdescaccess;
	}

	/**
	 * �����ֶ�Ȩ�� 0���ɼ���1���ɼ��趨
	 *
	 * @param pdescaccess �����ֶ�Ȩ�� 0���ɼ���1���ɼ�
	 */
	public void setPdescaccess(String pdescaccess) {
		this.pdescaccess = pdescaccess;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ptdid;
	}

}