/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;

/**
 * 
 * ����: ��������Ϣ������DTO
 * ��������: ��������Ϣ������DTO
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGASM0901ExcelDTO extends ExcelDTO{
	
	/** ��������Ϣ��ͼ������� */
	protected List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList;
	
	
	/**
	 * ��������Ϣ��ͼ������� ȡ��
	 *
	 * @return entityItemFacilitatorList
	 */
	public List<EntityItemFacilitatorVWInfo> getEntityItemFacilitatorList() {
		return entityItemFacilitatorList;
	}
	/**
	 * ��������Ϣ��ͼ������� �趨
	 *
	 * @param entityItemFacilitatorList
	 */
	public void setEntityItemFacilitatorList(
			List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList) {
		this.entityItemFacilitatorList = entityItemFacilitatorList;
	}
}
