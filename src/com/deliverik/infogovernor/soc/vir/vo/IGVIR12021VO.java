/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源使用情况展示VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR12021VO extends BaseVO{

	/** 连接信息ID */
	protected Integer vcid;
	
	/** 连接信息 */
	protected List<VIM01Info> vim01List;
	
	/** Host信息集合 */
	protected List<Host> hostList;

	/**
	 * 连接信息ID取得
	 * @return vcid 连接信息ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * 连接信息ID设定
	 * @param vcid 连接信息ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 连接信息取得
	 * @return vim01List 连接信息
	 */
	public List<VIM01Info> getVim01List() {
		return vim01List;
	}

	/**
	 * 连接信息设定
	 * @param vim01List 连接信息
	 */
	public void setVim01List(List<VIM01Info> vim01List) {
		this.vim01List = vim01List;
	}

	/**
	 * Host信息集合取得
	 * @return hostList Host信息集合
	 */
	public List<Host> getHostList() {
		return hostList;
	}

	/**
	 * Host信息集合设定
	 * @param hostList Host信息集合
	 */
	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}
}
