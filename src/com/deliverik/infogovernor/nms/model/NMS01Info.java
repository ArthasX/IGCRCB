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
 * Description: 组信息实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS01Info extends BaseModel {

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();

	/**
	 * 组名称取得
	 * @return name 组名称
	 */
	public String getName();

	/**
	 * 上级组取得
	 * @return parentid 上级组
	 */
	public Integer getParentid();

	/**
	 * 备注取得
	 * @return remark 备注
	 */
	public String getRemark();

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion();

	/**
	 * 创建时间取得
	 * @return instime 创建时间
	 */
	public String getInstime();
}
