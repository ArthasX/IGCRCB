/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG256Info;

/**
  * ����: ���̲�������ʵ��
  * ��������: ���̲�������ʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG256")
public class IG256TB extends BaseEntity implements Serializable,
		Cloneable, IG256Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG256_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG256_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG256_TABLE_GENERATOR")
	protected Integer fnid;

	/** ���̱����� */
	protected Integer prid;

	/** �������ͱ����� */
	protected String pdid;

	/** ���̼�¼״̬ */
	protected String prstatus;

	/** ��ǰ���̲�����id */
	protected String ppuserid;
	
	/** ��ǰ���̲��������� */
	protected String ppusername;

	/** ��ʶ */
	protected String flag;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getFnid() {
		return fnid;
	}

	/**
	 * �����趨
	 *
	 * @param fnid ����
	 */
	public void setFnid(Integer fnid) {
		this.fnid = fnid;
	}

	/**
	 * ���̱�����ȡ��
	 *
	 * @return ���̱�����
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̱������趨
	 *
	 * @param prid ���̱�����
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �������ͱ�����ȡ��
	 *
	 * @return �������ͱ�����
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������ͱ������趨
	 *
	 * @param pdid �������ͱ�����
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̼�¼״̬ȡ��
	 *
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̼�¼״̬�趨
	 *
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��ǰ���̲�����idȡ��
	 *
	 * @return ��ǰ���̲�����id
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ��ǰ���̲�����id�趨
	 *
	 * @param ppuserid ��ǰ���̲�����id
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ��ǰ���̲���������ȡ��
	 *
	 * @return ��ǰ���̲���������
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * ��ǰ���̲����������趨
	 *
	 * @param ppuserid ��ǰ���̲���������
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * ��ʶȡ��
	 *
	 * @return ��ʶ
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ��ʶ�趨
	 *
	 * @param flag ��ʶ
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return fnid;
	}

}