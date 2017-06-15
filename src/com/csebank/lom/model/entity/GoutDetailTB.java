/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.csebank.lom.model.GoutDetailInfo;


/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂消耗明细实体
 * 作者：唐晓娜
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class GoutDetailTB implements Serializable, Cloneable, GoutDetailInfo {
	@Id
	public String goid;
	/** 时间 */
	public String gotime;
	/** 领用者 */
	public String gorequsername;
	/** 物品名称 */
	public String goname;
	
	/** 物品编号 */
	public String gocode;
	/** 招待名称 */
	public String rname;
	/** 接待id */
	public String rid;
	//出库数量
	public String goinnum;
	
	public String getGorequsername() {
		return gorequsername;
	}
	public void setGorequsername(String gorequsername) {
		this.gorequsername = gorequsername;
	}
	public String getGoname() {
		return goname;
	}
	public void setGoname(String goname) {
		this.goname = goname;
	}
	public String getGocode() {
		return gocode;
	}
	public void setGocode(String gocode) {
		this.gocode = gocode;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getGoinnum() {
		return goinnum;
	}
	public void setGoinnum(String goinnum) {
		this.goinnum = goinnum;
	}
	public String getGotime() {
		return gotime;
	}
	public void setGotime(String gotime) {
		this.gotime = gotime;
	}

	public String getGoid() {
		return goid;
	}
	public void setGoid(String goid) {
		this.goid = goid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}






}
