/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划表单信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0003")
public class IGDWP0003TB extends BaseEntity implements IGDWP0003Info{
	
	/** 主键 */
	@Id
	@TableGenerator(
		    name="IGDWP0003_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0003_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0003_TABLE_GENERATOR")
	protected Integer id;
	
	/** 流程信息主键 */
	protected Integer prid;
	
	/** 表单定义ID */
	protected String pidid;
	
	/** 表单值 */
	protected String pivarvalue;
	
	/** 附件key */
	protected String attkey;

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 流程信息主键取得
	 * @return prid 流程信息主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程信息主键设定
	 * @param prid 流程信息主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 表单定义ID取得
	 * @return pidid 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单值取得
	 * @return pivarvalue 表单值
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * 表单值设定
	 * @param pivarvalue 表单值
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * 附件key取得
	 * @return attkey 附件key
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件key设定
	 * @param attkey 附件key
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}
}
