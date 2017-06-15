/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.VIM06Info;

/**
  * 概述: vim05实体
  * 功能描述: vim05实体
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="vim05")
public class VIM05TB extends BaseEntity implements Serializable,
		Cloneable, VIM05Info {

	/** id */
	@Id
	@TableGenerator(
		name="VIM05_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="VIM05_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="VIM05_TABLE_GENERATOR")
	protected Integer id;

	protected String name;
	
	protected String createtime;
	
	@Transient
	protected List<VIM06Info> configItemList;
	

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * id设定
	 *
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name设定
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public List<VIM06Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<VIM06Info> configItemList) {
		this.configItemList = configItemList;
	}
	
}