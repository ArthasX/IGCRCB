/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS01Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS01",schema = "ig")
public class NMS01TB extends BaseEntity implements NMS01Info {
	
	/** 主键 */
	@Id
	@TableGenerator(
			name="NMS01_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS01_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS01_TABLE_GENERATOR")
	protected Integer id;
	
	/** 组名称 */
	protected String name;
	
	/** 上级组 */
	protected Integer parentid;
	
	/** 备注 */
	protected String remark;
	
	/** 版本 */
	protected Integer version;
	
	/** 创建时间 */
	protected String instime;
	
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
	 * 组名称取得
	 * @return name 组名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 组名称设定
	 * @param name 组名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 上级组取得
	 * @return parentid 上级组
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * 上级组设定
	 * @param parentid 上级组
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * 备注取得
	 * @return remark 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注设定
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * 创建时间设定
	 * @param instime 创建时间
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}
