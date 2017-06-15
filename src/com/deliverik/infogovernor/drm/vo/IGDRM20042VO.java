package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

@SuppressWarnings("serial")
public class IGDRM20042VO extends BaseVO {
	protected SOC0509Info model;
	protected List<SOC0509Info> children;
	protected SOC0117Info entity;
	public IGDRM20042VO(IGDRM20DTO dto){
		model = dto.getModelInfo();
		children = dto.getModelChildrenInfo();
		entity = dto.getEntity();
	}
	public List<SOC0509Info> getChildren() {
		return children;
	}
	public void setChildren(List<SOC0509Info> children) {
		this.children = children;
	}
	public SOC0509Info getModel() {
		return model;
	}
	public void setModel(SOC0509Info model) {
		this.model = model;
	}
	public SOC0117Info getEntity() {
		return entity;
	}
	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}	
}
