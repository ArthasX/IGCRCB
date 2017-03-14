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
 * Description: 设备MAC/IP信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS06Info extends BaseModel {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public String getId();

	/**
	 * 设备ID取得
	 * @return did 设备ID
	 */
	public String getDid();

	/**
	 * IP取得
	 * @return ip IP
	 */
	public String getIp();

	/**
	 * MAC地址取得
	 * @return mac MAC地址
	 */
	public String getMac();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
}
