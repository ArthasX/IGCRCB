/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-9新建 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGRIS0501Form extends BaseForm {

	protected Integer rcid;

	/** 检查项名称 */
	protected String rcname;

	/** 检查频率 */
	protected String rcfrequency;

	/** 责任人 */
	protected String rcusername;

	/** 检查项分类 */
	protected String rccategoryname;

	/** 问题名称 */
	protected String prtitle;

	/** 检查方式 */
	protected String rcrtestmode;

	/** 检查结果 */
	protected String rcstatus;

	/** 实际检查时间 */
	protected String rccreatetime;
	
	/** 结果说明 */
	protected String rcrcomment;

	/** 检查程度 */
	protected String rcrresult;

	/** 附件 */
	protected String rcrattch;

	/** 检查计划时间 */
	protected String rcrplandate;
	
	/**年*/
	protected String year;
	/**年*/
	protected String month;

	/**
	 * rcid取得
	 * @return rcid rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * rcid设定
	 * @param rcid rcid
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * 检查项名称取得
	 * @return rcname 检查项名称
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * 检查项名称设定
	 * @param rcname 检查项名称
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * 检查频率取得
	 * @return rcfrequency 检查频率
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}

	/**
	 * 检查频率设定
	 * @param rcfrequency 检查频率
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}

	/**
	 * 责任人取得
	 * @return rcusername 责任人
	 */
	public String getRcusername() {
		return rcusername;
	}

	/**
	 * 责任人设定
	 * @param rcusername 责任人
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * 检查项分类取得
	 * @return rccategoryname 检查项分类
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * 检查项分类设定
	 * @param rccategoryname 检查项分类
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}

	/**
	 * 问题名称取得
	 * @return prtitle 问题名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 问题名称设定
	 * @param prtitle 问题名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 检查方式取得
	 * @return rcrtestmode 检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * 检查方式设定
	 * @param rcrtestmode 检查方式
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * 检查结果取得
	 * @return rcstatus 检查结果
	 */
	public String getRcstatus() {
		return rcstatus;
	}

	/**
	 * 检查结果设定
	 * @param rcstatus 检查结果
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * 实际检查时间取得
	 * @return rccreatetime 实际检查时间
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * 实际检查时间设定
	 * @param rccreatetime 实际检查时间
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * 结果说明取得
	 * @return rcrcomment 结果说明
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * 结果说明设定
	 * @param rcrcomment 结果说明
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * 检查程度取得
	 * @return rcrresult 检查程度
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * 检查程度设定
	 * @param rcrresult 检查程度
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * 附件取得
	 * @return rcrattch 附件
	 */
	public String getRcrattch() {
		return rcrattch;
	}

	/**
	 * 附件设定
	 * @param rcrattch 附件
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}

	/**
	 * 检查计划时间取得
	 * @return rcrplandate 检查计划时间
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * 检查计划时间设定
	 * @param rcrplandate 检查计划时间
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * 年取得
	 * @return year 年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年设定
	 * @param year 年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 年取得
	 * @return month 年
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 年设定
	 * @param month 年
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
