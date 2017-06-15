/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备黑名单信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS08SearchCondImpl implements NMS08SearchCond{

	/** 组ID */
	protected Integer gid;
	
	/** 组版本 */
	protected Integer gversion;
	
	/** 用户ID */
	protected String userid;
	
	/** 设备ID */
	protected String did;
	
    /** 用户id为空  */
    protected boolean useridEmpty;

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

	/**
	 * 用户ID取得
	 * @return userid 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 设备ID取得
	 * @return did 设备ID
	 */
	public String getDid() {
		return did;
	}

	/**
	 * 设备ID设定
	 * @param did 设备ID
	 */
	public void setDid(String did) {
		this.did = did;
	}

	/**
	 * 用户id为空取得
	 * @return useridEmpty 用户id为空
	 */
	public boolean isUseridEmpty() {
		return useridEmpty;
	}

	/**
	 * 用户id为空设定
	 * @param useridEmpty 用户id为空
	 */
	public void setUseridEmpty(boolean useridEmpty) {
		this.useridEmpty = useridEmpty;
	}
}
