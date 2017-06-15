/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
/**
 * 
 * ����: ��ͬ������Ϣ������DTO
 * ��������: ��ͬ������Ϣ������DTO
 * ������¼: 2012/04/19
 * �޸ļ�¼:
 */
@SuppressWarnings("serial")
public class IGASM0404ExcelDTO extends ExcelDTO {
	
	/** ������ͷ������Ϣ */
	protected List<SOC0600Info> exportInfoList;
	
	/** ����Ӧ�����б���Ϣ */
	protected List<SOC0600Info> exportInfoPayList;

	/**
	 * ������ͷ������Ϣȡ��
	 * @return ������ͷ������Ϣ
	 */
	public List<SOC0600Info> getExportInfoList() {
		return exportInfoList;
	}

	/**
	 * ������ͷ������Ϣ�趨
	 * @param exportInfoList ������ͷ������Ϣ
	 */
	public void setExportInfoList(List<SOC0600Info> exportInfoList) {
		this.exportInfoList = exportInfoList;
	}

	/**
	 * ����Ӧ�����б���Ϣȡ��
	 * @return ����Ӧ�����б���Ϣ
	 */
	public List<SOC0600Info> getExportInfoPayList() {
		return exportInfoPayList;
	}

	/**
	 * ����Ӧ�����б���Ϣ�趨
	 * @param exportInfoPayList ����Ӧ�����б���Ϣ
	 */
	public void setExportInfoPayList(List<SOC0600Info> exportInfoPayList) {
		this.exportInfoPayList = exportInfoPayList;
	}
}
