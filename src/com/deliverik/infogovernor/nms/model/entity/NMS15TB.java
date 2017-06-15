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
import com.deliverik.infogovernor.nms.model.NMS15Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自动发现记录实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS15")
public class NMS15TB extends BaseEntity implements NMS15Info {

	/** 主键 */
	@Id
	@TableGenerator(
			name="NMS15_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS15_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS15_TABLE_GENERATOR")
	protected Integer id;
	
	/** 任务版本 */
	protected Integer rversion;

	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/** 开始时间 */
	protected String starttime;
	
	/** 结束时间 */
	protected String endtime;
	
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
	 * 任务版本取得
	 * @return rversion 任务版本
	 */
	public Integer getRversion() {
		return rversion;
	}

	/**
	 * 任务版本设定
	 * @param rversion 任务版本
	 */
	public void setRversion(Integer rversion) {
		this.rversion = rversion;
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
	 * 开始时间取得
	 * @return starttime 开始时间
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * 开始时间设定
	 * @param starttime 开始时间
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * 结束时间取得
	 * @return endtime 结束时间
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * 结束时间设定
	 * @param endtime 结束时间
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}

}
