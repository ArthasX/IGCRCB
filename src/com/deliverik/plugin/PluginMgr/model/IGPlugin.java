/*
 * ��������������������޹�˾��
 */
package com.deliverik.plugin.PluginMgr.model;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ���form
 * ��������: ���form
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public class IGPlugin extends BaseForm implements IGPluginInfo {
	/**  */
	private static final long serialVersionUID = 1L;
	/**������*/
	protected String pluginNum;
	/**�������*/
	protected String pluginName;
	/**���·��*/
	protected String pluginPath;
	/**״̬*/
	protected String pluginStatus;
	/**
	 * pluginNumȡ��
	 *
	 * @return pluginNum pluginNum
	 */
	public String getPluginNum() {
		return pluginNum;
	}
	/**
	 * pluginNameȡ��
	 *
	 * @return pluginName pluginName
	 */
	public String getPluginName() {
		return pluginName;
	}
	/**
	 * pluginPathȡ��
	 *
	 * @return pluginPath pluginPath
	 */
	public String getPluginPath() {
		return pluginPath;
	}
	/**
	 * pluginStatusȡ��
	 *
	 * @return pluginStatus pluginStatus
	 */
	public String getPluginStatus() {
		return pluginStatus;
	}
	/**
	 * pluginNum�趨
	 *
	 * @param pluginNum pluginNum
	 */
	public void setPluginNum(String pluginNum) {
		this.pluginNum = pluginNum;
	}
	/**
	 * pluginName�趨
	 *
	 * @param pluginName pluginName
	 */
	public void setPluginName(String pluginName) {
		this.pluginName = pluginName;
	}
	/**
	 * pluginPath�趨
	 *
	 * @param pluginPath pluginPath
	 */
	public void setPluginPath(String pluginPath) {
		this.pluginPath = pluginPath;
	}
	/**
	 * pluginStatus�趨
	 *
	 * @param pluginStatus pluginStatus
	 */
	public void setPluginStatus(String pluginStatus) {
		this.pluginStatus = pluginStatus;
	}
	/* (non-Jsdoc)
	 * override
	 */
	public String getFingerPrint() {
		//
		return null;
	}
	
	//***/
	//***/
	
}
