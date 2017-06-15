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
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20071VO extends BaseVO implements Serializable{
	
	/** ������������� */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	
	/**
	 * ���캯��
	 * 
	 * @param importVersionInfoList�������������
	 */
	public IGASM20071VO(List<ImportVersionInfo> importVersionInfoList) {
		super();
		this.importVersionInfoList = importVersionInfoList;
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
