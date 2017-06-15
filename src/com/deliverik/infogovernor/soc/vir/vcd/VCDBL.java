/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vcd;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.vcd.model.Catalog;
import com.deliverik.infogovernor.soc.vir.vcd.model.Org;
import com.deliverik.infogovernor.soc.vir.vcd.model.Template;
import com.dev.vim.igflow.jobs.VcloudCloneProgressMonitor;

/**
 * 概述: VCD业务逻辑接口
 * 功能描述: VCD业务逻辑接口
 * 创建记录:
 * 修改记录:
 */
public interface VCDBL extends BaseBL {
	
	/**
	 * 获取所有vCloud的组织列表
	 * @return 组织列表
	 * @throws BLException
	 */
	public List<Org> searchOrg() throws BLException;
	
	/**
	 * 获取指定组织的目录列表
	 * @param vcdInfo vCloud配置信息
	 * @return 目录列表
	 * @throws BLException
	 */
	public List<Catalog> searchCatalog(VCD01Info vcdInfo, String orgName) throws BLException;
	
	/**
	 * 获取所有vCloud的模版列表
	 * @return 模版列表
	 * @throws BLException
	 */
	public List<Template> searchTemplate(VCD01Info vcdInfo, String orgName, String catalogName) throws BLException;
	
	/**
	 * 
	 * <p>功能：克隆虚拟机</p>
	 * 
	 * @param 连接信息
	 * @param org 组织
	 * @param vdc 
	 * @param vapp 分组名称
	 * @param catalog 目录
	 * @param template 模板
	 * @param fqdn 
	 * @param description
	 * @param ip
	 * @param network
	 * @return
	 */
	public void cloneVM(VCD01Info vcd01,String org, String vdc, String vapp, 
			String catalog, String template, String fqdn, String description, 
			String ip, String network,VcloudCloneProgressMonitor cloneProgressMonitor)  throws BLException;
	
}
