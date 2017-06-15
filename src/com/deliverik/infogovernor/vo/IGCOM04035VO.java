/*
 * 北京递蓝科信息技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * 全部流程VO
 * <p>
 *  创建 全部工作用到的 vo
 * </p>
 * 修改时间：LuJiayuan 2013/01/31 迁移SOC所属功能名称由IGCOM04034VO变更为IGCOM04035VO
 */
public class IGCOM04035VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 全部流程显示VO
	 */
	protected List<IGCOM04034VO> voList;

	/**
	 * 全部流程内容检索结果设定
	 * @param dutyDataList 全部流程内容检索结果
	 */
	public IGCOM04035VO(List<IG677Info> processRecordInfoList, List<IG677Info> processRecordInfoListAsc) {
		if(processRecordInfoList != null) {
			voList = new ArrayList<IGCOM04034VO>();
			voList.add(new IGCOM04034VO("事件"));
			voList.add(new IGCOM04034VO("变更"));
			voList.add(new IGCOM04034VO("工单"));

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
	 * 全部流程内容显示VO
	 * @return 全部流程内容显示VO
	 */
	public List<IGCOM04034VO> getVoList() {
		return voList;
	}
}
