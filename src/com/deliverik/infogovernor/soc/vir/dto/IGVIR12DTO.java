package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * 虚拟化管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR12DTO extends BaseDTO implements Serializable{
	
	/** 树数据*/
	protected List<Map<String, Object>> treeData;
	
	/** 数id*/
	protected String treeId;
	
	/** host信息*/
	protected Host host;
	
	/** 被操作的虚机名（启动/关闭） */
	protected String vmName;
	
	/** 虚机操作标识（1：启动，2：关闭） */
	protected String oprateType;
	
	/** vCenter连接信息集合 */
	protected List<VIM01Info> vim01List;
	
	/** vCenter连接信息ID */
	protected Integer vcid;
	
	/** Host信息集合 */
	protected List<Host> hostList;

	/**
	 * 树数据取得
	 * @return treeData 树数据
	 */
	public List<Map<String, Object>> getTreeData() {
		return treeData;
	}

	/**
	 * 树数据设定
	 * @param treeData 树数据
	 */
	public void setTreeData(List<Map<String, Object>> treeData) {
		this.treeData = treeData;
	}

	/**
	 * 数id取得
	 * @return treeId 数id
	 */
	public String getTreeId() {
		return treeId;
	}

	/**
	 * 数id设定
	 * @param treeId 数id
	 */
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	/**
	 * host信息取得
	 * @return host host信息
	 */
	public Host getHost() {
		return host;
	}

	/**
	 * host信息设定
	 * @param host host信息
	 */
	public void setHost(Host host) {
		this.host = host;
	}

	/**
	 * 被操作的虚机名取得
	 * @return
	 */
	public String getVmName() {
		return vmName;
	}

	/**
	 *  被操作的虚机名设定
	 * @param vmName
	 */
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	/**
	 * 虚机操作标识取得
	 * @return
	 */
	public String getOprateType() {
		return oprateType;
	}

	/**
	 * 虚机操作标识设定
	 * @param oprateType
	 */
	public void setOprateType(String oprateType) {
		this.oprateType = oprateType;
	}

	/**
	 * vCenter连接信息集合取得
	 * @return vim01List vCenter连接信息集合
	 */
	public List<VIM01Info> getVim01List() {
		return vim01List;
	}

	/**
	 * vCenter连接信息集合设定
	 * @param vim01List vCenter连接信息集合
	 */
	public void setVim01List(List<VIM01Info> vim01List) {
		this.vim01List = vim01List;
	}

	/**
	 * vCenter连接信息ID取得
	 * @return vcid vCenter连接信息ID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter连接信息ID设定
	 * @param vcid vCenter连接信息ID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
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


