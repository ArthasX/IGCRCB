/*
 * ��������������������޹�˾��
 */
package com.deliverik.plugin.PluginMgr.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.plugin.PluginMgr.model.IGPluginInfo;

/**
 * ����: �����DTO
 * ��������: �����DTO
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public class IGPluginDTO extends BaseDTO {
	/**  */
	private static final long serialVersionUID = 1L;
	
	
	protected String status;
	protected String path;
	
	protected List<IGPluginInfo> pluginList;

	/**
	 * pluginListȡ��
	 *
	 * @return pluginList pluginList
	 */
	public List<IGPluginInfo> getPluginList() {
		return pluginList;
	}

	/**
	 * pluginList�趨
	 *
	 * @param pluginList pluginList
	 */
	public void setPluginList(List<IGPluginInfo> pluginList) {
		this.pluginList = pluginList;
	}

	/**
	 * statusȡ��
	 *
	 * @return status status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * pathȡ��
	 *
	 * @return path path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * status�趨
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * path�趨
	 *
	 * @param path path
	 */
	public void setPath(String path) {
		this.path = path;
	}


}
