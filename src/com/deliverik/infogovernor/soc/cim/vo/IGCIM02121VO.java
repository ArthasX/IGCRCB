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
 * ������¼: 2011/04/26
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02121VO extends BaseVO implements Serializable{
	
	/** �ʲ����������� */
	protected SOC0111Info eiDomainDefInfo;
	
	/** �ʲ�����汾������� */
	protected List<SOC0111Info> eiDomainDefInfoList;
	
	
	/**
	 * ���캯��
	 * @param eiDomainDefInfo�ʲ�����������
	 * @param eiDomainDefInfoList�ʲ�����汾�������
	 */
	public IGCIM02121VO(SOC0111Info eiDomainDefInfo,
			List<SOC0111Info> eiDomainDefInfoList) {
		super();
		this.eiDomainDefInfo = eiDomainDefInfo;
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public SOC0111Info getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}

	/**
	 * �ʲ������������趨
	 * @param eiDomainDefInfo�ʲ�����������
	 */
	public void setEiDomainDefInfo(SOC0111Info eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}

	/**
	 * �ʲ�����汾�������ȡ��
	 * @return �ʲ�����汾�������
	 */
	public List<SOC0111Info> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����汾��������趨
	 * @param eiDomainDefInfoList�ʲ�����汾�������
	 */
	public void setEiDomainDefInfoList(List<SOC0111Info> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}
	
	

}
