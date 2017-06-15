/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG555Info;

/**
  * ����: ���̴���ҳ����������Ϣʵ��
  * ��������: ���̴���ҳ����������Ϣʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG555")
public class IG555TB extends BaseEntity implements Serializable,
		Cloneable, IG555Info {

	/** ��ʶ */
	@Id
	protected String jump;

	/** ����·�� */
	protected String url;
	
	/** ˵�� */
	protected String description;

	/**
	 * ��ʶȡ��
	 *
	 * @return ��ʶ
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * ��ʶ�趨
	 *
	 * @param jump ��ʶ
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * ����·��ȡ��
	 *
	 * @return ����·��
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * ����·���趨
	 *
	 * @param url ����·��
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return jump;
	}

	/**
	 * ˵��ȡ��
	 * @return ˵��
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ˵���趨
	 * @param description ˵��
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}