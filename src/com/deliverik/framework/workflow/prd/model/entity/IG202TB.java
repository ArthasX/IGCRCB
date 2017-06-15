/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

/**
 * <p>概述:流程共通变量实体</p>
 * <p>功能描述：1.流程初始化</p>
 * <p>          2.流程查询</p>
 * <p>创建记录：</p>
 */
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG202Info;


@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG202")
public class IG202TB extends BaseEntity implements Serializable, Cloneable,IG202Info{
	@Id
	@TableGenerator(
			name="IG202_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG202_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG202_TABLE_GENERATOR")
	/**
	* 流程变量定义ID
	*/
	protected Integer pidid;

	/**
	* 流程变量名称
	*/
	protected String pidname;

	/**
	* 流程变量显示名称
	*/
	protected String pidlabel;

	/**
	* 流程变量描述
	*/
	protected String piddesc;

	/**
	* 流程变量类型
	*/
	protected String pidtype;

	/**
	* 流程变量选项
	*/
	protected String pidoption;

	/**
	* 流程变量默认值
	*/
	protected String piddefault;

	/**
	* 流程变量是否必填
	*/
	protected String pidrequired;

	/**
	* 流程变量排序标识
	*/
	protected String pidsortid;

	/**
	* 树形流程变量CCID
	*/
	protected String ccid;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	/** 表单信息的行显示模式 */
	protected String rowwidth;
	
	/** 私有变量权限范围 */
	protected String privatescope;

	/**
	* 功能：流程变量定义ID取得
	* @return pidid 流程变量定义ID
	*/
	public Integer getPidid(){
	return pidid;
	}
	/**
	* 功能：流程变量定义ID设定
	* @param pidid 流程变量定义ID
	*/
	public void setPidid(Integer pidid){
	this.pidid=pidid;
	}
	/**
	* 功能：流程变量名称取得
	* @return pidname 流程变量名称
	*/
	public String getPidname(){
	return pidname;
	}
	/**
	* 功能：流程变量名称设定
	* @param pidname 流程变量名称
	*/
	public void setPidname(String pidname){
	this.pidname=pidname;
	}
	/**
	* 功能：流程变量显示名称取得
	* @return pidlabel 流程变量显示名称
	*/
	public String getPidlabel(){
	return pidlabel;
	}
	/**
	* 功能：流程变量显示名称设定
	* @param pidlabel 流程变量显示名称
	*/
	public void setPidlabel(String pidlabel){
	this.pidlabel=pidlabel;
	}
	/**
	* 功能：流程变量描述取得
	* @return piddesc 流程变量描述
	*/
	public String getPiddesc(){
	return piddesc;
	}
	/**
	* 功能：流程变量描述设定
	* @param piddesc 流程变量描述
	*/
	public void setPiddesc(String piddesc){
	this.piddesc=piddesc;
	}
	/**
	* 功能：流程变量类型取得
	* @return pidtype 流程变量类型
	*/
	public String getPidtype(){
	return pidtype;
	}
	/**
	* 功能：流程变量类型设定
	* @param pidtype 流程变量类型
	*/
	public void setPidtype(String pidtype){
	this.pidtype=pidtype;
	}
	/**
	* 功能：流程变量选项取得
	* @return pidoption 流程变量选项
	*/
	public String getPidoption(){
	return pidoption;
	}
	/**
	* 功能：流程变量选项设定
	* @param pidoption 流程变量选项
	*/
	public void setPidoption(String pidoption){
	this.pidoption=pidoption;
	}
	/**
	* 功能：流程变量默认值取得
	* @return piddefault 流程变量默认值
	*/
	public String getPiddefault(){
	return piddefault;
	}
	/**
	* 功能：流程变量默认值设定
	* @param piddefault 流程变量默认值
	*/
	public void setPiddefault(String piddefault){
	this.piddefault=piddefault;
	}
	/**
	* 功能：流程变量是否必填取得
	* @return pidrequired 流程变量是否必填
	*/
	public String getPidrequired(){
	return pidrequired;
	}
	/**
	* 功能：流程变量是否必填设定
	* @param pidrequired 流程变量是否必填
	*/
	public void setPidrequired(String pidrequired){
	this.pidrequired=pidrequired;
	}
	/**
	* 功能：流程变量排序标识取得
	* @return pidsortid 流程变量排序标识
	*/
	public String getPidsortid(){
	return pidsortid;
	}
	/**
	* 功能：流程变量排序标识设定
	* @param pidsortid 流程变量排序标识
	*/
	public void setPidsortid(String pidsortid){
	this.pidsortid=pidsortid;
	}
	/**
	* 功能：树形流程变量CCID取得
	* @return ccid 树形流程变量CCID
	*/
	public String getCcid(){
	return ccid;
	}
	/**
	* 功能：树形流程变量CCID设定
	* @param ccid 树形流程变量CCID
	*/
	public void setCcid(String ccid){
	this.ccid=ccid;
	}


	
	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return pidid;
	}
	public String getRowwidth() {
		return rowwidth;
	}
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}
	public String getPrivatescope() {
		return privatescope;
	}
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	public String getPidmode() {
		return pidmode;
	}
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

}
