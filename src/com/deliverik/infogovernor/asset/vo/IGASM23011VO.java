/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: �ɼ�����̨��Ϣ��������֣�
 * ��������: �ɼ�����̨��Ϣ��������֣�
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM23011VO extends BaseVO implements Serializable{
	
	/** �ɼ�����̨������� */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	
	/**
	 * ���캯��
	 * 
	 * @param importVersionInfoList�ɼ�����̨�������
	 */
	public IGASM23011VO(List<ImportVersionInfo> importVersionInfoList) {
		super();
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * �ɼ�����̨������� 
	 * @return �ɼ�����̨������� 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * �ɼ�����̨������� 
	 * @param importVersionInfoList�ɼ�����̨������� 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}
	
	
	

}
