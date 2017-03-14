/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;

/**
 * ����: �ɼ������Ϣ��������֣�
 * ��������: �ɼ������Ϣ��������֣�
 * ������¼: 2013/05/21
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM08021VO extends BaseVO implements Serializable{
	
	/** �汾�б� */
	protected List<SOC0120Info> soc0120List;
	
	/**�ɼ����󼯺�*/
	protected List<CR03Info> cr03InfoList;
	
	protected List<CR03VWInfo> cr03VWInfoList;
	
	


	public List<CR03VWInfo> getCr03VWInfoList() {
		return cr03VWInfoList;
	}
	public void setCr03VWInfoList(List<CR03VWInfo> cr03VWInfoList) {
		this.cr03VWInfoList = cr03VWInfoList;
	}
	/**
	 * �汾�б�ȡ��
	 *
	 * @return soc0128List �汾�б�
	 */
	public List<SOC0120Info> getSoc0120List() {
		return soc0120List;
	}
	/**
	 * �汾�б��趨
	 *
	 * @param soc0120List �汾�б�
	 */
	public void setSoc0120List(List<SOC0120Info> soc0120List) {
		this.soc0120List = soc0120List;
	}
	/**
	 * �ɼ����󼯺�ȡ��
	 *
	 * @return cr03InfoList �ɼ����󼯺�
	 */
	
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	/**
	 * �ɼ����󼯺��趨
	 *
	 * @param cr03InfoList �ɼ����󼯺�
	 */
	
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}

	
}
