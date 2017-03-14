/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;

/**
  * ����: ���չ�����ʾ���ݱ�ʵ��
  * ��������: ���չ�����ʾ���ݱ�ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskmanagerwaring")
public class RiskmanagerwaringTB extends BaseEntity implements Serializable,
		Cloneable, RiskmanagerwaringInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RISKMANAGERWARING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKMANAGERWARING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKMANAGERWARING_TABLE_GENERATOR")
	protected Integer rwid;

	/** ������ʾ���� */
	protected String rwname;

	/** �·�����id */
	protected String nuserid;

	/** �·��������� */
	protected String nusername;

	/** �·��߻����� */
	protected String norgname;

	/** �·��߻����� */
	protected String norgid;

	/** �·�ʱ�� */
	protected String ntime;

	/** �·�����ϵ��ʽ */
	protected String ntel;

	/** ������ʾ���� */
	protected String rwcontext;

	/** ��ʾ���� */
	protected String rwkey;
	
	/** ��ʾ���� */
	@Transient
	protected String showTime;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * �����趨
	 *
	 * @param rwid ����
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public String getRwname() {
		return rwname;
	}

	/**
	 * ������ʾ�����趨
	 *
	 * @param rwname ������ʾ����
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * �·�����idȡ��
	 *
	 * @return �·�����id
	 */
	public String getNuserid() {
		return nuserid;
	}

	/**
	 * �·�����id�趨
	 *
	 * @param nuserid �·�����id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * �·���������ȡ��
	 *
	 * @return �·���������
	 */
	public String getNusername() {
		return nusername;
	}

	/**
	 * �·����������趨
	 *
	 * @param nusername �·���������
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * �·��߻�����ȡ��
	 *
	 * @return �·��߻�����
	 */
	public String getNorgname() {
		return norgname;
	}

	/**
	 * �·��߻������趨
	 *
	 * @param norgname �·��߻�����
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * �·��߻�����ȡ��
	 *
	 * @return �·��߻�����
	 */
	public String getNorgid() {
		return norgid;
	}

	/**
	 * �·��߻������趨
	 *
	 * @param norgid �·��߻�����
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * �·�ʱ��ȡ��
	 *
	 * @return �·�ʱ��
	 */
	public String getNtime() {
		return ntime;
	}

	/**
	 * �·�ʱ���趨
	 *
	 * @param ntime �·�ʱ��
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * �·�����ϵ��ʽȡ��
	 *
	 * @return �·�����ϵ��ʽ
	 */
	public String getNtel() {
		return ntel;
	}

	/**
	 * �·�����ϵ��ʽ�趨
	 *
	 * @param ntel �·�����ϵ��ʽ
	 */
	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public String getRwcontext() {
		return rwcontext;
	}

	/**
	 * ������ʾ�����趨
	 *
	 * @param rwcontext ������ʾ����
	 */
	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	/**
	 * ��ʾ����ȡ��
	 *
	 * @return ��ʾ����
	 */
	public String getRwkey() {
		return rwkey;
	}

	/**
	 * ��ʾ�����趨
	 *
	 * @param rwkey ��ʾ����
	 */
	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rwid;
	}

	/**
	 * ��ʾ����ȡ��
	 * @return showTime ��ʾ����
	 */
	public String getShowTime() {
		if(StringUtils.isNotEmpty(this.ntime)){
			if(this.ntime.length() > 10){
				this.showTime = this.ntime.substring(0,10);
			}else{
				this.showTime = this.ntime;
			}
		}
		return showTime;
	}

	/**
	 * ��ʾ�����趨
	 * @param showTime ��ʾ����
	 */
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	
}