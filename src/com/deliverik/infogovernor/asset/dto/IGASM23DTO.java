/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseDTO;
/**
 * ����: �ʲ�����ҵ����DTO
 * ��������: �ʲ�����ҵ����DTO
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM23DTO extends BaseDTO implements Serializable {

	/**
	 * ����������������ӿ�
	 */
	protected ImportVersionSearchCond importVersionSearchCond;
	
	/** ����ID���� */
	protected String[] collectIds;
	
	/** ������������� */
	protected List<ImportVersionInfo> importVersionInfoList;

	/**
	 * ����������������ӿ�ȡ��
	 * @return ����������������ӿ�
	 */
	public ImportVersionSearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * ����������������ӿ��趨
	 * @param importVersionSearchCond����������������ӿ�
	 */
	public void setImportVersionSearchCond(
			ImportVersionSearchCond importVersionSearchCond) {
		this.importVersionSearchCond = importVersionSearchCond;
	}

	/**
	 * ����ID����
	 * @return ����ID����
	 */
	public String[] getCollectIds() {
		return collectIds;
	}

	/**
	 * ����ID����
	 * @param collectIds ����ID����
	 */
	public void setCollectIds(String[] collectIds) {
		this.collectIds = collectIds;
	}
	
	/**
	 * ������������� 
	 * @return ������������� 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * ������������� 
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}
	
}
