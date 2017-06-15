package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * 流程事件定义信息实体
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG413")
public class IG413TB extends BaseEntity implements Serializable,
		Cloneable, IG413Info {
	/**
	 * 流程事件定义ID
	 */
	@Id
	protected String pedid;

	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** 动作ID */
	protected String pedactionid;

	/** 事件类型 */
	protected String pedtype;

	/** 自定义BL名称 */
	protected String pedblid;

	/** 事件执行顺序 */
	protected Integer pedorder;
	
	/** 加入描述 */
	protected String pedec;

	public String getPedec() {
		return pedec;
	}

	public void setPedec(String pedec) {
		this.pedec = pedec;
	}

	/**
	 * 流程事件定义ID取得
	 * 
	 * @return 流程事件定义ID
	 */
	public String getPedid() {
		return pedid;
	}

	/**
	 * 流程事件定义ID设定
	 * 
	 * @param pedid流程事件定义ID
	 */
	public void setPedid(String pedid) {
		this.pedid = pedid;
	}

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 * 
	 * @param psdid状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 动作ID取得
	 * 
	 * @return 动作ID
	 */
	public String getPedactionid() {
		return pedactionid;
	}

	/**
	 * 动作ID设定
	 * 
	 * @param pedactionid动作ID
	 */
	public void setPedactionid(String pedactionid) {
		this.pedactionid = pedactionid;
	}

	/**
	 * 事件类型取得
	 * 
	 * @return 事件类型
	 */
	public String getPedtype() {
		return pedtype;
	}

	/**
	 * 事件类型设定
	 * 
	 * @param pedtype事件类型
	 */
	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	/**
	 * 自定义BL名称取得
	 * 
	 * @return 自定义BL名称
	 */
	public String getPedblid() {
		return pedblid;
	}

	/**
	 * 自定义BL名称设定
	 * 
	 * @param pedblid自定义BL名称
	 */
	public void setPedblid(String pedblid) {
		this.pedblid = pedblid;
	}

	/**
	 * 事件执行顺序取得
	 * 
	 * @return 事件执行顺序
	 */
	public Integer getPedorder() {
		return pedorder;
	}

	/**
	 * 事件执行顺序设定
	 * 
	 * @param pedorder事件执行顺序
	 */
	public void setPedorder(Integer pedorder) {
		this.pedorder = pedorder;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Serializable getPK() {
		return pedid;
	}

	/**
	 * 比较方法
	 * 
	 * @param obj流程事件定义信息
	 * @return 比较结果
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG413TB))
			return false;
		IG413Info target = (IG413Info) obj;
		if (!(getPedid() == target.getPedid()))
			return false;
		return true;
	}

}
