/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;

/**
 * 概述:事件管理管理导出BL 
 * 创建记录：史凯龙 2014/07/20
 */
public class IGCRC0204ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC0204ExcelBL {
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0204ExcelBLImpl.class);

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================事件管理导出开始=================");
		IGCRC02ExcelDTO exceldto = (IGCRC02ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 报表数据内容取得

		// 所有流程信息
		List<IGCRC0208VWInfo> processList = exceldto.getProcessList();
		// 所有表单信息
		List<IG599Info> processInfoList = exceldto.getProcessInfoList();

		/* 
		 * 表单数据集
		 * 外层map: Key(prid:流程编号) Value(Map:对应流程表单数据)
		 * 内层Map: String(pivarname:表单名称) value(对应表单数据)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();


		// 所有的表单
		for (IG599Info info599 : processInfoList) {
			// 判断是否有该流程对应表单信息,如果不存在以该流程编号作为Key，创建一个map实例，用于存储所有对应表单
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// 填充该流程对应的所有表单信息
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

	/*	// 所有的状态
		for (IG333Info psd : processStatusDefList) {
			//以流程状态标示作为Key，填充所有流程状态信息
			psdMap.put(psd.getPsdcode() + "-" + psd.getPdid(), psd);
		}*/

		// 所有参与人
		/*for (IG337Info pp : processParticipantList) {
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
		}*/

		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取流程对象
				IGCRC0208VWInfo info = processList.get(i);
				
				// 填充工单号
				addCell(0, i, info.getPrserialnum());
				// 发生时间
				addCell(1, i, info.getHappenTime());
				
				//是否已关闭
				if(StringUtils.isNotEmpty(info.getPrclosetime())){
					addCell(2, i, "是");
				}else{
					addCell(2, i, "否");
				}
				// 填充事件来源
				addCell(3, i, piMap.get(info.getPrid()).get("事件来源").getPivarvalue());
				
				// 填充事件名称
				addCell(4, i, info.getPrtitle());
				// 填充是否需要测试
				String[] strs = piMap.get(info.getPrid()).get("事件分类").getPivarvalue().split("_");
				String[] strs2 = strs[strs.length-1].split("-");
				addCell(5, i, strs2[strs2.length-1]);
				if(piMap.get(info.getPrid()).get("涉及系统")!=null){
					// 涉及应用系统
					addCell(6, i, piMap.get(info.getPrid()).get("涉及系统").getPivarvalue());
				}else{
					addCell(6, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("影响范围")!=null){
					// 影响范围
					addCell(7, i, piMap.get(info.getPrid()).get("影响范围").getPivarvalue());
				}else{
					addCell(7, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("影响范围备注")!=null){
					// 影响范围备注
					addCell(8, i, piMap.get(info.getPrid()).get("影响范围备注").getPivarvalue());
				}else{
					addCell(8, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("事件等级")!=null){
					// 事件等级
					addCell(9, i, piMap.get(info.getPrid()).get("事件等级").getPivarvalue());
				}else{
					addCell(9, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("事件原因")!=null){
					// 事件原因
					addCell(10, i, piMap.get(info.getPrid()).get("事件原因").getPivarvalue());
				}else{
					addCell(10, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("应急解决方案")!=null){
					// 应急解决方案
					addCell(11, i, piMap.get(info.getPrid()).get("应急解决方案").getPivarvalue());
				}else{
					addCell(11, i, "");
				}
				
			}
		}
		log.debug("=================事件开发管理导出结束=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
