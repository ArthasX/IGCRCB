/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vim;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Data_Center;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.NetLabel;
import com.deliverik.infogovernor.soc.vir.vim.model.Resource_Pool;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;

/**
 * 概述: VIM业务逻辑接口
 * 功能描述: VIM业务逻辑接口
 * 创建记录:
 * 修改记录:
 */
public interface VIMBL extends BaseBL {
	
	/**
	 * 获取所有vCenter的模版列表
	 * @return 模版列表
	 * @throws BLException
	 */
	public List<Template> searchTemplate() throws BLException;
	
	/**
	 * 获取指定vCenter的数据中心列表
	 * @param vcid vCenter配置ID
	 * @return 数据中心列表
	 * @throws BLException
	 */
	public List<Data_Center> searchDatacenterByVcid(Integer vcid) throws BLException;
	
	/**
	 * 获取指定vCenter的资源池列表
	 * @param vcid vCenter配置ID
	 * @return 资源池列表
	 * @throws BLException
	 */
	public List<Resource_Pool> searchResourcePoolByVcid(Integer vcid) throws BLException;
	
	/**
	 * 获取指定vCenter的主机
	 * @param vcid vCenter配置ID
	 * @return 主机列表
	 * @throws BLException
	 */
	public List<Host> searchHostByVcid(Integer vcid) throws BLException;

	/**
	 * 获取指定主机的网络标签
	 * @param vcid vCenter配置ID
	 * @param hostip 主机IP
	 * @return 网络标签列表
	 * @throws BLException
	 */
	public List<NetLabel> searchNetLabelByHost(Integer vcid, String hostip) throws BLException;

	/**
     * 获取指定Datacenter的网络标签
     * @param vcid vCenter配置ID
     * @param dcanem 数据中心名称
     * @return 网络标签列表
     * @throws BLException
     */
    public List<NetLabel> searchNetLabelByDatacenter(Integer vcid, String dcname) throws BLException;
    
	/**
	 * 通过指定模版复制VM
	 * 当rpName为空时，默认为Resources
	 * @param si vCenter连接实例 
	 * @param cloneName 新VM名称
	 * @param dcName 数据中心名称
	 * @param rpName 资源池名称
	 * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
	 * @throws BLException
	 */
	public String[] cloneVMFromTemplate(Template template, String cloneName, String dcName, String rpName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;
	
	/**
     * 通过指定模版复制调整VM配置
     * 当rpName为空时，默认为Resources
     * @param vmName VM名称
     * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
     * @throws BLException
     */
    public String[] reconfigVM(Template template, String vmName, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;
    
	/**
	 * 通过指定模版复制VM
	 * 当rpName为空时，默认为Resources
	 * @param si vCenter连接实例 
	 * @param cloneName 新VM名称
	 * @param dcName 数据中心名称
	 * @param rpName 资源池名称
	 * @return 返回长度为2的数组,[0]值：0失败，1成功;[1]值：操作信息
	 * @throws BLException
	 */
	public String[] createVM(Template template, String cloneName, String dcName, String rpName) throws BLException;

	/**
	 * 获取指定Host信息
	 * @param vcid vCenter配置ID
	 * @param hostName host名称
	 * @return Host信息
	 * @throws BLException
	 */
	public Host getHostInfo(Integer vcid,String hostName) throws BLException;
	
	/**
	 * 虚机操作（开/关机）
	 * @param oprateType
	 * @param vmName
	 * @return
	 * @throws BLException
	 */
	public String oprateVM(Integer vcid, String hostName,String vmName,String oprateType) throws BLException;
	
	/**
     * 回收虚拟机
     * @param vcid 虚拟机连接ID
     * @param vmname 虚拟机名称
     * @param cloneProgressMonitor 创建进度线程
     * @return
     * @throws BLException
     */
    public String[] RecycleVM(Integer vcid,String vmname, CloneProgressMonitorBase cloneProgressMonitor) throws BLException;

    /**
     * 关闭虚机
     * @param name
     * @throws BLException
     */
	public void poweredOffVM(Integer vcid, String name,String hostname) throws BLException;
	
	/**
	 * 启动虚机
	 * @param name
	 * @throws BLException
	 */
	public void poweredOnVM(Integer vcid, String name,String hostname) throws BLException;
}
