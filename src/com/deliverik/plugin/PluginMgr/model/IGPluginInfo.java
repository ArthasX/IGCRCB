/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.model;

import com.deliverik.framework.base.BaseModel;


/**
 * 概述: 插件form
 * 功能描述: 插件form
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public interface IGPluginInfo extends BaseModel{
	/**
	 * pluginNum取得
	 *
	 * @return pluginNum pluginNum
	 */
	public String getPluginNum();
	/**
	 * pluginName取得
	 *
	 * @return pluginName pluginName
	 */
	public String getPluginName();
	/**
	 * pluginPath取得
	 *
	 * @return pluginPath pluginPath
	 */
	public String getPluginPath();
	/**
	 * pluginStatus取得
	 *
	 * @return pluginStatus pluginStatus
	 */
	public String getPluginStatus();

	
	//***/
	//***/
	
}
