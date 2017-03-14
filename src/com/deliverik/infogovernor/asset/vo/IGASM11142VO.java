package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;

/**
 * ����ƽ��ͼ��Ԫ��֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11142VO extends BaseVO implements Serializable{
	
	/** ��Ԫ��ϲ���ʶ */
	protected boolean isOneUnit;
	
	/** �豸��Ϣ */
	protected SOC0602Info entityData;
	
	/** �յ�Ԫ���ʶ */
	protected boolean isSpace;

	/** �յ�Ԫ�к� */
	protected Integer rowNum;
	
	/**
	 * ���캯��
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


