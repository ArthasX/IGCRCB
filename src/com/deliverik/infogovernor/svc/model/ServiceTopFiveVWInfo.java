/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top5统计实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ServiceTopFiveVWInfo {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 时间总数取得
	 * @return icount 时间总数
	 */
	public Integer getIcount();

	/**
	 * 请求总数取得
	 * @return scount 请求总数
	 */
	public Integer getScount();

	/**
	 * 服务工单总数取得
	 * @return fcount 服务工单总数
	 */
	public Integer getFcount();

	/**
	 * 机构码取得
	 * @return orgid 机构码
	 */
	public String getOrgid();

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname();

	/**
	 * 总数取得
	 * @return totalCount 总数
	 */
	public Integer getTotalCount();
}
