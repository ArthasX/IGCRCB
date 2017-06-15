/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;

/**
  * 概述: 对比域实体
  * 功能描述: 对比域实体
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="comparescope")
public class ComparescopeTB extends BaseEntity implements Serializable,
		Cloneable, ComparescopeInfo {

	/** 主键 */
	@Id
	@GeneratedValue(generator = "csid")
	@GenericGenerator(name = "csid", strategy = "sequence", 
			parameters = { @Parameter(name = "sequence", 
						value = "comparescope_seq") })
	protected Integer csid;

	/** 名称 */
	protected String csname;
	
	protected String createtime;
	
	protected Integer csversion;
	
	

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * 主键设定
	 *
	 * @param csid 主键
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getCsname() {
		return csname;
	}

	/**
	 * 名称设定
	 *
	 * @param csname 名称
	 */
	public void setCsname(String csname) {
		this.csname = csname;
	}

	
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getCsversion() {
		return csversion;
	}

	public void setCsversion(Integer csversion) {
		this.csversion = csversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	@Override
	public Serializable getPK() {
		return csid;
	}

	
}