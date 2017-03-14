/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;

/**
  * ����: MSGFILTERʵ��
  * ��������: MSGFILTERʵ��
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="MSGFILTER")
public class MSGFILTERTB extends BaseEntity implements Serializable,
		Cloneable, MSGFILTERInfo {

	/** id */
	@Id
	@TableGenerator(
			name="MSGFILTER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="MSGFILTER_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSGFILTER_TABLE_GENERATOR")
	protected Integer id;

	/** deviceip */
	protected String deviceip;

	/** state */
	protected String state;

	/**
	 * idȡ��
	 *
	 * @return id
	 */


	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip() {
		return deviceip;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * deviceip�趨
	 *
	 * @param deviceip deviceip
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * stateȡ��
	 *
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * state�趨
	 *
	 * @param state state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}