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
 * Description: vCloud组织与平台机构对照实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VCD06SearchCondImpl implements VCD06SearchCond {

	/** 组织集合 */
	protected List<String> vorgs;

	/**
	 * 组织集合取得
	 * @return vorgs 组织集合
	 */
	public List<String> getVorgs() {
		return vorgs;
	}

	/**
	 * 组织集合设定
	 * @param vorgs 组织集合
	 */
	public void setVorgs(List<String> vorgs) {
		this.vorgs = vorgs;
	}
}
