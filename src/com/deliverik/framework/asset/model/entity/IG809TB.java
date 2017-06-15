/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.base.BaseEntity;

/**
 * �ʲ���ϵͼ�ļ���Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG809")
public class IG809TB extends BaseEntity implements Serializable, Cloneable, IG809Info {

	/** ���� */
	@Id
	@TableGenerator(
		    name="IG809_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG809_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG809_TABLE_GENERATOR")
	protected Integer eirfid;
	
	/** �ʲ�ID */
	protected Integer eiid;
	
	/** ��ϵͼ���� */
	protected String eirftype;
	
	/** ��ϵͼ�ļ��� */
	protected String eirfname;
	
	/** ����ʱ�� */
	protected String eirfupdtime;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return eirfid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getEirfid() {
		return eirfid;
	}

	/**
	 * �����趨
	 * @return ����
	 */
	public void setEirfid(Integer eirfid) {
		this.eirfid = eirfid;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @return �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ��ϵͼ����ȡ��
	 * @return ��ϵͼ����
	 */
	public String getEirftype() {
		return eirftype;
	}

	/**
	 * ��ϵͼ�����趨
	 * @return ��ϵͼ����
	 */
	public void setEirftype(String eirftype) {
		this.eirftype = eirftype;
	}

	/**
	 * ��ϵͼ�ļ���ȡ��
	 * @return ��ϵͼ�ļ���
	 */
	public String getEirfname() {
		return eirfname;
	}

	/**
	 * ��ϵͼ�ļ����趨
	 * @return ��ϵͼ�ļ���
	 */
	public void setEirfname(String eirfname) {
		this.eirfname = eirfname;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getEirfupdtime() {
		return eirfupdtime;
	}

	/**
	 * ����ʱ���趨
	 * @return ����ʱ��
	 */
	public void setEirfupdtime(String eirfupdtime) {
		this.eirfupdtime = eirfupdtime;
	}

	
}
