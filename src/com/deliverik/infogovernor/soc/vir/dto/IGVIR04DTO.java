/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟资源回收申请DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR04DTO extends BaseDTO{

	/** 流程ID */
	protected Integer prid;
	
	/** 项目ID */
	protected Integer pid;
	
	/** 虚机ID */
	protected Integer[] vmids;
	
	/** 用户信息 */
	protected User user;
	
	/** json结果 */
	protected String jsonResult;

	/**
	 * 流程ID取得
	 * @return prid 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目ID设定
	 * @param pid 项目ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 虚机ID取得
	 * @return vmids 虚机ID
	 */
	public Integer[] getVmids() {
		return vmids;
	}

	/**
	 * 虚机ID设定
	 * @param vmids 虚机ID
	 */
	public void setVmids(Integer[] vmids) {
		this.vmids = vmids;
	}

	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * json结果取得
	 * @return jsonResult json结果
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json结果设定
	 * @param jsonResult json结果
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
}
