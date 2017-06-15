package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.crc.dto.IGCRC01ExcelDTO;

public class IGCRC01ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC01ExcelBL {
	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGCRC01ExcelBLImpl.class);

//	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub

		log.debug("=================工单查询结果导出处理开始=================");
		// 实例化DTO
		IGCRC01ExcelDTO exceldto = (IGCRC01ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<IG500Info> itemList = exceldto.getPrList();
		// 所有流程信息
		List<IG500Info> processList = exceldto.getProcessList();
		// 所有表单信息
		List<IG599Info> processInfoList = exceldto.getProcessInfoList();
		// 所有参与人信息
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();
		// 所有状态信息
		List<IG333Info> processStatusDefList = exceldto.getProcessStatusDefList();

		/* 
		 * 表单数据集
		 * 外层map: Key(prid:流程编号) Value(Map:对应流程表单数据)
		 * 内层Map: String(pivarname:表单名称) value(对应表单数据)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();
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

		// 所有的表单
		for (IG599Info info599 : processInfoList) {
			// 判断是否有该流程对应表单信息,如果不存在以该流程编号作为Key，创建一个map实例，用于存储所有对应表单
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// 填充该流程对应的所有表单信息
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

		// 所有的状态
		for (IG333Info psd : processStatusDefList) {
			//以流程状态标示作为Key，填充所有流程状态信息
			psdMap.put(psd.getPsdcode(), psd);
		}

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

		// 写入各个单元格
		// 写入各个单元格
		if (itemList != null && itemList.size() > 0) {

			for (int i = 0; i < itemList.size(); i++) {
				
				
				WorkFlowDefinitionBL ctlBL = (WorkFlowDefinitionBL) WebApplicationSupport.getBean("workFlowDefinitionBL");
				//实例化状态定义查询条件
				IG333SearchCondImpl cond = new IG333SearchCondImpl();
				cond.setPdid(itemList.get(0).getPrpdid());
				//查询状态定义
				List<IG333Info> psdList = ctlBL.searchProcessStatusDef(cond);
				//处理数据
				Map<String, String> psdMap1 = new HashMap<String, String>();
				for(IG333Info info:psdList){
					psdMap1.put(info.getPsdcode(), info.getPsdname());
				}
				//状态名称
			
				
				// 获取流程对象
				IG500Info info = itemList.get(i);
				String psdname = null;
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					psdname = "中止";
				}else{
					psdname = psdMap1.get(info.getPrstatus());
				}
				
				// 填充编号
				addCell(0, i, info.getPrserialnum());
				// 填充名称
				addCell(1, i, info.getPrtitle());
				// 填充工单类别
				String strs = piMap.get(info.getPrid()).get("工单类别")
 						.getPivarvalue();
				addCell(2, i, strs);
				// 填充具体描述
				String prdesc = info.getPrdesc();
				if(StringUtils.isNotEmpty(prdesc)){
					prdesc = prdesc.replace("&nbsp;", " ");
					prdesc = prdesc.replace("<br>", "");
				}
				addCell(3, i, prdesc);
				// 填充发起者
				addCell(4, i, info.getPrusername());
				// 填充发起时间
				addCell(5, i, info.getPropentime());
				// 填充关闭时间
				addCell(6, i, info.getPrclosetime());
				// 当前当前处理人
				StringBuffer str = new StringBuffer();
				// 获取对应流程处理人
				List<IG337Info> list = ppMap.get(info.getPrid()).get(
						psdMap.get(info.getPrstatus()).getPsdid());
				// 拼接流程当前处理人
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
						if (j > 0) {
							str.append(",");
						}
						str.append(list.get(j).getPpusername());
					}
				}
				addCell(7, i, str.toString());
				// 填充状态
				addCell(8, i, psdname);
			}
		}
		log.debug("=================工单查询结果导出处理结束=================");
		return dto;
		
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub

	
	
	return null;

}
}
