/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
  * 概述: 合同资产信息视图实体
  * 功能描述: 合同资产信息视图实体
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "IG499")
public class IG499VW implements Serializable,Cloneable, IG499Info {
	@Id
	/** 资产ID */
	protected Integer eiid;

	/** 资产模型ID */
	protected String eid;

	/** 资产名称 */
	protected String einame;

	/** 资产说明 */
	protected String eidesc;

	/** 资产编号 */
	protected String eilabel;

	/** 资产变更时间 */
	protected String eiupdtime;

	/** 资产状态 */
	protected String eistatus;

	/** 资产模型名称 */
	protected String ename;

	/** 资产模型编号 */
	protected String elabel;

	/** 资产模型说明 */
	protected String edesc;

	/** 资产模型状态 */
	protected String estatus;

	/** 资产模型分类 */
	protected String ecategory;

	/** 资产模型一级子类 */
	protected String ekey1;

	/** 资产模型二级子类 */
	protected String ekey2;

	/** 资产模型三级子类 */
	protected String ekey3;

	/** 资产版本号 */
	protected Integer eiversion;

	/** 资产登记日 */
	protected String eiinsdate;

	/** 资产所属机构 */
	protected String eiorgsyscoding;

	/** 资产模型 */
	protected String esyscoding;

	/** 资产管理人 */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;

	/** 资产小版本 */
	protected Integer eismallversion;

	/** 资产所属树根节点实体标识 */
	protected Integer eirootmark;

	/** 服务商 */
	protected String facilitator;

	/** 签订时间 */
	protected String condudetime;

	/** 经手人 */
	protected String operator;

	/** 合同类别 */
	protected String compacttype;

	/** 合同款 */
	protected String contractpayment;

	/** 已付款 */
	protected String countmoney;

	/** 最后付款日 */
	protected String lastdatetime;
	
	/** 本期预付款 */
	protected String imprest;
	
	/** 资产所属机构信息实体 */
	@Transient
	protected OrganizationTB organizationTB;

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资产名称设定
	 *
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产说明取得
	 *
	 * @return 资产说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产说明设定
	 *
	 * @param eidesc 资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产编号取得
	 *
	 * @return 资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产变更时间取得
	 *
	 * @return 资产变更时间
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * 资产变更时间设定
	 *
	 * @param eiupdtime 资产变更时间
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * 资产状态取得
	 *
	 * @return 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态设定
	 *
	 * @param eistatus 资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 资产模型名称取得
	 *
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 资产模型编号取得
	 *
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型说明取得
	 *
	 * @return 资产模型说明
	 */
	public String getEdesc() {
		return edesc;
	}

	/**
	 * 资产模型说明设定
	 *
	 * @param edesc 资产模型说明
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	/**
	 * 资产模型状态取得
	 *
	 * @return 资产模型状态
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * 资产模型状态设定
	 *
	 * @param estatus 资产模型状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * 资产模型分类取得
	 *
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 资产模型一级子类取得
	 *
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 *
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 资产模型三级子类取得
	 *
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}

	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	/**
	 * 资产版本号取得
	 *
	 * @return 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 *
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 资产登记日取得
	 *
	 * @return 资产登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 资产登记日设定
	 *
	 * @param eiinsdate 资产登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 资产所属机构取得
	 *
	 * @return 资产所属机构
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	/**
	 * 资产所属机构设定
	 *
	 * @param eiorgsyscoding 资产所属机构
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产模型取得
	 *
	 * @return 资产模型
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型设定
	 *
	 * @param esyscoding 资产模型
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产管理人取得
	 *
	 * @return 资产管理人
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 资产管理人设定
	 *
	 * @param eiuserid 资产管理人
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 资产管理人姓名取得
	 *
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 资产管理人姓名设定
	 *
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产小版本取得
	 *
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

	/**
	 * 资产所属树根节点实体标识取得
	 *
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}

	/**
	 * 资产所属树根节点实体标识设定
	 *
	 * @param eirootmark 资产所属树根节点实体标识
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 服务商取得
	 *
	 * @return 服务商
	 */
	public String getFacilitator() {
		return facilitator;
	}

	/**
	 * 服务商设定
	 *
	 * @param facilitator 服务商
	 */
	public void setFacilitator(String facilitator) {
		this.facilitator = facilitator;
	}

	/**
	 * 签订时间取得
	 *
	 * @return 签订时间
	 */
	public String getCondudetime() {
		return condudetime;
	}

	/**
	 * 签订时间设定
	 *
	 * @param condudetime 签订时间
	 */
	public void setCondudetime(String condudetime) {
		this.condudetime = condudetime;
	}

	/**
	 * 经手人取得
	 *
	 * @return 经手人
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 经手人设定
	 *
	 * @param operator 经手人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 合同类别取得
	 *
	 * @return 合同类别
	 */
	public String getCompacttype() {
		return compacttype;
	}

	/**
	 * 合同类别设定
	 *
	 * @param compacttype 合同类别
	 */
	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	/**
	 * 合同款取得
	 *
	 * @return 合同款
	 */
	public String getContractpayment() {
		return contractpayment;
	}

	/**
	 * 合同款设定
	 *
	 * @param contractpayment 合同款
	 */
	public void setContractpayment(String contractpayment) {
		this.contractpayment = contractpayment;
	}

	/**
	 * 已付款取得
	 *
	 * @return 已付款
	 */
	public String getCountmoney() {
		return countmoney;
	}

	/**
	 * 已付款设定
	 *
	 * @param countmoney 已付款
	 */
	public void setCountmoney(String countmoney) {
		this.countmoney = countmoney;
	}

	/**
	 * 最后付款日取得
	 *
	 * @return 最后付款日
	 */
	public String getLastdatetime() {
		return lastdatetime;
	}

	/**
	 * 最后付款日设定
	 *
	 * @param lastdatetime 最后付款日
	 */
	public void setLastdatetime(String lastdatetime) {
		this.lastdatetime = lastdatetime;
	}

	/**
	 * 本期预付款取得
	 * @return 本期预付款
	 */
	public String getImprest() {
		return imprest;
	}

	/**
	 * 本期预付款设定
	 * @param imprest本期预付款
	 */
	public void setImprest(String imprest) {
		this.imprest = imprest;
	}
	
	/**
	 * 资产所属机构信息实体取得
	 * @return 资产所属机构信息实体
	 */
	public OrganizationTB getOrganizationTB() {
		if(this.organizationTB == null){
			if(StringUtils.isNotEmpty(this.eiorgsyscoding)){
				OrganizationBL bl = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgsyscoding(this.eiorgsyscoding);
				List<Organization> list = bl.searchOrganization(cond);
				if(list.size() == 1){
					this.organizationTB = (OrganizationTB) list.get(0);
				}
			}
		}
		return organizationTB;
	}

	/**
	 * 资产所属机构信息实体设定
	 *
	 * @param organizationTB 资产所属机构信息实体
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
}