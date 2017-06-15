package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * 机房平面图单元格ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11043VO extends BaseVO implements Serializable{
	
	/** 单元格合并标识 */
	protected boolean isOneUnit;
	
	/** 机柜信息 */
	protected SOC0603Info entityData;
	
	/** 空单元格标识 */
	protected boolean isSpace;

	
	/**
	 * 构造函数
	 * @param computerRoomVWInfo　机房信息
	 * @param computerContainerVWInfoList　机房所属机柜信息
	 */
	public IGASM11043VO() {
		this.isOneUnit = true;
		this.isSpace = true;
	}


	public boolean isOneUnit() {
		return isOneUnit;
	}


	public void setOneUnit(boolean isOneUnit) {
		this.isOneUnit = isOneUnit;
	}


	public SOC0603Info getEntityData() {
		return entityData;
	}


	public void setEntityData(SOC0603Info entityData) {
		this.entityData = entityData;
	}


	public boolean isSpace() {
		return isSpace;
	}


	public void setSpace(boolean isSpace) {
		this.isSpace = isSpace;
	}
	
	public int getRowspan() {
		int rowspan = Integer.parseInt(entityData.getY_width());
		
		return rowspan*50;
	}
	
	public int getColspan() {
		int colspan = Integer.parseInt(entityData.getX_width());
		
		return colspan*50;
	}
}


