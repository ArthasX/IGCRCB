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
 * Description: 虚拟化用户首页Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1006Form extends BaseForm{

	/** 虚机名称 */
	protected String vmname;
	
	/** 虚机状态 */
	protected String powerState;

	/** vcenter主键 */
    protected Integer vcid;

	/**
	 * 虚机名称取得
	 * @return vmname 虚机名称
	 */
	public String getVmname() {
		return vmname;
	}

	/**
	 * 虚机名称设定
	 * @param vmname 虚机名称
	 */
	public void setVmname(String vmname) {
		this.vmname = vmname;
	}

	/**
	 * 虚机状态取得
	 * @return powerState 虚机状态
	 */
	public String getPowerState() {
		return powerState;
	}

	/**
	 * 虚机状态设定
	 * @param powerState 虚机状态
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

    /**
     * 获取vcenter主键
     * @return vcenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vcenter主键
     * @param vcid vcenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
}
