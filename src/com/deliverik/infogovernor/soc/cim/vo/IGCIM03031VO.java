/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0105Info;

/**
 * ����: ��ƿ���̨����鿴VO
 * ��������: ��ƿ���̨����鿴VO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03031VO extends BaseVO implements Serializable{
	
	/** ��ƿ���̨�����б� */
	protected SOC0105Info soc0105List;

	/**
	 * ��ƿ���̨�����б�ȡ��
	 *
	 * @return soc0105List ��ƿ���̨�����б�
	 */
	public SOC0105Info getSoc0105List() {
		return soc0105List;
	}

	/**
	 * @param soc0105List
	 */
	public IGCIM03031VO(SOC0105Info soc0105List) {
		super();
		this.soc0105List = soc0105List;
	}

	/**
	 * ��ƿ���̨�����б��趨
	 *
	 * @param soc0105List ��ƿ���̨�����б�
	 */
	public void setSoc0105List(SOC0105Info soc0105List) {
		this.soc0105List = soc0105List;
	}
	

}


