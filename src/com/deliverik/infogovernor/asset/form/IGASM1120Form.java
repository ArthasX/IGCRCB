/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询
 * 创建人：赵梓廷
 * 创建记录： 2013-02-01
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM1120Form extends BaseForm {
	
	/**业务系统*/
	protected String businesssys;
	
	/**IP地址*/
	protected String ip;

    /**设备名称*/
    protected String einame;

    /**设备编号*/
    protected String eilabel;
	
	/**所属机柜*/
	protected String computerContainer ;
	
	/**
	 *业务系统取得
	 * @return 业务系统
	 */
	public String getBusinesssys() {
		return businesssys;
	}
	
	/**
	 * 业务系统设定
	 *
	 * @param businesssys 业务系统
	 */
	public void setBusinesssys(String businesssys) {
		this.businesssys = businesssys;
	}
	
	/**
	 *IP地址取得
	 * @return IP地址
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP地址设定
	 *
	 * @param ip IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 *所属机柜取得
	 * @return 所属机柜
	 */
	public String getComputerContainer() {
		return computerContainer;
	}
	/**
	 * 所属机柜设定
	 *
	 * @param computerContainer 所属机柜
	 */
	public void setComputerContainer(String computerContainer) {
		this.computerContainer = computerContainer;
	}

    /**
     * 设备名称取得
     *
     * @return einame 设备名称
     */
    public String getEiname() {
        return einame;
    }

    /**
     * 设备编号取得
     *
     * @return eilabel 设备编号
     */
    public String getEilabel() {
        return eilabel;
    }

    /**
     * 设备名称设定
     *
     * @param einame 设备名称
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }

    /**
     * 设备编号设定
     *
     * @param eilabel 设备编号
     */
    public void setEilabel(String eilabel) {
        this.eilabel = eilabel;
    }

}
