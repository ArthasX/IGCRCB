/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS02Info extends BaseModel {

	/**
	 * 主键取得
	 * @return 主键
	 */
	public String getId();

	/**
	 * SNMP版本取得
	 * @return SNMP版本
	 */
	public Integer getSnmpVersion();

	/**
	 * 端口取得
	 * @return 端口
	 */
	public Integer getSnmpPort();

	/**
	 * 读取团体字取得
	 * @return 读取团体字
	 */
	public String getReadCommit();

	/**
	 * 写入团体字取得
	 * @return 写入团体字
	 */
	public String getWriteCommit();

	/**
	 * 是否启用SNMP代理取得
	 * @return 是否启用SNMP代理
	 */
	public String getIsEnableSnmpProxy();

	/**
	 * 代理IP取得
	 * @return 代理IP
	 */
	public String getSnmpProxyIP();

	/**
	 * V3安全级别取得
	 * @return V3安全级别
	 */
	public String getSnmpSecurityLevel();

	/**
	 * V3安全用户取得
	 * @return V3安全用户
	 */
	public String getSnmpUser();

	/**
	 * V3上下文名称取得
	 * @return V3上下文名称
	 */
	public String getSnmpSecurityContext();

	/**
	 * V3上下文名称设定
	 * @param snmpSecurityContext V3上下文名称
	 */
	public void setSnmpSecurityContext(String snmpSecurityContext);

	/**
	 * V3身份验证协议取得
	 * @return V3身份验证协议
	 */
	public String getSnmpAuthType();

	/**
	 * V3身份验证密码取得
	 * @return V3身份验证密码
	 */
	public String getSnmpPassword();

	/**
	 * V3隐私协议取得
	 * @return V3隐私协议
	 */
	public String getSnmpPrivacyType();

	/**
	 * V3隐私密码取得
	 * @return V3隐私密码
	 */
	public String getSnmpPrivacyPassPhrase();

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getInstime();
	
	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag();
}
