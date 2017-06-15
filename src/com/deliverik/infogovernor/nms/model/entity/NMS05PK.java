/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组设备关系主键实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class NMS05PK extends BasePK {

	/** 组ID */
	protected Integer gid;
	
	/** 设备ID */
	protected String did;
	
	/** 组版本 */
	protected Integer gversion;
	
	/**
	 * 构造方法
	 */
	public NMS05PK(){
		super();
	}
	
	/**
	 * 构造方法
	 */
	public NMS05PK(Integer gid,String did,Integer gversion){
		super();
		this.gid = gid;
		this.did = did;
		this.gversion = gversion;
	}

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
