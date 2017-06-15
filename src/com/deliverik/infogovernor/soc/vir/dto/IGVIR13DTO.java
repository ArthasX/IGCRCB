/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1302Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR13DTO extends BaseDTO{

	/** vCenter名称 */
	protected Integer vcid;
	
	/** 主机名称 */
	protected String hostname;
	
	/** 下拉列表值集合 */
	protected List<LabelValueBean> labelValueBeanList;
	
	/** json结果 */
	protected String jsonResult;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/** 虚机信息集合 */
	protected List<VIM03Info> vim03List;

	/** 虚机信息编辑Form */
	protected IGVIR1302Form igvir1302Form;
	
	/**
	 * vCenter名称取得
	 * @return vcid vCenter名称
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCenter名称设定
	 * @param vcid vCenter名称
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 主机名称取得
	 * @return hostname 主机名称
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * 主机名称设定
	 * @param hostname 主机名称
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * 下拉列表值集合取得
	 * @return labelValueBeanList 下拉列表值集合
	 */
	public List<LabelValueBean> getLabelValueBeanList() {
		return labelValueBeanList;
	}

	/**
	 * 下拉列表值集合设定
	 * @param labelValueBeanList 下拉列表值集合
	 */
	public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
		this.labelValueBeanList = labelValueBeanList;
	}

	/**
	 * json结果取得
	 * @return jsonResult json结果
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json结果设定
	 * @param jsonResult json结果
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 虚机信息集合取得
	 * @return vim03List 虚机信息集合
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * 虚机信息集合设定
	 * @param vim03List 虚机信息集合
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}

	/**
	 * 虚机信息编辑Form取得
	 * @return igvir1302Form 虚机信息编辑Form
	 */
	public IGVIR1302Form getIgvir1302Form() {
		return igvir1302Form;
	}

	/**
	 * 虚机信息编辑Form设定
	 * @param igvir1302Form 虚机信息编辑Form
	 */
	public void setIgvir1302Form(IGVIR1302Form igvir1302Form) {
		this.igvir1302Form = igvir1302Form;
	}
}
