/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * ����: ���򿪷���Ϣ��ѯVO 
 * ������¼��yukexin    2014-8-7 10:03:28
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2301VO extends BaseVO{

	/** ���򿪷���Ϣ���� */
	protected List<IGCRC2301VWInfo> igcrc2301VWList;

	protected List<IG500Info> processList;
	
	
	/**
	 * ���򿪷���Ϣ����ȡ��
	 * @return igcrc2301VWList  ���򿪷���Ϣ����
	 */
	public List<IGCRC2301VWInfo> getIgcrc2301VWList() {
		return igcrc2301VWList;
	}

	/**
	 * ���򿪷���Ϣ�����趨
	 * @param igcrc2301vwList  igcrc2301VWList
	 */
	public void setIgcrc2301VWList(List<IGCRC2301VWInfo> igcrc2301vwList) {
		igcrc2301VWList = igcrc2301vwList;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}
	
	
	

}
