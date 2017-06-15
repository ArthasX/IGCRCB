/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备白名单信息实体查询条件接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS12SearchCond {

	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid();

	/**
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion() ;
	
	/**
	 * 用户ID取得
	 * @return userid 用户ID
	 */
	public String getUserid();
	
	/**
	 * 设备ID取得
	 * @return did 设备ID
	 */
	public String getDid();
	
	/**
	 * 用户id为空取得
	 * @return useridEmpty 用户id为空
	 */
	public boolean isUseridEmpty();
}
