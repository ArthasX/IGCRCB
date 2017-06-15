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
import com.deliverik.infogovernor.nms.model.NMS11Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务日志实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS11")
public class NMS11TB extends BaseEntity implements NMS11Info {
	
	/** 主键 */
	@Id
	@TableGenerator(
			name="NMS11_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS11_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS11_TABLE_GENERATOR")
	protected Integer id;
	
	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/** 日志信息 */
	protected String msg;
	
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
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 组ID设定
	 * @param gid 组ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * 组版本设定
	 * @param gversion 组版本
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

	/**
	 * 日志信息取得
	 * @return msg 日志信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 日志信息设定
	 * @param msg 日志信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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
