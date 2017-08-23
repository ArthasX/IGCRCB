/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.dto.IGCRC03ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

/**
 * 概述:问题管理管理导出BL 
 * 创建记录：史凯龙
 */
public class IGCRC03ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC03ExcelBL {
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC03ExcelBLImpl.class);

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================问题管理导出开始=================");
		IGCRC03ExcelDTO exceldto = (IGCRC03ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		
		// 所有参与人信息
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();

		/* 
		 * 参与人数据集
		 * 外层Map：Key(prid:流程编号) Value(Map:对应状态的参与人集合)
		 * 内层Map：Key(psdid:参与人状态) Value(List:所有对应状态的参与人)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		/* 
		 * 状态数据集
		 * Key：(psdcode：流程状态标示)
		 * Value：(对应状态对象)
		 */
		Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();

	

		// 所有参与人
		for (IG337Info pp : processParticipantList) {
			// 判断该流程是否存在，如果不存在以该流程编号作为Key，创建一个map集合实例，用于填装对应所有参与人
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// 判断参与人状态是否存在，如果不存在以参与人状态作为Key，创建一个List集合实例，用于填装对应流程对应状态的参与人
			if (ppMap.get(pp.getPrid()).get(pp.getPsdid()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPsdid(),
						new ArrayList<IG337Info>());
			}
			// 填充参与人
			ppMap.get(pp.getPrid()).get(pp.getPsdid()).add(pp);
		}
		
		List<IGCRC0301VWInfo> infolist = exceldto.getIgcrc0301List(); 
		
		// 写入各个单元格
		if (infolist != null && infolist.size() > 0) {
			
			for (int i = 0; i < infolist.size(); i++) {
				// 获取流程对象
				IGCRC0301VWInfo info = infolist.get(i);
				
				
				// 填充工单号
				addCell(0, i, info.getPrserialnum());
				// 填充问题名称
				addCell(1, i, info.getPrtitle());
				// 填充工单状态
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					addCell(2, i, "中止");
				}else{
					addCell(2, i,  info.getOrderstatus());
				}
				
				StringBuffer str = new StringBuffer();
				// 获取对应流程处理人
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					str.append("");
				}else{					
					List<IG337Info> list = ppMap.get(info.getPrid()).get(info.getPsdid());
					// 拼接流程处理人
					if (list != null) {
						for (int j = 0; j < list.size(); j++) {
							if (j > 0) {
								str.append(",");
							}
							str.append(list.get(j).getPpusername());
						}
					}
				}
				// 填充处理人
				addCell(3, i, str.toString());
				// 填充发起时间
				addCell(4, i, info.getPropentime());
				// 填充关闭时间
				addCell(5, i, info.getPrclosetime());
				
				
				//填充后续优化方案
				if(info.getAfterplan()!=null){
					addCell(6, i, info.getAfterplan());
				}else{
					addCell(6, i, "");
				}
				if(info.getPlanstime()!=null){
					//填充计划解决时间
					addCell(7, i, info.getPlanstime());
				}else{
					addCell(7, i, "");
				}
				if(info.getDutypersion()!=null){
					//填充责任人
					addCell(8, i,info.getDutypersion());
				}else{
					addCell(8, i, "");
				}
			}
		}
		log.debug("=================获取问题管理导出结束=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
