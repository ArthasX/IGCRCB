/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06361VO extends BaseVO{

	/** 部门服务统计数据集合 */
	private List<OrganizationServiceVWInfo> organizationServiceList;
	
	/** 事件总数 */
	private Integer icount;
	
	/** 服务请求总数 */
	private Integer scount;
	
	/** 工单数 */
	private Integer gcount;
	
	/** 总数 */
	private Integer totalCount;

	/**
	 * 部门服务统计数据集合取得
	 * @return organizationServiceList 部门服务统计数据集合
	 */
	public List<OrganizationServiceVWInfo> getOrganizationServiceList() {
		return organizationServiceList;
	}

	/**
	 * 部门服务统计数据集合设定
	 * @param organizationServiceList 部门服务统计数据集合
	 */
	public void setOrganizationServiceList(
			List<OrganizationServiceVWInfo> organizationServiceList) {
		this.organizationServiceList = organizationServiceList;
	}

	/**
	 * 事件总数取得
	 * @return icount 事件总数
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * 事件总数设定
	 * @param icount 事件总数
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * 服务请求总数取得
	 * @return scount 服务请求总数
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * 服务请求总数设定
	 * @param scount 服务请求总数
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
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

	public Integer getGcount() {
		return gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}
	
	
}
