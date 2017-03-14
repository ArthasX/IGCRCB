/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;
/**
 * ����: ���������Ϣ��������֣�
 * ��������: ���������Ϣ��������֣�
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20111VO extends BaseVO implements Serializable{
	
	/** �������汾������� */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	/** ������������� */
	protected ImportVersionInfo importVersionInfo;
	
	
	
	/**
	 * ���캯��
	 * @param importVersionInfoList�������汾�������
	 * @param importVersionInfo�������������
	 */
	public IGASM20111VO(List<ImportVersionInfo> importVersionInfoList,
			ImportVersionInfo importVersionInfo) {
		super();
		this.importVersionInfoList = importVersionInfoList;
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * �������汾�������ȡ��
	 * @return ������������� 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * �������汾��������趨
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * �������������
	 * @return �������������
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * �������������
	 * @param importVersionInfo�������������
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	

}
