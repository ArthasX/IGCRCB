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
 * Description: 虚拟化资源申请处理Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR3002Form extends BaseForm{

    /** 申请项目主键 */
    protected Integer pid;
    
    /** 虚机所在主机名称 */
    protected String hostNames[];
    
    /** 网络名 */
    protected String networkNames[];
    
    /** 虚机主键 */
    protected String vmids[];

    /** vCloud主键 */
    protected Integer vcid;
    
    /** 主机IP */
    protected String hostip;
    
    /** 数据中心名称 */
    protected String datacenterNames[];
    
    /** 资源池名称 */
    protected String resourcePoolNames[];
    
    /** 流程主键 */
    protected Integer prid;

	/**
	 * 申请项目主键取得
	 * @return pid 申请项目主键
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 虚机所在主机名称取得
	 * @return hostNames 虚机所在主机名称
	 */
	public String[] getHostNames() {
		return hostNames;
	}

	/**
	 * 网络名取得
	 * @return networkNames 网络名
	 */
	public String[] getNetworkNames() {
		return networkNames;
	}

	/**
	 * 虚机主键取得
	 * @return vmids 虚机主键
	 */
	public String[] getVmids() {
		return vmids;
	}

	/**
	 * vCloud主键取得
	 * @return vcid vCloud主键
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * 主机IP取得
	 * @return hostip 主机IP
	 */
	public String getHostip() {
		return hostip;
	}

	/**
	 * 数据中心名称取得
	 * @return datacenterNames 数据中心名称
	 */
	public String[] getDatacenterNames() {
		return datacenterNames;
	}

	/**
	 * 资源池名称取得
	 * @return resourcePoolNames 资源池名称
	 */
	public String[] getResourcePoolNames() {
		return resourcePoolNames;
	}

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 申请项目主键设定
	 * @param pid 申请项目主键
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 虚机所在主机名称设定
	 * @param hostNames 虚机所在主机名称
	 */
	public void setHostNames(String[] hostNames) {
		this.hostNames = hostNames;
	}

	/**
	 * 网络名设定
	 * @param networkNames 网络名
	 */
	public void setNetworkNames(String[] networkNames) {
		this.networkNames = networkNames;
	}

	/**
	 * 虚机主键设定
	 * @param vmids 虚机主键
	 */
	public void setVmids(String[] vmids) {
		this.vmids = vmids;
	}

	/**
	 * vCloud主键设定
	 * @param vcid vCloud主键
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 主机IP设定
	 * @param hostip 主机IP
	 */
	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	/**
	 * 数据中心名称设定
	 * @param datacenterNames 数据中心名称
	 */
	public void setDatacenterNames(String[] datacenterNames) {
		this.datacenterNames = datacenterNames;
	}

	/**
	 * 资源池名称设定
	 * @param resourcePoolNames 资源池名称
	 */
	public void setResourcePoolNames(String[] resourcePoolNames) {
		this.resourcePoolNames = resourcePoolNames;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
