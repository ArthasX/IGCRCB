/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 服务记录明细页面查询form
 * 功能描述：服务记录明细页面查询form
 * 创建人：赵敏
 * 创建记录： 2012-7-13
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM2502Form extends BaseForm implements Serializable{

	/** 服务商编号 */
	protected String eiid_q;
	
	/** 服务记录开始时间 */
	protected String beginTime;
	
	/** 服务记录结束时间 */
	protected String endTime;

	/** 服务记录名称 */
	protected String einame;
	
	/** 服务记录编号 */
	protected String eilabel;

	/** 服务记录登记时间 */
	protected String eiinsdate;

	/** 服务类型 */
	protected String civalue;

	/** 服务性质 */
	protected String civalue1;

	/** 服务评价 */
	protected String civalue2;

	/** 服务评分 */
	protected Double civalue3;

	/**
	 * 获取eiid_q
	 * @return feiid_q eiid_q
	 */
	public String getEiid_q() {
		return eiid_q;
	}

	/**
	 * 设置eiid_q
	 * @param eiid_q  eiid_q
	 */
	public void setEiid_q(String eiid_q) {
		this.eiid_q = eiid_q;
	}

	/**
	 * 获取beginTime_q
	 * @return fbeginTime_q beginTime_q
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 获取endTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 设置endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	 * 获取eilabel
	 * @return feilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 设置eilabel
	 * @param eilabel  eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 获取eiinsdate
	 * @return feiinsdate eiinsdate
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 设置eiinsdate
	 * @param eiinsdate  eiinsdate
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * 获取civalue
	 * @return fcivalue civalue
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * 设置civalue
	 * @param civalue  civalue
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * 获取civalue1
	 * @return fcivalue1 civalue1
	 */
	public String getCivalue1() {
		return civalue1;
	}

	/**
	 * 设置civalue1
	 * @param civalue1  civalue1
	 */
	public void setCivalue1(String civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * 获取civalue2
	 * @return fcivalue2 civalue2
	 */
	public String getCivalue2() {
		return civalue2;
	}

	/**
	 * 设置civalue2
	 * @param civalue2  civalue2
	 */
	public void setCivalue2(String civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * 获取civalue3
	 * @return fcivalue3 civalue3
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * 设置civalue3
	 * @param civalue3  civalue3
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}
	
}
