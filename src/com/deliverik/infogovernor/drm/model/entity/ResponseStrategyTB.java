/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;

/**
  * ����: ������Ӧ����ʵ��
  * ��������: ������Ӧ����ʵ��
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ResponseStrategy")
public class ResponseStrategyTB extends BaseEntity implements Serializable,
		Cloneable, ResponseStrategyInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="RESPONSESTRATEGY_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RESPONSESTRATEGY_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RESPONSESTRATEGY_TABLE_GENERATOR")
	protected Integer rsid;

	/** ����id */
	protected Integer senceid;

	/** �������� */
	protected String strategyDesc;

	/** �ؼ��� */
	protected String keyword;

	/** ���⴦���� */
	protected String handleBL;

	/**���⴦�����һ�»��߷ָ�*/
	protected String rsargs;
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRsid() {
		return rsid;
	}

	public String getRsargs() {
		return rsargs;
	}

	public void setRsargs(String rsargs) {
		this.rsargs = rsargs;
	}

	/**
	 * �����趨
	 *
	 * @param rsid ����
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getSenceid() {
		return senceid;
	}

	/**
	 * ����id�趨
	 *
	 * @param senceid ����id
	 */
	public void setSenceid(Integer senceid) {
		this.senceid = senceid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getStrategyDesc() {
		return strategyDesc;
	}

	/**
	 * ���������趨
	 *
	 * @param strategyDesc ��������
	 */
	public void setStrategyDesc(String strategyDesc) {
		this.strategyDesc = strategyDesc;
	}

	/**
	 * �ؼ���ȡ��
	 *
	 * @return �ؼ���
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * �ؼ����趨
	 *
	 * @param keyword �ؼ���
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * ���⴦����ȡ��
	 *
	 * @return ���⴦����
	 */
	public String getHandleBL() {
		return handleBL;
	}

	/**
	 * ���⴦�����趨
	 *
	 * @param handleBL ���⴦����
	 */
	public void setHandleBL(String handleBL) {
		this.handleBL = handleBL;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rsid;
	}

}