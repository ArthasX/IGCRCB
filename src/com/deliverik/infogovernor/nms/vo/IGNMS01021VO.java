/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.nms.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.nms.model.NMS02Info;

/**
 * ����: SNMP����VO
 * ��������: SNMP����DTO
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGNMS01021VO extends BaseVO implements Serializable {
	
	/** SNMP�����б� */
	protected List<NMS02Info> lst_NMS02Info;

	/**
	 * SNMP�����б�ȡ��
	 * @return SNMP�����б�
	 */
	public List<NMS02Info> getLst_NMS02Info() {
		return lst_NMS02Info;
	}

	/**
	 * SNMP�����б��趨
	 * @param lst_NMS02Info SNMP�����б�
	 */
	public void setLst_NMS02Info(List<NMS02Info> lst_NMS02Info) {
		this.lst_NMS02Info = lst_NMS02Info;
	}
	
}
