/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
/**
 * ����: ���������Ϣ��������֣�
 * ��������: ���������Ϣ��������֣�
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02111VO extends BaseVO implements Serializable{
	
	/** �������汾������� */
	protected List<SOC0120Info> importVersionInfoList;
	
	/** ������������� */
	protected SOC0120Info importVersionInfo;
	
	
	
	/**
	 * ���캯��
	 * @param importVersionInfoList�������汾�������
	 * @param importVersionInfo�������������
	 */
	public IGCIM02111VO(List<SOC0120Info> importVersionInfoList,
			SOC0120Info importVersionInfo) {
		super();
		this.importVersionInfoList = importVersionInfoList;
		this.importVersionInfo = importVersionInfo;
	}

	/**
	 * �������汾�������ȡ��
	 * @return ������������� 
	 */
	public List<SOC0120Info> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * �������汾��������趨
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<SOC0120Info> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * �������������
	 * @return �������������
	 */
	public SOC0120Info getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * �������������
	 * @param importVersionInfo�������������
	 */
	public void setImportVersionInfo(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	

}
