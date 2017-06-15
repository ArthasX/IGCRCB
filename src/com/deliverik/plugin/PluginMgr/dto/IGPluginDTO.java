/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.plugin.PluginMgr.model.IGPluginInfo;

/**
 * 概述: 插件类DTO
 * 功能描述: 插件类DTO
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public class IGPluginDTO extends BaseDTO {
	/**  */
	private static final long serialVersionUID = 1L;
	
	
	protected String status;
	protected String path;
	
	protected List<IGPluginInfo> pluginList;

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

	/**
	 * status取得
	 *
	 * @return status status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * path取得
	 *
	 * @return path path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * status设定
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * path设定
	 *
	 * @param path path
	 */
	public void setPath(String path) {
		this.path = path;
	}


}
