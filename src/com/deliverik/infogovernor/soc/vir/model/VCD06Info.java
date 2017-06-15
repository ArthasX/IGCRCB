/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:vCloud组织与平台机构对照实体接口 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface VCD06Info extends BaseModel{
	
	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * vCloud组织取得
	 * @return vorg vCloud组织
	 */
	public String getVorg();

	/**
	 * 机构吗取得
	 * @return orgsyscoding 机构吗
	 */
	public String getOrgsyscoding();

	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname();
}
