/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;



/**
 * 概述:未上架机柜、空调、ups视图实体
 * 功能描述: 未上架机柜、空调、ups视图实体
 * 创建人：付彬
 * 创建记录: 2013/07/03
 * 修改记录: 
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
public class EntityItemUntreatedVW implements Serializable, Cloneable, 
		EntityItemUntreatedVWInfo{
	
	/**资产id  */
	@Id
	protected Integer eiid;
	/**资产名称  */
	protected String einame;
	/**资产编号 */
	protected String eilabel;
	/**资产层次码  */
	protected String esyscoding;
	/**高度  */
	protected String u_total;
	/**机柜、机架标识	0：机柜	1：机架  */
	protected String containertype;
	/**空调类型  */
	protected String eitype;
	
	
	
	/**资产id 取得*/
	public Integer getEiid() {
		return eiid;
	}

	/**资产名称  取得*/
	public String getEiname() {
		return einame;
	}

	/**资产编号 取得 */
	public String getEilabel() {
		return eilabel;
	}

	/**资产层次码  取得*/
	public String getEsyscoding() {
		return esyscoding;
	}

	/**高度  取得*/
	public String getU_total() {
		return u_total;
	}

	/**机柜、机架标识 取得  */
	public String getContainertype() {
		return containertype;
	}

	/**空调类型  取得*/
	public String getEitype() {
		return eitype;
	}



	/**资产id 设定*/
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**资产名称  设定*/
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**资产编号 设定 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**资产层次码  设定*/
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**高度  设定*/
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}

	/**机柜、机架标识 设定  */
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}

	/**空调类型  设定  */
	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	
	
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return eiid;
	}
}
