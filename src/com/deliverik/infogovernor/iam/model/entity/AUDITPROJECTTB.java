/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;

/**
  * ����: ��Ʊ����ʵ��
  * ��������: ��Ʊ����ʵ��
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AUDITPROJECT")
public class AUDITPROJECTTB extends BaseEntity implements Serializable,
		Cloneable, AUDITPROJECTInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="AUDITPROJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="AUDITPROJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="AUDITPROJECT_TABLE_GENERATOR")
	protected Integer apid;

	/** ��Ʊ������� */
	protected String apreporttype;

	/** �����ĿID */
	protected Integer approjectid;

	/** ��Ŀ���� */
	protected String approjectname;

	/** ��Ŀ��� */
	protected String approjectyear;

	/** ��Ʊ��渽��KEY */
	protected String apattkey;
	
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getApid() {
		return apid;
	}

	/**
	 * �����趨
	 *
	 * @param apid ����
	 */
	public void setApid(Integer apid) {
		this.apid = apid;
	}

	/**
	 * ��Ʊ�������ȡ��
	 *
	 * @return ��Ʊ�������
	 */
	public String getApreporttype() {
		return apreporttype;
	}

	/**
	 * ��Ʊ��������趨
	 *
	 * @param apreporttype ��Ʊ�������
	 */
	public void setApreporttype(String apreporttype) {
		this.apreporttype = apreporttype;
	}

	/**
	 * �����ĿIDȡ��
	 *
	 * @return �����ĿID
	 */
	public Integer getApprojectid() {
		return approjectid;
	}

	/**
	 * �����ĿID�趨
	 *
	 * @param approjectid �����ĿID
	 */
	public void setApprojectid(Integer approjectid) {
		this.approjectid = approjectid;
	}

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public String getApprojectname() {
		return approjectname;
	}

	/**
	 * ��Ŀ�����趨
	 *
	 * @param approjectname ��Ŀ����
	 */
	public void setApprojectname(String approjectname) {
		this.approjectname = approjectname;
	}

	/**
	 * ��Ŀ���ȡ��
	 *
	 * @return ��Ŀ���
	 */
	public String getApprojectyear() {
		return approjectyear;
	}

	/**
	 * ��Ŀ����趨
	 *
	 * @param approjectyear ��Ŀ���
	 */
	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}

	/**
	 * ��Ʊ��渽��KEYȡ��
	 *
	 * @return ��Ʊ��渽��KEY
	 */
	public String getApattkey() {
		return apattkey;
	}

	/**
	 * ��Ʊ��渽��KEY�趨
	 *
	 * @param apattkey ��Ʊ��渽��KEY
	 */
	public void setApattkey(String apattkey) {
		this.apattkey = apattkey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return apid;
	}
	
}