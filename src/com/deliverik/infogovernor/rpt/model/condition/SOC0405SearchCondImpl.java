/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 逻辑卷容量实时表检索条件实现
  * 功能描述: 逻辑卷容量实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeSearchCondImpl表名改为SOC0405SearchCondImpl
  */
public class SOC0405SearchCondImpl implements
		SOC0405SearchCond {
	/**类型不等于*/
	protected String lvType_ne;
	/**类型等于*/
	protected String lvType_eq;
	/**状态等于*/
	protected String lvState_eq;
	/**文件系统名字不等于*/
	protected String fsName_neq;
	/**vg名字等于*/
	protected String vgName_eq;
	/**主机名称等于*/
	protected String hostName_eq;

	/**
	 * 类型不等于取得
	 *
	 * @return lvType_ne 类型不等于
	 */
	public String getLvType_ne() {
		return lvType_ne;
	}
	/**
	 * 类型不等于设定
	 *
	 * @param lvType_ne 类型不等于
	 */
	public void setLvType_ne(String lvType_ne) {
		this.lvType_ne = lvType_ne;
	}
	/**
	 * 状态等于取得
	 *
	 * @return lvState_eq 状态等于
	 */
	public String getLvState_eq() {
		return lvState_eq;
	}
	/**
	 * 状态等于设定
	 *
	 * @param lvState_eq 状态等于
	 */
	public void setLvState_eq(String lvState_eq) {
		this.lvState_eq = lvState_eq;
	}
	/**
	 * 文件系统名字不等于取得
	 *
	 * @return fsName_neq 文件系统名字不等于
	 */
	public String getFsName_neq() {
		return fsName_neq;
	}
	/**
	 * 文件系统名字不等于设定
	 *
	 * @param fsName_neq 文件系统名字不等于
	 */
	public void setFsName_neq(String fsName_neq) {
		this.fsName_neq = fsName_neq;
	}
	/**
	 * vg名字等于取得
	 *
	 * @return vgName_eq vg名字等于
	 */
	public String getVgName_eq() {
		return vgName_eq;
	}
	/**
	 * vg名字等于设定
	 *
	 * @param vgName_eq vg名字等于
	 */
	public void setVgName_eq(String vgName_eq) {
		this.vgName_eq = vgName_eq;
	}
	/**
	 * 主机名称等于取得
	 *
	 * @return hostName_eq 主机名称等于
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}
	/**
	 * 主机名称等于设定
	 *
	 * @param hostName_eq 主机名称等于
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
	/**
	 * 类型等于取得
	 *
	 * @return lvType_eq 类型等于
	 */
	public String getLvType_eq() {
		return lvType_eq;
	}
	/**
	 * 类型等于设定
	 *
	 * @param lvType_eq 类型等于
	 */
	public void setLvType_eq(String lvType_eq) {
		this.lvType_eq = lvType_eq;
	}
	
	
}