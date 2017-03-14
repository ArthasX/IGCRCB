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
 * ������¼: 2011/04/26
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20121VO extends BaseVO implements Serializable{
	
	/** �ʲ����������� */
	protected EiDomainDefInfo eiDomainDefInfo;
	
	/** �ʲ�����汾������� */
	protected List<EiDomainDefInfo> eiDomainDefInfoList;
	
	
	/**
	 * ���캯��
	 * @param eiDomainDefInfo�ʲ�����������
	 * @param eiDomainDefInfoList�ʲ�����汾�������
	 */
	public IGASM20121VO(EiDomainDefInfo eiDomainDefInfo,
			List<EiDomainDefInfo> eiDomainDefInfoList) {
		super();
		this.eiDomainDefInfo = eiDomainDefInfo;
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}

	/**
	 * �ʲ������������趨
	 * @param eiDomainDefInfo�ʲ�����������
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}

	/**
	 * �ʲ�����汾�������ȡ��
	 * @return �ʲ�����汾�������
	 */
	public List<EiDomainDefInfo> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * �ʲ�����汾��������趨
	 * @param eiDomainDefInfoList�ʲ�����汾�������
	 */
	public void setEiDomainDefInfoList(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}
	
	

}
