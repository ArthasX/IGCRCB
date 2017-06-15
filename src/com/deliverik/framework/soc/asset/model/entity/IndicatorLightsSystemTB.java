/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��ʵ��
  * ��������: �澯ϵͳ��ʾ��Ϣ��ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IndicatorLightsSystem")
public class IndicatorLightsSystemTB extends BaseEntity implements Serializable,
		Cloneable, IndicatorLightsSystemInfo {

	/** ����˼���� */
	@Id
	@TableGenerator(
		name="INDICATORLIGHTSSYSTEM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INDICATORLIGHTSSYSTEM_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INDICATORLIGHTSSYSTEM_TABLE_GENERATOR")
	protected Integer ilsid;

	/** ϵͳ���� */
	protected String ilsname;

	/** λ��X */
	protected Integer ilsplacex;

	/** λ��Y */
	protected Integer ilsplacey;

	/** ״̬ */
	protected String ilsstatus;

	/**
	 * ����˼����ȡ��
	 *
	 * @return ����˼����
	 */
	public Integer getIlsid() {
		return ilsid;
	}

	/**
	 * ����˼�����趨
	 *
	 * @param ilsid ����˼����
	 */
	public void setIlsid(Integer ilsid) {
		this.ilsid = ilsid;
	}

	/**
	 * ϵͳ����ȡ��
	 *
	 * @return ϵͳ����
	 */
	public String getIlsname() {
		return ilsname;
	}

	/**
	 * ϵͳ�����趨
	 *
	 * @param ilsname ϵͳ����
	 */
	public void setIlsname(String ilsname) {
		this.ilsname = ilsname;
	}

	/**
	 * λ��Xȡ��
	 *
	 * @return λ��X
	 */
	public Integer getIlsplacex() {
		return ilsplacex;
	}

	/**
	 * λ��X�趨
	 *
	 * @param ilsplacex λ��X
	 */
	public void setIlsplacex(Integer ilsplacex) {
		this.ilsplacex = ilsplacex;
	}

	/**
	 * λ��Yȡ��
	 *
	 * @return λ��Y
	 */
	public Integer getIlsplacey() {
		return ilsplacey;
	}

	/**
	 * λ��Y�趨
	 *
	 * @param ilsplacey λ��Y
	 */
	public void setIlsplacey(Integer ilsplacey) {
		this.ilsplacey = ilsplacey;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getIlsstatus() {
		return ilsstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param ilsstatus ״̬
	 */
	public void setIlsstatus(String ilsstatus) {
		this.ilsstatus = ilsstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ilsid;
	}

}