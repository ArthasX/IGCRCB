/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自动部署进度显示vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR30031VO extends BaseVO{
	
	/** 项目IG */
	protected Integer pid;
	
	/** 部署种的vm信息集合 */
	protected List<VCD03Info> vcd03List;

	/**
	 * 项目IG取得
	 * @return pid 项目IG
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目IG设定
	 * @param pid 项目IG
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 部署种的vm信息集合取得
	 * @return vcd03List 部署种的vm信息集合
	 */
	public List<VCD03Info> getVcd03List() {
		return vcd03List;
	}

	/**
	 * 部署种的vm信息集合设定
	 * @param vcd03List 部署种的vm信息集合
	 */
	public void setVcd03List(List<VCD03Info> vcd03List) {
		this.vcd03List = vcd03List;
	}
}
