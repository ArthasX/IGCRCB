/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;

/**
 * 
 * ����: ������ѯ����ר��DTO
 * ��������: ������ѯ����ר��DTO
 * �����ˣ�hujuwen
 * ������¼: 2014/07/23
 * �޸ļ�¼:
 */
public class IGASM2814ExcelDTO extends ExcelDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8455652362708332682L;
	
	/**������ѯ����*/
	private  List<CheckItemVWInfo> itemList;
	/**������ѯ���� ���
	 * @return list
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}
	/**������ѯ���� �趨*/
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

}
