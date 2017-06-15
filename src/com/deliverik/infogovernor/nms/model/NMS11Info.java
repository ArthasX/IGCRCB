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
 * Description: 任务日志实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS11Info extends BaseModel {

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
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion();

	/**
	 * 日志信息取得
	 * @return msg 日志信息
	 */
	public String getMsg();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
}
