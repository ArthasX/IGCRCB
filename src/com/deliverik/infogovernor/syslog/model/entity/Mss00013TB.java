/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;

/**
  * 概述: mss00013实体
  * 功能描述: mss00013实体
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="mss00013")
public class Mss00013TB extends BaseEntity implements Serializable,
		Cloneable, Mss00013Info {

	/** id */
	@Id
	@TableGenerator(
			name="MSS00013_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
			pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
			pkColumnValue="MSS00013_SEQUENCE", initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MSS00013_TABLE_GENERATOR")
	protected Integer id;

	/** deviceip */
	protected String deviceip;

	/** rulelevel */
	protected String rulelevel;

	/** alarmmsg */
	protected String alarmmsg;

	





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip() {
		return deviceip;
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
	 * rulelevel取得
	 *
	 * @return rulelevel
	 */
	public String getRulelevel() {
		return rulelevel;
	}

	/**
	 * rulelevel设定
	 *
	 * @param rulelevel rulelevel
	 */
	public void setRulelevel(String rulelevel) {
		this.rulelevel = rulelevel;
	}

	/**
	 * alarmmsg取得
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg() {
		return alarmmsg;
	}

	/**
	 * alarmmsg设定
	 *
	 * @param alarmmsg alarmmsg
	 */
	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
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