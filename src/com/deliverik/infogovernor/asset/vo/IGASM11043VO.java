package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * ����ƽ��ͼ��Ԫ��֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11043VO extends BaseVO implements Serializable{
	
	/** ��Ԫ��ϲ���ʶ */
	protected boolean isOneUnit;
	
	/** ������Ϣ */
	protected SOC0603Info entityData;
	
	/** �յ�Ԫ���ʶ */
	protected boolean isSpace;

	
	/**
	 * ���캯��
	 * @param computerRoomVWInfo��������Ϣ
	 * @param computerContainerVWInfoList����������������Ϣ
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


