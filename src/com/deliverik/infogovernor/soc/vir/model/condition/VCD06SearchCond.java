/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vCloud组织与平台机构对照实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface VCD06SearchCond {

	/**
	 * 组织集合取得
	 * @return vorgs 组织集合
	 */
	public List<String> getVorgs();
}
