/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;

/**
 * ����: ��ƿ���̨��ʾVO
 * ��������: ��ƿ���̨��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03011VO extends BaseVO implements Serializable{
	
	/** ���õ��������б� */
	protected List<SOC0105Info> soc0105List;
	
	/** ������� */
	protected SOC0104Info soc0104Info;

	/**
	 * ���õ��������б�ȡ��
	 *
	 * @return soc0105List ���õ��������б�
	 */
	public List<SOC0105Info> getSoc0105List() {
		return soc0105List;
	}

	/**
	 * ���õ��������б��趨
	 *
	 * @param soc0105List ���õ��������б�
	 */
	public void setSoc0105List(List<SOC0105Info> soc0105List) {
		this.soc0105List = soc0105List;
	}

	/**
	 * �������ȡ��
	 *
	 * @return soc0104Info �������
	 */
	public SOC0104Info getSoc0104Info() {
		return soc0104Info;
	}

	/**
	 * @param soc0105List
	 * @param soc0104Info
	 */
	public IGCIM03011VO(List<SOC0105Info> soc0105List, SOC0104Info soc0104Info) {
		super();
		this.soc0105List = soc0105List;
		this.soc0104Info = soc0104Info;
	}
	

	
}


