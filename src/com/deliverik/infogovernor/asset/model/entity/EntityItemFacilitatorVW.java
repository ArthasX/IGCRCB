/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
/**
 * 概述:服务商信息视图实体
 * 功能描述: 服务商信息视图实体
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EntityItemFacilitatorVW implements Serializable, Cloneable,
		EntityItemFacilitatorVWInfo {

	/**服务商id  */
	@Id
	protected Integer eiid;
	/**公司名称  */
	protected String einame;
	/**地址  */
	protected String address;
	/**联系人  */
	protected String linkman;
	/**电话  */
	protected String tel;
	/**开户行  */
	protected String accountbk;
	/**开户帐号  */
	protected String accountno;
	/**开户名称  */
	protected String accountname;
	/**机构码  */
	protected String eiorgsyscoding;
	/**模型码  */
	protected String esyscoding;
	/**登记日  */
	protected String eiinsdate;
	
	
	/**服务商id 取得 */
	public Integer getEiid() {
		return eiid;
	}
	/**公司名称  取得 */
	public String getEiname() {
		return einame;
	}
	/**地址  取得 */
	public String getAddress() {
		return address;
	}
	/**联系人  取得 */
	public String getLinkman() {
		return linkman;
	}
	/**电话 取得  */
	public String getTel() {
		return tel;
	}
	/**开户行  取得 */
	public String getAccountbk() {
		return accountbk;
	}
	/**开户帐号  取得 */
	public String getAccountno() {
		return accountno;
	}
	/**开户名称  取得 */
	public String getAccountname() {
		return accountname;
	}
	/**机构码  取得 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**模型码  取得 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**登记日  取得 */
	public String getEiinsdate() {
		return eiinsdate;
	}
	
	
	/**服务商id 设定 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**公司名称  设定 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**地址  设定 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**联系人  设定 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**电话  设定 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**开户行  设定 */
	public void setAccountbk(String accountbk) {
		this.accountbk = accountbk;
	}
	/**开户帐号  设定 */
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	/**开户名称  设定 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	/**机构码  设定 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**模型码  设定 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**登记日  设定 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
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
