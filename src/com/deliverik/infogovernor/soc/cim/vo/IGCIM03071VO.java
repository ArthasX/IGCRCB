/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
 * ����: ���������Ϣ��������֣�
 * ��������: ���������Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM03071VO extends BaseVO implements Serializable {
	
	/** ������������� */
	protected List<SOC0104Info> soc0104List;

	/**
	 * �������������ȡ��
	 *
	 * @return soc0104List �������������
	 */
	public List<SOC0104Info> getSoc0104List() {
		return soc0104List;
	}

	/**
	 * ��������������趨
	 *
	 * @param soc0104List �������������
	 */
	public void setSoc0104List(List<SOC0104Info> soc0104List) {
		this.soc0104List = soc0104List;
	}

	/**
	 * @param soc0104List
	 */
	public IGCIM03071VO(List<SOC0104Info> soc0104List) {
		super();
		this.soc0104List = soc0104List;
	}

	
	
	
	
	
	
}
