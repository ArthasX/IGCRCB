/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top5统计实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Entity
public class ServiceTopFiveVW implements ServiceTopFiveVWInfo{

	/** 主键 */
	@Id
	protected Integer id;
	
	/** 时间总数 */
	protected Integer icount;
	
	/** 请求总数 */
	protected Integer scount;
	
	/** 服务工单总数 */
	protected Integer fcount;
	
	/** 机构码 */
	protected String orgid;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 总数 */
	protected Integer totalCount;

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
	 * 时间总数取得
	 * @return icount 时间总数
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * 时间总数设定
	 * @param icount 时间总数
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * 请求总数取得
	 * @return scount 请求总数
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * 请求总数设定
	 * @param scount 请求总数
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
	}

	/**
	 * 服务工单总数取得
	 * @return fcount 服务工单总数
	 */
	public Integer getFcount() {
		return fcount;
	}

	/**
	 * 服务工单总数设定
	 * @param fcount 服务工单总数
	 */
	public void setFcount(Integer fcount) {
		this.fcount = fcount;
	}

	/**
	 * 机构码取得
	 * @return orgid 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 总数取得
	 * @return totalCount 总数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 总数设定
	 * @param totalCount 总数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
