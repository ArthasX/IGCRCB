/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
 * 概述:事件管理管理导出BL 
 * 创建记录：史凯龙 2014/07/20
 */
public class IGCRC0203ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC0203ExcelBL {
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0204ExcelBLImpl.class);

	/** 流程操作BL */
	private WorkFlowOperationBL workFlowOperationBL ;
	
	/**
	 * 流程操作BL设定
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================事件管理导出开始=================");
		log.debug("=================部门提交统计导出开始=================");
		IGCRC02ExcelDTO exceldto = (IGCRC02ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		//获取导出内容
		List<IgalarmInfo> igcrc0203voList = exceldto.getIgalarmInfos();
		
		for(int i=0;i<igcrc0203voList.size();i++){
			//获取流程对象
			IgalarmInfo info = igcrc0203voList.get(i);
			//事件单编号
			addCell(0, i, info.getPedeventid());
			if(StringUtils.isNotEmpty(info.getPedeventid())){
				IG500Info ig500Info = workFlowOperationBL.searchProcessRecordBySerialnum(info.getPedeventid());
				//工单名称
				addCell(1, i, ig500Info.getPrtitle());
			}

			//告警序号
			addCell(2, i, info.getSerial());
			//主机名称
			addCell(3, i, info.getAppname());
			//IP名称
			addCell(4, i, info.getIpaddr());
			//时间内容
			addCell(5, i, info.getSummary());
			//故障联系人
			addCell(6, i, info.getFaultContact());
			//出发时间
			addCell(7, i, info.getLasttime());
			//恢复时间
			addCell(8, i, info.getRecoveryTime());
			//是否生成工单
			if(StringUtils.isNotEmpty(info.getIsCreateOrder())){
				if("0".equals(info.getIsCreateOrder())){
					addCell(9, i, "否");
				}else if("1".equals(info.getIsCreateOrder())){
					addCell(9, i, "是");
				}
			}
			//状态
			if(StringUtils.isNotEmpty(info.getStatus())){
				if("0".equals(info.getStatus())){
					addCell(10, i, "告警");
				}else if("1".equals(info.getStatus())){
					addCell(10, i, "恢复");
				}else if("2".equals(info.getStatus())){
					addCell(10, i, "关闭");
				}
			}
			//描述
			addCell(11, i, info.getDescription());
		}
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
