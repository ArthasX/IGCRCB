/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS02SearchCond {

	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag();

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
	 * V3安全用户取得
	 * @return V3安全用户
	 */
	public String getSnmpUser();

	/**
	 * V3身份验证密码取得
	 * @return V3身份验证密码
	 */
	public String getSnmpPassword();

}
