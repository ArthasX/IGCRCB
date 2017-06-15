/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发现任务信息实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS03SearchCond {
	
	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid();

	/**
	 * 任务类型取得
	 * @return 任务类型
	 */
	public String getType();

	/**
	 * 起始IP取得
	 * @return 起始IP
	 */
	public String getFromIP();

	/**
	 * 结束IP取得
	 * @return 结束IP
	 */
	public String getToIP();

	/**
	 * 子网取得
	 * @return 子网
	 */
	public String getSubNet();

	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion();
}
