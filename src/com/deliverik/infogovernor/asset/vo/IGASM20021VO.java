/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 概述: 资产域定义添加后信息VO
 * 功能描述: 资产域定义添加后信息VO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20021VO extends BaseVO implements Serializable{
	/**
	 * 资产域定义添加后信息
	 */
	protected EiDomainDefInfo eiDomainDefInfo;
	/**
	 * 资产域定义eiddid
	 */
	protected Integer eiddid;
	/**
	 * 资产域定义版本号
	 */
	protected Integer version;

	/**
	 * 构造函数
	 * @param eiDomainDefInfo资产域定义添加后信息
	 */
	public IGASM20021VO(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * 资产域定义添加后信息取得
	 * @return 资产域定义添加后信息
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * 资产域定义添加后信息设置
	 * @param eiDomainDefInfo 资产域定义添加后信息
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * 资产域定义eiddid取得
	 * @return 资产域定义eiddid
	 */
	public Integer getEiddid() {
		return eiddid;
	}
	/**
	 * 资产域定义eiddid设定
	 * @param eiddid资产域定义eiddid
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**
	 * 资产域定义版本号取得
	 * @return 资产域定义版本号
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * 资产域定义版本号设定
	 * @param version资产域定义版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
