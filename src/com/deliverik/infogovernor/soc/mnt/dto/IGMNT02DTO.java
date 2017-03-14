/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0112Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0207Form;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
/**
 * 概述:容量监控管理DTO
 * 功能描述：
 * 创建记录：
 */

@SuppressWarnings("serial")
public class IGMNT02DTO extends BaseDTO implements Serializable{
	/** 国际化信息 */
	protected Locale locale;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 性能数据报警form */
	protected IGMNT0112Form igmnt0112Form;
	
	protected IGMNT0206Form igmnt0206Form;
	
	protected IGMNT0207Form igmnt0207Form;
	
	/** 性能数据报警list */
	protected List<SOC0306Info> soc0306List;
	/**
	 * 容量监控管理list
	 */
	protected List<SOC0423Info> soc0423List;
	/**
	 * host list
	 */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** 错误日志对象 */
	protected SOC0305Info soc0305Info;
	
	/** 错误日志查询条件接口Bean	 */
	protected SOC0305SearchCond soc0305SearchCond;
	
	/**错误日志对象List	 */
	protected List<SOC0305Info> soc0305List;
	
	protected List<SOC0307Info> soc0307List;
	
	/**复选框告警id数组 */
	protected String[] ids;
	
	/**告警等级集合 */
	protected List<LabelValueBean> alarmSeverityList;
	
	/**CI集合 */
	protected List<LabelValueBean> ciList;
	
	/**
	 * 导入类型信息
	 */
	protected List<LabelValueBean> impTypeList;

	/**
	 * 国际化信息取得
	 *
	 * @return locale 国际化信息
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 国际化信息设定
	 *
	 * @param locale 国际化信息
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 检索最大件数取得
	 *
	 * @return maxSearchCount 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 *
	 * @param maxSearchCount 检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 *
	 * @return pagingDto 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}





	/**
	 * hostlist取得
	 *
	 * @return labelValueBeanList hostlist
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * hostlist设定
	 *
	 * @param labelValueBeanList hostlist
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * 错误日志对象取得
	 *
	 * @return soc0305Info 错误日志对象
	 */
	public SOC0305Info getSoc0305Info() {
		return soc0305Info;
	}

	/**
	 * 错误日志对象设定
	 *
	 * @param soc0305Info 错误日志对象
	 */
	public void setSoc0305Info(SOC0305Info soc0305Info) {
		this.soc0305Info = soc0305Info;
	}

	/**
	 * 错误日志查询条件接口Bean取得
	 *
	 * @return soc0305SearchCond 错误日志查询条件接口Bean
	 */
	public SOC0305SearchCond getSoc0305SearchCond() {
		return soc0305SearchCond;
	}

	/**
	 * 错误日志查询条件接口Bean设定
	 *
	 * @param soc0305SearchCond 错误日志查询条件接口Bean
	 */
	public void setSoc0305SearchCond(SOC0305SearchCond soc0305SearchCond) {
		this.soc0305SearchCond = soc0305SearchCond;
	}

	/**
	 * 错误日志对象List取得
	 *
	 * @return soc0305List 错误日志对象List
	 */
	public List<SOC0305Info> getSoc0305List() {
		return soc0305List;
	}

	/**
	 * 错误日志对象List设定
	 *
	 * @param soc0305List 错误日志对象List
	 */
	public void setSoc0305List(List<SOC0305Info> soc0305List) {
		this.soc0305List = soc0305List;
	}

	/**
	 * soc0307List取得
	 *
	 * @return soc0307List soc0307List
	 */
	public List<SOC0307Info> getSoc0307List() {
		return soc0307List;
	}

	/**
	 * soc0307List设定
	 *
	 * @param soc0307List soc0307List
	 */
	public void setSoc0307List(List<SOC0307Info> soc0307List) {
		this.soc0307List = soc0307List;
	}

	/**
	 * 复选框告警id数组取得
	 *
	 * @return ids 复选框告警id数组
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * 复选框告警id数组设定
	 *
	 * @param ids 复选框告警id数组
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * 告警等级集合取得
	 *
	 * @return alarmSeverityList 告警等级集合
	 */
	public List<LabelValueBean> getAlarmSeverityList() {
		return alarmSeverityList;
	}

	/**
	 * 告警等级集合设定
	 *
	 * @param alarmSeverityList 告警等级集合
	 */
	public void setAlarmSeverityList(List<LabelValueBean> alarmSeverityList) {
		this.alarmSeverityList = alarmSeverityList;
	}

	/**
	 * CI集合取得
	 *
	 * @return ciList CI集合
	 */
	public List<LabelValueBean> getCiList() {
		return ciList;
	}

	/**
	 * CI集合设定
	 *
	 * @param ciList CI集合
	 */
	public void setCiList(List<LabelValueBean> ciList) {
		this.ciList = ciList;
	}

	/**
	 * 导入类型信息取得
	 *
	 * @return impTypeList 导入类型信息
	 */
	public List<LabelValueBean> getImpTypeList() {
		return impTypeList;
	}

	/**
	 * 导入类型信息设定
	 *
	 * @param impTypeList 导入类型信息
	 */
	public void setImpTypeList(List<LabelValueBean> impTypeList) {
		this.impTypeList = impTypeList;
	}

	/**
	 * 性能数据报警form取得
	 *
	 * @return igmnt0112Form 性能数据报警form
	 */
	public IGMNT0112Form getIgmnt0112Form() {
		return igmnt0112Form;
	}

	/**
	 * 性能数据报警form设定
	 *
	 * @param igmnt0112Form 性能数据报警form
	 */
	public void setIgmnt0112Form(IGMNT0112Form igmnt0112Form) {
		this.igmnt0112Form = igmnt0112Form;
	}

	/**
	 * igmnt0206Form取得
	 *
	 * @return igmnt0206Form igmnt0206Form
	 */
	public IGMNT0206Form getIgmnt0206Form() {
		return igmnt0206Form;
	}

	/**
	 * igmnt0206Form设定
	 *
	 * @param igmnt0206Form igmnt0206Form
	 */
	public void setIgmnt0206Form(IGMNT0206Form igmnt0206Form) {
		this.igmnt0206Form = igmnt0206Form;
	}

	/**
	 * igmnt0207Form取得
	 *
	 * @return igmnt0207Form igmnt0207Form
	 */
	public IGMNT0207Form getIgmnt0207Form() {
		return igmnt0207Form;
	}

	/**
	 * igmnt0207Form设定
	 *
	 * @param igmnt0207Form igmnt0207Form
	 */
	public void setIgmnt0207Form(IGMNT0207Form igmnt0207Form) {
		this.igmnt0207Form = igmnt0207Form;
	}

	/**
	 * soc0423List取得
	 *
	 * @return soc0423List soc0423List
	 */
	public List<SOC0423Info> getSoc0423List() {
		return soc0423List;
	}

	/**
	 * soc0423List设定
	 *
	 * @param soc0423List soc0423List
	 */
	public void setSoc0423List(List<SOC0423Info> soc0423List) {
		this.soc0423List = soc0423List;
	}

	/**
	 * 性能数据报警list取得
	 *
	 * @return soc0306List 性能数据报警list
	 */
	public List<SOC0306Info> getSoc0306List() {
		return soc0306List;
	}

	/**
	 * 性能数据报警list设定
	 *
	 * @param soc0306List 性能数据报警list
	 */
	public void setSoc0306List(List<SOC0306Info> soc0306List) {
		this.soc0306List = soc0306List;
	}


	
	
}
