/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;

/**
  * 概述: SOC0118VW实体
  * 功能描述: SOC0118VW实体
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0118VWPK.class)
@Table(name="SOC0118VW")
public class SOC0118VW extends BaseEntity implements Serializable,
		Cloneable, SOC0118VWInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 资产ID                   */
	@Id
	protected Integer eiid;

	/** 资产模型ID               */
	protected String eid;

	/** 资产项的说明             */
	protected String eidesc;

	/** 资产名称                 */
	protected String einame;

	/** 资产编号                 */
	protected String eilabel;

	/** 资产登记日               */
	protected String eiinsdate;

	/** 所属机构层次码           */
	protected String eiorgsyscoding;

	/** 所属模型层次码           */
	protected String esyscoding;

	/** 更新时间                 */
	protected String eiupdtime;

	/** 资产状态                 */
	protected String eistatus;

	/** 版本                     */
	protected String eiversion;

	/** 资产管理人*/
	protected String eiuserid;
	
	/** 资产管理人姓名*/
	protected String eiusername;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;
	
	/**
	 * @return the eiuserid
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * @param eiuserid the eiuserid to set
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * @return the eiusername
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * @param eiusername the eiusername to set
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * @return the eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * @param eismallversion the eismallversion to set
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * @return the eirootmark
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * @param eirootmark the eirootmark to set
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产ID                  取得
	 *
	 * @return 资产ID                  
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID                  设定
	 *
	 * @param eiid 资产ID                  
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID              取得
	 *
	 * @return 资产模型ID              
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID              设定
	 *
	 * @param eid 资产模型ID              
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产项的说明            取得
	 *
	 * @return 资产项的说明            
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产项的说明            设定
	 *
	 * @param eidesc 资产项的说明            
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产名称                取得
	 *
	 * @return 资产名称                
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产名称                设定
	 *
	 * @param einame 资产名称                
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产编号                取得
	 *
	 * @return 资产编号                
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号                设定
	 *
	 * @param eilabel 资产编号                
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产登记日              取得
	 *
	 * @return 资产登记日              
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产登记日              设定
	 *
	 * @param eiinsdate 资产登记日              
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 所属机构层次码          取得
	 *
	 * @return 所属机构层次码          
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 所属机构层次码          设定
	 *
	 * @param eiorgsyscoding 所属机构层次码          
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 所属模型层次码          取得
	 *
	 * @return 所属模型层次码          
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 所属模型层次码          设定
	 *
	 * @param esyscoding 所属模型层次码          
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 更新时间                取得
	 *
	 * @return 更新时间                
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 更新时间                设定
	 *
	 * @param eiupdtime 更新时间                
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 资产状态                取得
	 *
	 * @return 资产状态                
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态                设定
	 *
	 * @param eistatus 资产状态                
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 版本                    取得
	 *
	 * @return 版本                    
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * 版本                    设定
	 *
	 * @param eiversion 版本                    
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0118VWPK(id, eiid);
	}

}