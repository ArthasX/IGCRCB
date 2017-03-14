/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 服务记录统计页面查询form
 * 功能描述：服务记录统计页面查询form
 * 创建人：赵敏
 * 创建记录： 2012-7-12
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGASM2501Form extends BaseForm implements Serializable{

	/** 服务商名称 */
	protected String einame_like;
	
	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;

	protected Integer eiid;

	/** 服务商名称 */
	protected String einame;

	/** 设备资产 */
	protected String civalue;

	/** 设备资产评分 */
	protected String civalue1;

	/** 应用资产 */
	protected String civalue2;

	/** 应用资产评分 */
	protected String civalue3;

	/** 培训记录 */
	protected String einame3;

	/** 培训记录评分 */
	protected String civalue4;
	
	/** 合计次数 */
	protected Integer sumcount;
	
	/** 合计平均分 */
	protected Double sumstore;
	
	/**
	 * 获取einame_like
	 * @return feiname_like einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * 设置einame_like
	 * @param einame_like  einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

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
	 * 获取eiid
	 * @return feiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 设置eiid
	 * @param eiid  eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
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
	public String getCivalue3() {
		return civalue3;
	}

	/**
	 * 设置civalue3
	 * @param civalue3  civalue3
	 */
	public void setCivalue3(String civalue3) {
		this.civalue3 = civalue3;
	}

	/**
	 * 获取einame3
	 * @return feiname3 einame3
	 */
	public String getEiname3() {
		return einame3;
	}

	/**
	 * 设置einame3
	 * @param einame3  einame3
	 */
	public void setEiname3(String einame3) {
		this.einame3 = einame3;
	}

	/**
	 * 获取civalue4
	 * @return fcivalue4 civalue4
	 */
	public String getCivalue4() {
		return civalue4;
	}

	/**
	 * 设置civalue4
	 * @param civalue4  civalue4
	 */
	public void setCivalue4(String civalue4) {
		this.civalue4 = civalue4;
	}

	/**
	 * 获取sumcount
	 * @return fsumcount sumcount
	 */
	public Integer getSumcount() {
		return sumcount;
	}

	/**
	 * 设置sumcount
	 * @param sumcount  sumcount
	 */
	public void setSumcount(Integer sumcount) {
		this.sumcount = sumcount;
	}

	/**
	 * 获取sumstore
	 * @return fsumstore sumstore
	 */
	public Double getSumstore() {
		return sumstore;
	}

	/**
	 * 设置sumstore
	 * @param sumstore  sumstore
	 */
	public void setSumstore(Double sumstore) {
		this.sumstore = sumstore;
	}
	
	
}
