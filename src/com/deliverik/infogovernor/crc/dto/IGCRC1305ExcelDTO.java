/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * ����:�����ĵ�����ͳ��DTO 
 * ������¼�����2014/07/24
 */
public class IGCRC1305ExcelDTO extends ExcelDTO{

	/** �������� */
	protected List<ModelVW> ListVM;

	public List<ModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<ModelVW> listVM) {
		ListVM = listVM;
	}
	
}
