/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ��CI��Ϣ��������֣�
 * ��������: ��CI��Ϣ��������֣�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20131VO extends BaseVO implements Serializable{
	
	/** ����ϸ��Ϣ */
	protected List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList;
	
	protected List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList;
	
	protected String eilabel;


	
	/**
	 * ����ϸ��Ϣȡ��
	 * @return ����ϸ��Ϣ
	 */
	public List<EiDomainDetailMaxVWInfo> getEiDomainDetailVWInfoList() {
		return eiDomainDetailVWInfoList;
	}

	/**
	 * ����ϸ��Ϣ�趨
	 * @param eiDomainDetailInfoList����ϸ��Ϣ
	 */
	public void setEiDomainDetailVWInfoList(
			List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList) {
		this.eiDomainDetailVWInfoList = eiDomainDetailVWInfoList;
	}


	public List<EiDomainDetailCIInfo> getEiDomainDetailCIInfoList() {
		return eiDomainDetailCIInfoList;
	}

	public void setEiDomainDetailCIInfoList(
			List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}

	public String getEilabel() {
		return eilabel;
	}

	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

}
