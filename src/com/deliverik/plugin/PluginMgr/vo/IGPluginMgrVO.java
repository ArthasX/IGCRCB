/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.plugin.PluginMgr.model.IGPluginInfo;

/**
 * 概述: 插件类VO
 * 功能描述: 插件类VO
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public class IGPluginMgrVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 1L;
	protected List<IGPluginInfo> pluginList;
	//protected IGPluginForm igPluginForm;

	/**
	 * pluginList取得
	 *
	 * @return pluginList pluginList
	 */
	public List<IGPluginInfo> getPluginList() {
		return pluginList;
	}

	/**
	 * pluginList设定
	 *
	 * @param pluginList pluginList
	 */
	public void setPluginList(List<IGPluginInfo> pluginList) {
		this.pluginList = pluginList;
	}
}
