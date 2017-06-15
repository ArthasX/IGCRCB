/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * ȫ������VO
 * <p>
 *  ���� ȫ�������õ��� vo
 * </p>
 * �޸�ʱ�䣺LuJiayuan 2013/01/31 Ǩ��SOC��������������IGCOM04034VO���ΪIGCOM04035VO
 */
public class IGCOM04035VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ȫ��������ʾVO
	 */
	protected List<IGCOM04034VO> voList;

	/**
	 * ȫ���������ݼ�������趨
	 * @param dutyDataList ȫ���������ݼ������
	 */
	public IGCOM04035VO(List<IG677Info> processRecordInfoList, List<IG677Info> processRecordInfoListAsc) {
		if(processRecordInfoList != null) {
			voList = new ArrayList<IGCOM04034VO>();
			voList.add(new IGCOM04034VO("�¼�"));
			voList.add(new IGCOM04034VO("���"));
			voList.add(new IGCOM04034VO("����"));

			for(IG677Info pri :processRecordInfoList) {			
				if (pri.getPrtype().startsWith(IGPROCESSType.INCIDENT_PRTYPE)) {
					voList.get(0).getProcessRecordInfoList().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.CHANGE_PRTYPE)) {
					voList.get(1).getProcessRecordInfoList().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.WORK_PRTYPE)) {
					voList.get(2).getProcessRecordInfoList().add(pri);
				}
			}
			
			for(IG677Info pri :processRecordInfoListAsc) {
				if (pri.getPrtype().startsWith(IGPROCESSType.INCIDENT_PRTYPE)) {
					voList.get(0).getProcessRecordInfoListAsc().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.CHANGE_PRTYPE)) {
					voList.get(1).getProcessRecordInfoListAsc().add(pri);
				} else if (pri.getPrtype().startsWith(IGPROCESSType.WORK_PRTYPE)) {
					voList.get(2).getProcessRecordInfoListAsc().add(pri);
				}
			}
		}
	}

	/**
	 * ȫ������������ʾVO
	 * @return ȫ������������ʾVO
	 */
	public List<IGCOM04034VO> getVoList() {
		return voList;
	}
}
