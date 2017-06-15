/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: �ʲ�������Ϣ��������֣�
 * ��������: �ʲ�������Ϣ��������֣�
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20031VO extends BaseVO implements Serializable {

	/** �ʲ����������� */
	protected List<EiDomainDefInfo> eiDomainDefInfoList;

	/**
	 * ���캯��
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public IGASM20031VO(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����������
	 * 
	 * @return �ʲ�����������
	 */
	public List<EiDomainDefInfo> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����������
	 * 
	 * @param eiDomainDefInfoList�ʲ�����������
	 */
	public void setEiDomainDefInfoList(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

}
