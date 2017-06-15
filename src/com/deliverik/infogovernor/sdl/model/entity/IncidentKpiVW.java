/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.infogovernor.sdl.model.IncidentKpi;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_ͳ�ƻ���_�¼�kpi��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@IdClass(IncidentKpiVWPK.class)
@Entity
//public class IncidentKpiVW extends BaseEntity implements Serializable, Cloneable, IncidentKpi {
public class IncidentKpiVW implements Serializable, Cloneable, IncidentKpi {
	
	/**���ID */
	protected String typeId;
	
	/** �������*/
	protected String typeName;
	@Id
	/**�����̶�*/
	protected String urgency;
	
	/**ƽ�����ʱ��*/
	protected Float resolve;
	@Id
	/**�������*/
	protected String syscoding;
	
	/**�����̶�����*/
	protected String urgencyName;
	
	public Serializable getPK() {
		return typeId;
	}

	/**
	 * ��ȡ���ID
	 * @return ���ID
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * �������ID
	 * @param typeId ���ID
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * �����������
	 * @param typeName �������
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * ��ȡ�����̶�
	 * @return �����̶�
	 */
	public String getUrgency() {
		return urgency;
	}

	/**
	 * ���ý����̶�
	 * @param urgency �����̶�
	 */
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	/**
	 * ��ȡƽ�����ʱ��
	 * @return ƽ�����ʱ��
	 */
	public Float getResolve() {
		return resolve;
	}

	/**
	 * ����ƽ�����ʱ��
	 * @param resolve ƽ�����ʱ��
	 */
	public void setResolve(Float resolve) {
		this.resolve = resolve;
	}

	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * �����������
	 * @param syscoding �������
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * ��ȡ�����̶�����
	 * @return �����̶�����
	 */
	public String getUrgencyName() {
		return urgencyName;
	}

	/**
	 * ���ý����̶�����
	 * @param urgencyName �����̶�����
	 */
	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}
	
}
