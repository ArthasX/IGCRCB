/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

/**
 * ����:���������ύͳ��DTO 
 * ������¼�����2014/07/24
 */
public class IGCRC1306ExcelDTO extends ExcelDTO {

	/** �������� */
	protected List<DepartModelVW> ListVM;

	public List<DepartModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		ListVM = listVM;
	}
	
}
