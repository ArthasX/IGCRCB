/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程相关资产实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessInfoEntity implements ProcessInfoEntityInfo {
	
	/** 资产ID */
	protected Integer eiid;
	
	/** 资产版本号 */
	protected Integer eiversion;
	
	/** 资产名称 */
	protected String einame;

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}


	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	
	/**
	 * 资产ID取得
	 * @return eiid 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产版本号取得
	 * @return eiversion 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产名称取得
	 * @return einame 资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产名称设定
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
}
