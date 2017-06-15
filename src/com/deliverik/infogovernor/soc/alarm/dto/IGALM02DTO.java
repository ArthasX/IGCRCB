/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.deliverik.infogovernor.soc.alarm.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0201Form;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0202Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;


/**
 * 
 */
@SuppressWarnings("serial")
public class IGALM02DTO extends BaseDTO implements Serializable{
	
	protected IGALM0201Form igalm0201Form;
	
	protected IGALM0202Form igalm0202Form;

	//监控类型集合
	protected List<LabelValueBean> monitorTypeList;
	
	//检索最大件数 
	protected int maxSearchCount;
	
	//翻页用DTO 
	protected PagingDTO pagingDto;
	
	//规则模板结果集
	protected List<CRM08Info> crm08InfoList;
	
	//删除模板对象id集合 
	protected String[] deleteId;
	
	//规则条件集合
	protected List<CRM07TB> crm07TBList;
	
	//监控指标集合
	protected List<LabelValueBean> monitorIndexList;
	
	public List<LabelValueBean> getMonitorTypeList() {
		return monitorTypeList;
	}

	public void setMonitorTypeList(List<LabelValueBean> monitorTypeList) {
		this.monitorTypeList = monitorTypeList;
	}

	public IGALM0201Form getIgalm0201Form() {
		return igalm0201Form;
	}

	public void setIgalm0201Form(IGALM0201Form igalm0201Form) {
		this.igalm0201Form = igalm0201Form;
	}

	public IGALM0202Form getIgalm0202Form() {
		return igalm0202Form;
	}

	public void setIgalm0202Form(IGALM0202Form igalm0202Form) {
		this.igalm0202Form = igalm0202Form;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<CRM08Info> getCrm08InfoList() {
		return crm08InfoList;
	}

	public void setCrm08InfoList(List<CRM08Info> crm08InfoList) {
		this.crm08InfoList = crm08InfoList;
	}

	public String[] getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	public List<CRM07TB> getCrm07TBList() {
		return crm07TBList;
	}

	public void setCrm07TBList(List<CRM07TB> crm07TBList) {
		this.crm07TBList = crm07TBList;
	}

	public List<LabelValueBean> getMonitorIndexList() {
		return monitorIndexList;
	}

	public void setMonitorIndexList(List<LabelValueBean> monitorIndexList) {
		this.monitorIndexList = monitorIndexList;
	}

}


