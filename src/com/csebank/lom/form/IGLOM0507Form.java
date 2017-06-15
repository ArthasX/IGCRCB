/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 食堂接待管理Form
 *
 */
public class IGLOM0507Form extends BaseForm  implements EentertainmentSearchCond {


	private static final long serialVersionUID = 1L;

	/** 自增无意义主键 */
	protected Integer eeid;
	/** 状态 */
	protected String rstatus;
	/** 接待工作ID */
	protected Integer rid;

	protected Integer rid_mon;
	
	protected Integer rid_org;
	
	/** 主陪人 */
	protected String eeuser;
	
	/** 每桌菜价格 */
	protected BigDecimal eetableprice;

	/** 桌数 */
	protected Integer eetablenum;
	
	/** 酒价 */
	protected BigDecimal eedrinkprice;
	
	/** 烟价 */
	protected BigDecimal eesmokeprice;
	
	/** 其他用品价格 */
	protected BigDecimal eeotherprice;
	
	/** 日期 */
	protected String eedate;
	
	/** 接待删除ID */
	protected String[] deleteEeid;
	
	/** 记录版本标识 */
	protected String fingerprint;
	
	/** 食堂接待信息开始时间 */
	protected String eetime_from;
	
	/** 食堂接待信息结束时间 */
	protected String eetime_to;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";	
	
	/** 页面标识 */
	protected String flag;
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEeid() {
		return eeid;
	}
	
	/**
	 * 自增无意义主键
	 * @param eid 自增无意义主键
	 */
	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}
	
	/**
	 * 接待工作ID
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}
	
	/**
	 * 接待工作ID
	 * @param rid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	/**
	 * 主陪人
	 * @return 主陪人
	 */
	public String getEeuser() {
		return eeuser;
	}
	
	/**
	 * 主陪人
	 * @param eeuser 主陪人
	 */
	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}
	
	/**
	 * 每桌菜价格
	 * @return 每桌菜价格
	 */
	public BigDecimal getEetableprice() {
		return eetableprice;
	}
	
	/**
	 * 每桌菜价格
	 * @param eetableprice 每桌菜价格
	 */
	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}
	
	/**
	 * 桌数
	 * @return 桌数
	 */
	public Integer getEetablenum() {
		return eetablenum;
	}
	
	/**
	 * 桌数
	 * @param eetablenum 桌数
	 */
	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
	}
	
	/**
	 * 酒价
	 * @return 酒价
	 */
	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}
	
	/**
	 * 酒价
	 * @param eedrinkprice 酒价
	 */
	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}
	
	/**
	 * 烟价
	 * @return 烟价
	 */
	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}
	
	/**
	 * 烟价
	 * @param eesmokeprice 烟价
	 */
	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}
	
	/**
	 * 其他用品价格
	 * @return 其他用品价格
	 */
	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}
	
	/**
	 * 其他用品价格
	 * @param eeotherprice 其他用品价格
	 */
	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEedate() {
		return eedate;
	}
	
	/**
	 * 日期
	 * @param eedate 日期
	 */
	public void setEedate(String eedate) {
		this.eedate = eedate;
	}
	
	/**
	 * 接待删除ID
	 * @return 接待删除ID
	 */
	public String[] getDeleteEeid() {
		return deleteEeid;
	}
	/**
	 * 接待删除ID
	 * @param deleteEeid 接待删除ID
	 */
	public void setDeleteEeid(String[] deleteEeid) {
		this.deleteEeid = deleteEeid;
	}

	/**
	 * 食堂接待信息开始时间查询取得
	 * @return 食堂接待信息开始时间查询
	 */
	public String getEetime_from() {
		return eetime_from;
	}

	/**
	 * 食堂接待信息开始时间查询设定
	 * @param eetime_from 食堂接待信息开始时间查询
	 */
	public void setEetime_from(String eetime_from) {
		this.eetime_from = eetime_from;
	}

	/**
	 * 食堂接待信息结束时间查询取得
	 * @return eetime_to 食堂接待信息结束时间查询
	 */
	public String getEetime_to() {
		return eetime_to;
	}

	/**
	 * 食堂接待信息结束时间查询设定
	 * @param eetime_to 食堂接待信息结束时间查询
	 */
	public void setEetime_to(String eetime_to) {
		this.eetime_to = eetime_to;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 页面标题显示取得
	 * @return 页面标题显示
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面标题显示设定
	 * @param mode 页面标题显示
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getRid_org() {
		return rid_org;
	}

	public void setRid_org(Integer rid_org) {
		this.rid_org = rid_org;
	}

	public Integer getRid_mon() {
		return rid_mon;
	}

	public void setRid_mon(Integer rid_mon) {
		this.rid_mon = rid_mon;
	}

	public String getRstatus() {
		return rstatus;
	}

	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	
	/**
	 * 页面标识取得
	 * @return 页面标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 页面标识设定
	 * @param flag 页面标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
