/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟资源回收申请发起Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR0401Form extends BaseForm{

	/** 流程ID */
	protected Integer prid;
	
	/** 项目ID */
	protected Integer pid;
	
	/** 虚机ID */
	protected Integer[] vmids;

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
}
