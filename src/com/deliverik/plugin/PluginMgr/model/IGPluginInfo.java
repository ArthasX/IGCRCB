/*
 * ��������������������޹�˾��
 */
package com.deliverik.plugin.PluginMgr.model;

import com.deliverik.framework.base.BaseModel;


/**
 * ����: ���form
 * ��������: ���form
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public interface IGPluginInfo extends BaseModel{
	/**
	 * pluginNumȡ��
	 *
	 * @return pluginNum pluginNum
	 */
	public String getPluginNum();
	/**
	 * pluginNameȡ��
	 *
	 * @return pluginName pluginName
	 */
	public String getPluginName();
	/**
	 * pluginPathȡ��
	 *
	 * @return pluginPath pluginPath
	 */
	public String getPluginPath();
	/**
	 * pluginStatusȡ��
	 *
	 * @return pluginStatus pluginStatus
	 */
	public String getPluginStatus();

	
	//***/
	//***/
	
}
