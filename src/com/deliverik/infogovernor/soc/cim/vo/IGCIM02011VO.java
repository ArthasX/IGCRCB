/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.infogovernor.soc.model.CR03Info;

/**
 * ����: ����̨��ʾVO
 * ��������: ����̨��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02011VO extends BaseVO implements Serializable{
	
	/** ���õ��������б� */
	protected List<SOC0115Info> soc0115List;
	
	/** ���õ��������б�-ci2 */
	protected List<CR03Info> cr03InfoList;
	
	/**
	 * ���캯��
	 * @param eiWaitTaskList ���õ��������б�
	 */
	public IGCIM02011VO(List<SOC0115Info> soc0115List) {
		this.soc0115List = soc0115List;
	}
	
	/**
	 * �޲�캯��
	 */
	public IGCIM02011VO() {

	}
	/**
	 * ���õ��������б�ȡ��-ci2
	 * @return ���õ��������б�-ci2
	 */
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	/**
	 * ���õ��������б���-ci2
	 * @return ���õ��������б�-ci2
	 */
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}

	/**
	 * ���õ��������б�ȡ��
	 * @return ���õ��������б�
	 */
	public List<SOC0115Info> getSoc0115List() {
		return soc0115List;
	}
	
	
	
}


