package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;

/**
 * 机柜平面图单元格ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11142VO extends BaseVO implements Serializable{
	
	/** 单元格合并标识 */
	protected boolean isOneUnit;
	
	/** 设备信息 */
	protected SOC0602Info entityData;
	
	/** 空单元格标识 */
	protected boolean isSpace;

	/** 空单元行号 */
	protected Integer rowNum;
	
	/**
	 * 构造函数
	 */
	public IGASM11142VO() {
		this.isOneUnit = true;
		this.isSpace = true;
	}


	public boolean isOneUnit() {
		return isOneUnit;
	}


	public void setOneUnit(boolean isOneUnit) {
		this.isOneUnit = isOneUnit;
	}


	public SOC0602Info getEntityData() {
		return entityData;
	}


	public void setEntityData(SOC0602Info entityData) {
		this.entityData = entityData;
	}


	public boolean isSpace() {
		return isSpace;
	}


	public void setSpace(boolean isSpace) {
		this.isSpace = isSpace;
	}


	public Integer getRowNum() {
		return rowNum;
	}


	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
}


