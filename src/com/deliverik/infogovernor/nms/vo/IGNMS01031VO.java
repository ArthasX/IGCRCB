/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.nms.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * ����: ��������VO
 * ��������: ��������DTO
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGNMS01031VO extends BaseVO implements Serializable {
	
	/** ���������б� */
	protected List<NMS03Info> lst_NMS03Info;

	/**
	 * ���������б�ȡ��
	 * @return ���������б�
	 */
	public List<NMS03Info> getLst_NMS03Info() {
		return lst_NMS03Info;
	}

	/**
	 * ���������б��趨
	 * @param lst_NMS03Info ���������б�
	 */
	public void setLst_NMS03Info(List<NMS03Info> lst_NMS03Info) {
		this.lst_NMS03Info = lst_NMS03Info;
	}
	
}
