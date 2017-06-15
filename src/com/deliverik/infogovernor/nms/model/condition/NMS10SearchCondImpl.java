/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路黑名单信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS10SearchCondImpl implements NMS10SearchCond{

	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;

	/**
	 * 组ID取得
	 * @return gid 组ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * 组ID设定
	 * @param gid 组ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 组版本取得
	 * @return gversion 组版本
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * 组版本设定
	 * @param gversion 组版本
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}
	
	
}
