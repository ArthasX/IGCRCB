package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * 资源占用情况	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR12011VO extends BaseVO implements Serializable{
	
	/** vCenter信息*/
	protected VIM01Info vim01Info;

	/** host集合*/
	protected List<Host> hostList;

	/**
	 * vCenter信息取得
	 * @return vim01Info vCenter信息
	 */
	public VIM01Info getVim01Info() {
		return vim01Info;
	}

	/**
	 * vCenter信息设定
	 * @param vim01Info vCenter信息
	 */
	public void setVim01Info(VIM01Info vim01Info) {
		this.vim01Info = vim01Info;
	}

	/**
	 * host集合取得
	 * @return hostList host集合
	 */
	public List<Host> getHostList() {
		return hostList;
	}

	/**
	 * host集合设定
	 * @param hostList host集合
	 */
	public void setHostList(List<Host> hostList) {
		this.hostList = hostList;
	}
	
}


