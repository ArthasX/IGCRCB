/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 插件form
 * 功能描述: 插件form
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public class IGPluginForm extends BaseForm {
	/**  */
	private static final long serialVersionUID = 1L;
	/**插件编号*/
	protected String pluginNum;
	/**插件名称*/
	protected String pluginName;
	/**插件路径*/
	protected String pluginPath;
	/**状态*/
	protected String pluginStatus;
	/**
	 * pluginNum取得
	 *
	 * @return pluginNum pluginNum
	 */
	public String getPluginNum() {
		return pluginNum;
	}
	/**
	 * pluginName取得
	 *
	 * @return pluginName pluginName
	 */
	public String getPluginName() {
		return pluginName;
	}
	/**
	 * pluginPath取得
	 *
	 * @return pluginPath pluginPath
	 */
	public String getPluginPath() {
		return pluginPath;
	}
	/**
	 * pluginStatus取得
	 *
	 * @return pluginStatus pluginStatus
	 */
	public String getPluginStatus() {
		return pluginStatus;
	}
	/**
	 * pluginNum设定
	 *
	 * @param pluginNum pluginNum
	 */
	public void setPluginNum(String pluginNum) {
		this.pluginNum = pluginNum;
	}
	/**
	 * pluginName设定
	 *
	 * @param pluginName pluginName
	 */
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}
	/**
	 * pluginPath设定
	 *
	 * @param pluginPath pluginPath
	 */
	public void setPluginPath(String pluginPath) {
		this.pluginPath = pluginPath;
	}
	/**
	 * pluginStatus设定
	 *
	 * @param pluginStatus pluginStatus
	 */
	public void setPluginStatus(String pluginStatus) {
		this.pluginStatus = pluginStatus;
	}
	
	//***/
	//***/
	
}
