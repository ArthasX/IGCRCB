/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.IG622Info;

/**
  * ����: ��ҳ��תURL����ʵ��
  * ��������: ��ҳ��תURL����ʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG622")
public class IG622TB extends BaseEntity implements Serializable,
		Cloneable, IG622Info {

	/** ��ҳID */
	@Id
	protected String hpid;

	/** ��ҳ���� */
	protected String hplabel;
	
	/** ��ҳ��ʾ���� */
	protected String hptitle;

	/** ��ҳURL */
	protected String hpurl;

	/**
	 * ��ҳIDȡ��
	 *
	 * @return ��ҳID
	 */
	public String getHpid() {
		return hpid;
	}

	/**
	 * ��ҳID�趨
	 *
	 * @param hpid ��ҳID
	 */
	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	/**
	 * ��ҳ����ȡ��
	 *
	 * @return ��ҳ����
	 */
	public String getHplabel() {
		return hplabel;
	}

	/**
	 * ��ҳ�����趨
	 *
	 * @param hplabel ��ҳ����
	 */
	public void setHplabel(String hplabel) {
		this.hplabel = hplabel;
	}

	/**
	 * ��ҳ��ʾ����ȡ��
	 *
	 * @return ��ҳ��ʾ����
	 */
	public String getHptitle() {
		return hptitle;
	}

	/**
	 * ��ҳ��ʾ�����趨
	 *
	 * @param hptitle ��ҳ��ʾ����
	 */
	public void setHptitle(String hptitle) {
		this.hptitle = hptitle;
	}

	/**
	 * ��ҳURLȡ��
	 *
	 * @return ��ҳURL
	 */
	public String getHpurl() {
		return hpurl;
	}

	/**
	 * ��ҳURL�趨
	 *
	 * @param hpurl ��ҳURL
	 */
	public void setHpurl(String hpurl) {
		this.hpurl = hpurl;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return hpid;
	}

}