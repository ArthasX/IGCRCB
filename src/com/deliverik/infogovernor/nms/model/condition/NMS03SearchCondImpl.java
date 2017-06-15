/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发现任务信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS03SearchCondImpl implements NMS03SearchCond{
	
	/** 组ID */
	protected Integer gid;
	
	/** 任务类型 */
	protected String type;
	
	/** 起始IP */
	protected String fromIP;
	
	/** 结束IP */
	protected String toIP;
	
	/** 子网 */
	protected String subNet;
	
	/** 删除标识 */
	protected String deleteflag;
	
	/** 版本 */
	protected Integer version;
	
	/**
	 * 组ID取得
	 * @return 组ID
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
	 * 任务类型取得
	 * @return 任务类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 任务类型设定
	 * @param type 任务类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 起始IP取得
	 * @return 起始IP
	 */
	public String getFromIP() {
		return fromIP;
	}

	/**
	 * 起始IP设定
	 * @param fromIP 起始IP
	 */
	public void setFromIP(String fromIP) {
		this.fromIP = fromIP;
	}

	/**
	 * 结束IP取得
	 * @return 结束IP
	 */
	public String getToIP() {
		return toIP;
	}

	/**
	 * 结束IP设定
	 * @param toIP 结束IP
	 */
	public void setToIP(String toIP) {
		this.toIP = toIP;
	}

	/**
	 * 子网取得
	 * @return 子网
	 */
	public String getSubNet() {
		return subNet;
	}

	/**
	 * 子网设定
	 * @param subNet 子网
	 */
	public void setSubNet(String subNet) {
		this.subNet = subNet;
	}

	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标识设定
	 * @param deleteflag 删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
