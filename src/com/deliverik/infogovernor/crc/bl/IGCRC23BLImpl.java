/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2301BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301CondImpl;

/**	
 * 概述:程序开发统计查询业务逻辑实现
 * 创建记录：yukexin    2014-8-15 下午2:26:23	
 * 修改记录：null
 */	
public class IGCRC23BLImpl implements IGCRC23BL {

	static Log log = LogFactory.getLog(IGCRC23BLImpl.class);
	
	/** 程序开发统计信息BL */
	protected IGCRC2301BL igcrc2301BL;

	
	/** 流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setIgcrc2301BL(IGCRC2301BL igcrc2301bl) {
		igcrc2301BL = igcrc2301bl;
	}
	
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**	
	 * 功能：程序开发信息查询处理
	 * @param dto IGCRC2301DTO
	 * @return IGCRC2301DTO
	 * @throws BLException
	 * 修改记录：null
	 */	
	public IGCRC2301DTO searchEntityItemAction(IGCRC2301DTO dto)
			throws BLException {
		log.debug("========程序开发统计信息查询处理开始========");
		//获取form
		IGCRC2301Form form = dto.getIgcrc2301Form();
		//实例化cond
		IGCRC2301CondImpl cond = new IGCRC2301CondImpl();
		//赋值
		cond = copyProperties(form, cond);
		//获取数据
		List<IGCRC2301VWInfo> crList = igcrc2301BL.searchIGCRC2301(cond);
		//赋值dto
		dto.setEntityItemVWInfoList(crList);
		log.debug("========程序开发信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 钻取 功能 
	 */
	public IGCRC2301DTO searchIG500ItemAction(IGCRC2301DTO dto)throws BLException {
		
		log.debug("========程序开发统计信息查询处理开始========");
		//获取form
		IGCRC2301Form form = dto.getIgcrc2301Form();
		//实例化cond
		IGCRC2301CondImpl cond = new IGCRC2301CondImpl();
		//赋值
		cond = copyProperties(form, cond);
		List<Integer> crList = null;
		
		//处理工单数
		if(form.getFlag().equals("0")){
			//获取该处理人处理的所有工单的prid
			crList = igcrc2301BL.searchListSum(cond);
		}
		//测试更新驳回    更新驳回    确认驳回
		if(form.getFlag().equals("1") || form.getFlag().equals("2") || form.getFlag().equals("3")){
			//获取该处理人处理的驳回工单的prid
			crList = igcrc2301BL.searchList(cond);			
		}
		IG500SearchCondImpl cond500 = new IG500SearchCondImpl();
		StringBuffer prid_in = new StringBuffer();
		// 判断工单集合不为空，则将prid组成一个字符窜
		if(crList.size()>0){
			for(int i =0  ; i<crList.size(); i++){
				prid_in.append("'");
				prid_in.append(crList.get(i).toString());
				prid_in.append("'");
				if(i < crList.size()-1){
					prid_in.append(",");
				}
			}
			cond500.setPrid_in(prid_in.toString());
			//查询所有符合条件的工单
			dto.setProcessList(workFlowOperationBL.searchProcessByType(cond500, 0, 0,
					null));
			dto.getPagingDto().setTotalCount(dto.getProcessList().size());
		}
		
		log.debug("========程序开发信息查询处理终了========");
		return dto;
	}
	
	

	/**	
	 * 功能：将form中的查询条件赋给cond
	 * @param form 页面查询条件
	 * @param cond 检索条件
	 * @return
	 * 修改记录：
	 */	
	private IGCRC2301CondImpl copyProperties(IGCRC2301Form form, IGCRC2301CondImpl cond){
		//年
		cond.setYear(form.getYear());
		//月
		cond.setMonth(form.getMonth());
		//设置要查询标志位
		if(form.getFlag()!=null){
			cond.setFlag(form.getFlag());			
		}
		//设置用户ID
		if(form.getUserID()!=null){
			cond.setUserid(form.getUserID());			
		}
		// 获取年
		String year = form.getYear();
		// 获取月
		String month = form.getMonth();
		String propentime = null;
		// 判断年月是否为空
		if (year == null && month == null) {
			propentime = "%";
		} else {
			propentime = year + "/" + month + "%";
		}
		// 拼接的年月赋值
		cond.setPropentime(propentime);
		return cond;
	}
}
