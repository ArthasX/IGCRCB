/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @author Administrator
 *
 */
/**
 * 概述: 
 * 功能描述：
 * 创建人：赵敏
 * 创建记录： 2012-8-1
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM2601Form extends BaseForm {

	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;

	/** 单位名称 */
	protected String einame;

	/** 地址 */
	protected String address;

	/** 联系人 */
	protected String linkman;

	/** 联系方式 */
	protected String phone;

	/** 注册资金 */
	protected String fund;
	
	/** 公司资质 */
	protected String aptitude;

	/** 成功案例 */
	protected String succeedcase;
	
	/**
	 * 获取beginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * 设置beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * 获取endTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * 设置endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	/**
	 * 获取einame
	 * @return feiname einame
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 设置einame
	 * @param einame  einame
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 获取address
	 * @return faddress address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置address
	 * @param address  address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取linkman
	 * @return flinkman linkman
	 */
	public String getLinkman() {
		return linkman;
	}

	/**
	 * 设置linkman
	 * @param linkman  linkman
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	/**
	 * 获取phone
	 * @return fphone phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置phone
	 * @param phone  phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取fund
	 * @return ffund fund
	 */
	public String getFund() {
		return fund;
	}

	/**
	 * 设置fund
	 * @param fund  fund
	 */
	public void setFund(String fund) {
		this.fund = fund;
	}

	/**
	 * 获取aptitude
	 * @return faptitude aptitude
	 */
	public String getAptitude() {
		return aptitude;
	}

	/**
	 * 设置aptitude
	 * @param aptitude  aptitude
	 */
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	/**
	 * 获取succeedcase
	 * @return fsucceedcase succeedcase
	 */
	public String getSucceedcase() {
		return succeedcase;
	}

	/**
	 * 设置succeedcase
	 * @param succeedcase  succeedcase
	 */
	public void setSucceedcase(String succeedcase) {
		this.succeedcase = succeedcase;
	}
}
