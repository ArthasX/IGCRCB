/*
 * ��������������������޹�˾��
 */
package com.deliverik.plugin.PluginMgr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.plugin.PluginMgr.model.IGPluginInfo;

/**
 * ����: �����VO
 * ��������: �����VO
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public class IGPluginMgrVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 1L;
	protected List<IGPluginInfo> pluginList;
	//protected IGPluginForm igPluginForm;

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
}
