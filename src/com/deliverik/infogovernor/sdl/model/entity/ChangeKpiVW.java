/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sdl.model.ChangeKpi;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_ͳ�ƻ���_���kpi��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class ChangeKpiVW implements Serializable, Cloneable, ChangeKpi {

	@Id
	/**����ID */
	protected Integer typeId;
	
	/** ��������*/
	protected String typeName;

	/**�ɹ���״̬*/
	protected Integer success;
	
	/**����������״̬*/
	protected Integer problem;
	
	/**ʧ����״̬*/
	protected Integer fail;
	
	public Serializable getPK() {
		return typeId;
	}

	/**
	 * ��ȡ����ID
	 * @return ����ID
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * ��������ID
	 * @param typeId ����ID
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * ��ȡ����ID
	 * @return ����ID
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * ��������ID
	 * @param typeId ����ID
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	/**
	 * ��ȡ�ɹ���״̬
	 * @return �ɹ���״̬
	 */
	public Integer getSuccess() {
		return success;
	}

	/**
	 * ���óɹ���״̬
	 * @param success �ɹ���״̬
	 */
	public void setSuccess(Integer success) {
		this.success = success;
	}


	/**
	 * ��ȡ����������״̬
	 * @return ����������״̬
	 */
	public Integer getProblem() {
		return problem;
	}

	/**
	 * ���ô���������״̬
	 * @param problem ����������״̬
	 */
	public void setProblem(Integer problem) {
		this.problem = problem;
	}


	/**
	 * ��ȡʧ����״̬
	 * @return ʧ����״̬
	 */
	public Integer getFail() {
		return fail;
	}

	/**
	 * ����ʧ����״̬
	 * @param fail ʧ����״̬
	 */
	public void setFail(Integer fail) {
		this.fail = fail;
	}
	
}
