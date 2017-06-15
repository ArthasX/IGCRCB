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
 * Description: 发现任务信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS03Info extends BaseModel {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();
	
	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid();
	
	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion();

	/**
	 * 任务类型取得
	 * @return type 任务类型
	 */
	public String getType();

	/**
	 * 是否启用PING取得
	 * @return isEnablePing 是否启用PING
	 */
	public String getIsEnablePing() ;

	/**
	 * 是否启用ARP取得
	 * @return isEnableArp 是否启用ARP
	 */
	public String getIsEnableArp();

	/**
	 * 起始IP取得
	 * @return fromIP 起始IP
	 */
	public String getFromIP();

	/**
	 * 结束IP取得
	 * @return toIP 结束IP
	 */
	public String getToIP();

	/**
	 * 子网取得
	 * @return subNet 子网
	 */
	public String getSubNet();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
	
	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag();

}
