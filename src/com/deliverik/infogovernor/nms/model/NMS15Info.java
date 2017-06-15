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
 * Description: 自动发现记录实体接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS15Info extends BaseModel{

	/**
	 * 主键取得
	 * @return id 主键
	 */
	public Integer getId();
	
	/**
	 * 任务版本取得
	 * @return rversion 任务版本
	 */
	public Integer getRversion();

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
	 * 开始时间取得
	 * @return starttime 开始时间
	 */
	public String getStarttime();

	/**
	 * 结束时间取得
	 * @return endtime 结束时间
	 */
	public String getEndtime();
}
