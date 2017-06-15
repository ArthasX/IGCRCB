/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: MSGFILTER实体
  * 功能描述: MSGFILTER实体
  * 创建记录: 2013/08/21
  * 修改记录: 
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
	 * id取得
	 *
	 * @return id
	 */


	/**
	 * deviceip取得
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
	 * deviceip设定
	 *
	 * @param deviceip deviceip
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * state取得
	 *
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * state设定
	 *
	 * @param state state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

}