/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.com.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;

/**
 * 
 * 处理中工作
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class ProcessInHandVW implements Serializable, Cloneable, ProcessInHandVWInfo {
	
	@Id
	private Integer rid;
	
	/**
	 * 流程ID 
	 */
	private Integer prid;
	
	/** 发起人姓名 */
	private String prusername;
	
	/**
	 * 紧急程度
	 */
	private String prurgency;
	
	/**
	 * 工作编号
	 */
	private String prserialnum;
	
	/**
	 * 流程标题
	 */
	private String prtitle;
	/**
	 * 流程模板id
	 */
	private String prpdid;
	/**
	 * 流程模板名称
	 */
	private String prpdname;
	
	/**
	 * 流程类型
	 */
	private String prtype;
	
	/**
	 * 开始时间
	 */
	private String propentime;
	
	/** 关闭时间 */
	private String prclosetime;
	
	/**
	 * 处理人
	 */
	private String ppusername;
	
	/**
	 * 状态
	 */
	private String prstatus;
	
	/** 处理角色名称 */
	private String pprolename;
	
	/**
	 * 类型显示
	 */
	@Transient
	private String showtype;
	
	/**
	 * 显示标题
	 */
	@Transient
	private String showtitle;
	@Transient
	private String showrolename;
	@Transient
	private String showpdname;
	@Transient
	private String showimg;
	@Transient
	private String showurl;
	
	private String prrolename;
	
	private Integer prstrategyversion;
	
	/** 流程状态  */	
	private String orderstatus;

	/**
	 * 流程状态ID
	 */
	protected String psdid;

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 发起人姓名取得
	 * @return prusername 发起人姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 发起人姓名设定
	 * @param prusername 发起人姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 关闭时间取得
	 * @return prclosetime 关闭时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 关闭时间设定
	 * @param prclosetime 关闭时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPpusername() {
		return ppusername;
	}

	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 处理角色名称取得
	 * @return pprolename 处理角色名称
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * 处理角色名称设定
	 * @param pprolename 处理角色名称
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public Integer getPrstrategyversion() {
		return prstrategyversion;
	}

	public void setPrstrategyversion(Integer prstrategyversion) {
		this.prstrategyversion = prstrategyversion;
	}

	public String getShowtype() {
		this.showtype = "2";
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public String getShowtitle() {
		if(StringUtils.isNotEmpty(prtitle)){
			if(this.prtitle.length() > 9){
				this.showtitle = this.prtitle.substring(0,9) + "...";
			}else{
				this.showtitle = this.prtitle;
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getShowrolename() {
		if(StringUtils.isNotEmpty(this.prrolename)){
			if(this.prrolename.length() > 5){
				this.showrolename = this.prrolename.substring(0,4) + "...";
			}else{
				this.showrolename = this.prrolename;
			}
		}
		
		return showrolename;
	}

	public void setShowrolename(String showrolename) {
		this.showrolename = showrolename;
	}

	public String getShowpdname() {
		if(StringUtils.isNotEmpty(this.prpdname)){
			if(this.prpdname.length() > 5){
				this.showpdname = this.prpdname.substring(0,4) + "...";
			}else{
				this.showpdname = this.prpdname;
			}
		}
		return showpdname;
	}

	public void setShowpdname(String showpdname) {
		this.showpdname = showpdname;
	}

	public String getShowimg() {
		if(StringUtils.isNotEmpty(this.prtype)){
			if(this.prtype.length() > 2){
				this.showimg = this.prtype.substring(0,2);
			}else{
				this.showimg = this.prtype;
			}
		}
		return showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	public String getShowurl() {
		this.showurl = "IGPRR0102_Disp.do?prtype=" + prtype + "&prid=";
		return showurl;
	}

	public void setShowurl(String showurl) {
		this.showurl = showurl;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程状态取得
	 * @return orderstatus  流程状态
	 */
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * 流程状态设定
	 * @param orderstatus  流程状态
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
}
