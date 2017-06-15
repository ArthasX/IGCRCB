/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: AutoTask�ӿ�
  * ��������: AutoTask�ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface AutoTaskInfo extends BaseModel {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * taskNameȡ��
	 *
	 * @return taskName
	 */
	public String getTaskName();

	/**
	 * businessSystemidȡ��
	 *
	 * @return businessSystemid
	 */
	public Integer getBusinessSystemid();

	/**
	 * hostsȡ��
	 *
	 * @return hosts
	 */
	public String getHosts();

	/**
	 * excutetimeȡ��
	 *
	 * @return excutetime
	 */
	public String getExcutetime();

	/**
	 * scriptPathȡ��
	 *
	 * @return scriptPath
	 */
	public String getScriptPath();

	/**
	 * versionȡ��
	 *
	 * @return version
	 */
	public String getVersion();
	
	
	public String getScriptParam();
	
	public String getRdpFilePath();
	
	public String getResultLogPath();
	
	public String getCurrentFilePath();
	
	public Integer getState();
	
	public String getScriptname();
	
	public String getBsmname();
	
}