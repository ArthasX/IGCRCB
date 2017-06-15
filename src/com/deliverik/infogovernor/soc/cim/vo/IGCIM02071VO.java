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
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02071VO extends BaseVO implements Serializable{
	
	/** ������������� */
	protected List<SOC0120Info> importVersionInfoList;
	
	
	/**
	 * ���캯��
	 * 
	 * @param importVersionInfoList�������������
	 */
	public IGCIM02071VO(List<SOC0120Info> importVersionInfoList) {
		super();
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * ������������� 
	 * @return ������������� 
	 */
	public List<SOC0120Info> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * ������������� 
	 * @param importVersionInfoList������������� 
	 */
	public void setImportVersionInfoList(
			List<SOC0120Info> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}
	
	
	

}
