/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;

/**
  * ����: ��Ŀ��־�����ʵ��
  * ��������: ��Ŀ��־�����ʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ProjectLogBusiness")
public class ProjectLogBusinessTB extends BaseEntity implements Serializable,
		Cloneable, ProjectLogBusinessInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="PROJECTLOGBUSINESS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROJECTLOGBUSINESS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECTLOGBUSINESS_TABLE_GENERATOR")
	protected Integer plbid;

	/** ��ͬ�ܶ� */
	protected Double plbplcsum;

	/** һ�ڸ����� */
	protected Double plbfirst;

	/** ���ڸ����� */
	protected Double plbsecond;

	/** ���ڸ����� */
	protected Double plbthird;

	/** ���ڸ����� */
	protected Double plbfourth;

	/** ���ڸ����� */
	protected Double plbfifth;
	
	/** ��Ӧ��Ŀid */
	protected Integer plbpid;

	/** ��Ӧ��Ŀ��־id */
	protected Integer plbplid;

	/** �Ѹ����ܶ� */
	protected Double plbsum;

	/** �Ѹ������ */
	protected Double plbscale;

	/** δ�����ܶ� */
	protected Double plbnotsum;

	/** δ������� */
	protected Double plbnotscale;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPlbid() {
		return plbid;
	}

	/**
	 * �����趨
	 *
	 * @param plbid ����
	 */
	public void setPlbid(Integer plbid) {
		this.plbid = plbid;
	}

	/**
	 * ��ͬ�ܶ�ȡ��
	 *
	 * @return ��ͬ�ܶ�
	 */
	public Double getPlbplcsum() {
		return plbplcsum;
	}

	/**
	 * ��ͬ�ܶ��趨
	 *
	 * @param plbplcsum ��ͬ�ܶ�
	 */
	public void setPlbplcsum(Double plbplcsum) {
		this.plbplcsum = plbplcsum;
	}

	/**
	 * һ�ڸ�����ȡ��
	 *
	 * @return һ�ڸ�����
	 */
	public Double getPlbfirst() {
		return plbfirst;
	}

	/**
	 * һ�ڸ������趨
	 *
	 * @param plbfirst һ�ڸ�����
	 */
	public void setPlbfirst(Double plbfirst) {
		this.plbfirst = plbfirst;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbsecond() {
		return plbsecond;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plbsecond ���ڸ�����
	 */
	public void setPlbsecond(Double plbsecond) {
		this.plbsecond = plbsecond;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbthird() {
		return plbthird;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plbthird ���ڸ�����
	 */
	public void setPlbthird(Double plbthird) {
		this.plbthird = plbthird;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbfourth() {
		return plbfourth;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plbfourth ���ڸ�����
	 */
	public void setPlbfourth(Double plbfourth) {
		this.plbfourth = plbfourth;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlbfifth() {
		return plbfifth;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plbfifth ���ڸ�����
	 */
	public void setPlbfifth(Double plbfifth) {
		this.plbfifth = plbfifth;
	}
	
	/**
	 * ��Ӧ��Ŀidȡ��
	 *
	 * @return ��Ӧ��Ŀid
	 */
	public Integer getPlbpid() {
		return plbpid;
	}

	/**
	 * ��Ӧ��Ŀid�趨
	 *
	 * @param plbplid ��Ӧ��Ŀ��־id
	 */
	public void setPlbpid(Integer plbpid) {
		this.plbpid = plbpid;
	}

	/**
	 * ��Ӧ��Ŀ��־idȡ��
	 *
	 * @return ��Ӧ��Ŀ��־id
	 */
	public Integer getPlbplid() {
		return plbplid;
	}

	/**
	 * ��Ӧ��Ŀ��־id�趨
	 *
	 * @param plbplid ��Ӧ��Ŀ��־id
	 */
	public void setPlbplid(Integer plbplid) {
		this.plbplid = plbplid;
	}

	/**
	 * �Ѹ����ܶ�ȡ��
	 *
	 * @return �Ѹ����ܶ�
	 */
	public Double getPlbsum() {
		return plbsum;
	}

	/**
	 * �Ѹ����ܶ��趨
	 *
	 * @param plbsum �Ѹ����ܶ�
	 */
	public void setPlbsum(Double plbsum) {
		this.plbsum = plbsum;
	}

	/**
	 * �Ѹ������ȡ��
	 *
	 * @return �Ѹ������
	 */
	public Double getPlbscale() {
		return plbscale;
	}

	/**
	 * �Ѹ�������趨
	 *
	 * @param plbscale �Ѹ������
	 */
	public void setPlbscale(Double plbscale) {
		this.plbscale = plbscale;
	}

	/**
	 * δ�����ܶ�ȡ��
	 *
	 * @return δ�����ܶ�
	 */
	public Double getPlbnotsum() {
		return plbnotsum;
	}

	/**
	 * δ�����ܶ��趨
	 *
	 * @param plbnotsum δ�����ܶ�
	 */
	public void setPlbnotsum(Double plbnotsum) {
		this.plbnotsum = plbnotsum;
	}

	/**
	 * δ�������ȡ��
	 *
	 * @return δ�������
	 */
	public Double getPlbnotscale() {
		return plbnotscale;
	}

	/**
	 * δ��������趨
	 *
	 * @param plbnotscale δ�������
	 */
	public void setPlbnotscale(Double plbnotscale) {
		this.plbnotscale = plbnotscale;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return plbid;
	}

}