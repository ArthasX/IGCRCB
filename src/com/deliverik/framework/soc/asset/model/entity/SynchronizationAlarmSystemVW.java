/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;


/**
 * ����:ͬ���澯ϵͳ��ͼʵ��
 * ��������: ͬ���澯ϵͳ��ͼʵ��
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
public class SynchronizationAlarmSystemVW implements Serializable, Cloneable, 
	SynchronizationAlarmSystemVWInfo{
	
	/**id  */
	@Id
	protected Integer rid;
	/**��ͬ��ϵͳid  */
	protected Integer ilsid;
	/**��ͬ��ϵͳ���� */
	protected String ilsname;
	/**��ͬ��ϵͳ����  */
	protected String eaname;
	
	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * id�趨
	 *
	 * @return id
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * ��ͬ��ϵͳidȡ��
	 *
	 * @return ��ͬ��ϵͳid
	 */
	public Integer getIlsid() {
		return ilsid;
	}

	/**
	 * ��ͬ��ϵͳid�趨
	 *
	 * @return ��ͬ��ϵͳid
	 */
	public void setIlsid(Integer ilsid) {
		this.ilsid = ilsid;
	}

	/**
	 * ��ͬ��ϵͳ����ȡ��
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * ��ͬ��ϵͳ�����趨
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * ��ͬ��ϵͳ����ȡ��
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public String getEaname() {
		return eaname;
	}

	/**
	 * ��ͬ��ϵͳ�����趨
	 *
	 * @return ��ͬ��ϵͳ����
	 */
	public void setEaname(String eaname) {
		this.eaname = eaname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rid;
	}
}
