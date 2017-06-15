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
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.dto.IGCRC04ExcelDTO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14012VO;

/**
 * 概述:变更管理导出BL 
 * 创建记录：刁泽旭 2014/07/07
 */
public class IGCRC04ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC04ExcelBL {
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC04ExcelBLImpl.class);

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================获取变更管理导出开始=================");
		IGCRC04ExcelDTO exceldto = (IGCRC04ExcelDTO) excelDTO;
		// 所有参与人信息
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();
		/* 
		 * 参与人数据集
		 * 外层Map：Key(prid:流程编号) Value(Map:对应状态的参与人集合)
		 * 内层Map：Key(psdid:参与人状态) Value(List:所有对应状态的参与人)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		
		// 所有参与人
		for (IG337Info pp : processParticipantList) {
			// 判断该流程是否存在，如果不存在以该流程编号作为Key，创建一个map集合实例，用于填装对应所有参与人
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// 判断参与人状态是否存在，如果不存在以参与人状态作为Key，创建一个List集合实例，用于填装对应流程对应状态的参与人
			if (ppMap.get(pp.getPrid()).get(pp.getPpstatus()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPpstatus(), new ArrayList<IG337Info>());
			}
			// 填充参与人
			ppMap.get(pp.getPrid()).get(pp.getPpstatus()).add(pp);
		}
		// 设置起始行数
		exceldto.setStartRow(2);
		List<IGCRC14012VO> listVO = exceldto.getVoLists();
		if(listVO!=null && listVO.size()>0){
			for(int i=0;i<listVO.size();i++){
				StringBuffer str = new StringBuffer();
				IGCRC14012VO info = listVO.get(i);
				addCell(0, i, info.getPrserialnum());
				addCell(1, i, info.getPrtitle());
				addCell(2, i, info.getPrdesc());
				addCell(3, i, info.getChangetype());
				addCell(4, i, info.getChangeclassify());
				addCell(5, i, info.getUpdateplatform());
				addCell(6, i, info.getPrusername());
				
				// 获取对应流程处理人
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					str.append("");
				}else{					
					List<IG337Info> list = ppMap.get(info.getPrid()).get(info.getPrstatus());
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
				addCell(7, i, str.toString());
				addCell(8, i, info.getOrderstatus());
				addCell(9, i, info.getPropentime());
				addCell(10, i, info.getPrclosetime());
			}
		}
		log.debug("=================获取变更管理导出结束=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
