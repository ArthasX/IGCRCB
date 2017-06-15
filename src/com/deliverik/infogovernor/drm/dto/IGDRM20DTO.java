package com.deliverik.infogovernor.drm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.infogovernor.drm.form.IGDRM2001Form;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

/**
 * 概述: 功能描述: 创建记录: 修改记录:
 */
@SuppressWarnings("serial")
public class IGDRM20DTO extends BaseDTO {

	private SOC0117Info entity;
	private List<SOC0509Info> planSectionTree;
	private List<SOC0117Info> soc0117List;
	private SOC0509Info modelInfo;
	private List<SOC0509Info> modelChildrenInfo;
	private PagingDTO pagingDTO;
	/**
	 * 查询条件
	 */
	private String cname = "";

	public SOC0117Info getEntity() {
		return entity;
	}

	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}

	public void setPlanSectionTree(List<SOC0509Info> planSectionTree) {
		this.planSectionTree = planSectionTree;
	}

	public List<SOC0509Info> getPlanSectionTree() {
		return planSectionTree;
	}

	public List<SOC0117Info> getSoc0117List() {
		return soc0117List;
	}

	public void setSoc0117List(List<SOC0117Info> soc0117List) {
		this.soc0117List = soc0117List;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	public SOC0509Info getModelInfo() {
		return modelInfo;
	}

	public void setModelInfo(SOC0509Info modelInfo) {
		this.modelInfo = modelInfo;
	}

	public List<SOC0509Info> getModelChildrenInfo() {
		return modelChildrenInfo;
	}

	public void setModelChildrenInfo(List<SOC0509Info> modelChildrenInfo) {
		this.modelChildrenInfo = modelChildrenInfo;
	}
	
}
