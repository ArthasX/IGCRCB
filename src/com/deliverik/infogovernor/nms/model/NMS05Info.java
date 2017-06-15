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
 * Description: 设备组关系信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS05Info extends BaseModel {

	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid();

	/**
	 * 设备ID取得
	 * @return did 设备ID
	 */
	public String getDid();

	/**
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion();

	/**
	 * 显示IP取得
	 * @return ip 显示IP
	 */
	public String getIp();

	/**
	 * 显示MAC地址取得
	 * @return mac 显示MAC地址
	 */
	public String getMac();

	/**
	 * SNMP信息取得
	 * @return snmpid SNMP信息
	 */
	public String getSnmpid();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
}
