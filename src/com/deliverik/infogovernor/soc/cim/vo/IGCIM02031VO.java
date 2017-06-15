/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0111Info;

/**
 * ����: �ʲ�������Ϣ��������֣�
 * ��������: �ʲ�������Ϣ��������֣�
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02031VO extends BaseVO implements Serializable {

	/** �ʲ����������� */
	protected List<SOC0111Info> soc0111List;

	/**
	 * ���캯��
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public IGCIM02031VO(List<SOC0111Info> soc0111List) {
		this.soc0111List = soc0111List;
	}

	/**
	 * �ʲ�����������
	 * 
	 * @return �ʲ�����������
	 */
	public List<SOC0111Info> getSoc0111List() {
		return soc0111List;
	}

	/**
	 * �ʲ�����������
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public void setSoc0111List(List<SOC0111Info> soc0111List) {
		this.soc0111List = soc0111List;
	}

}
