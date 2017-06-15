package com.deliverik.infogovernor.svc.bl;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.asset.bl.task.IG013BL;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prr.bl.task.IG003BL;
import com.deliverik.framework.workflow.prr.bl.task.IG160BL;
import com.deliverik.framework.workflow.prr.bl.task.IG359BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG359VW;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;

public class IGSVC07BLImpl extends BaseBLImpl implements IGSVC07BL{
	
	protected IG359BL ig359BL;
	
	protected IG500BL ig500BL;
	
	protected IG160BL ig160BL;
	
	protected IG013BL ig013BL;
	
	protected IG003BL ig003BL;
	
	protected IG007BL ig007BL;
	
	protected IG599BL ig599BL;
	
	protected IG933BL ig933BL;
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程关系信息操作 */
	private IG512BL ig512BL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setIg359BL(IG359BL ig359BL) {
		this.ig359BL = ig359BL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setIg160BL(IG160BL ig160BL) {
		this.ig160BL = ig160BL;
	}

	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setIg003BL(IG003BL ig003BL) {
		this.ig003BL = ig003BL;
	}

	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}
	
	public void setIg933BL(IG933BL ig933BL) {
		this.ig933BL = ig933BL;
	}

	/*
	 * <p>
	 * 设置流程关系信息操作
	 * <p>
	 * 
	 * @param ig512BL 流程关系信息操作
	 */
	public void setIg512BL(
			IG512BL ig512BL) {
		this.ig512BL = ig512BL;
	}

	public IGSVC06DTO findSummaryCountForOperation(IGSVC06DTO dto) throws BLException {//业务
		String type = dto.getPrassetcategory();
		IG359SearchCond cond = dto.getProcesscountsearchcond();
		List<IG359Info> processCountList = ig359BL.searchIG359Info(cond, 0, 0);
		if(null != type && "004".equals(type)){
			IG688SearchCondImpl entityItemVWCond = new IG688SearchCondImpl();
			entityItemVWCond.setEcategory(type);
			List<IG688Info> entityItemVWInfoList = ig013BL.searchIG688Info(entityItemVWCond,0,0);
			List<String> tempList = new ArrayList<String>();
			for (IG359Info processCount : processCountList) {
				tempList.add(processCount.getPrassetname());
			}
			for (IG688Info entityItemVWInfo : entityItemVWInfoList) {
				String einame = entityItemVWInfo.getEiname();
				if(!tempList.contains(einame)){
					IG359VW processCountVW = new IG359VW();
					processCountVW.setPrassetname(einame);
					processCountVW.setIncident(0);
					processCountVW.setChange(0);
					processCountVW.setProblem(0);
					processCountVW.setDeployment(0);
					processCountVW.setWork(0);
					processCountList.add(processCountVW);
				}
			}
		}
		dto.setProcessCountList(processCountList);
		return dto;
	}

	public IGSVC07DTO findSummaryCountForOperationTask(IGSVC07DTO dto) throws BLException {
		IG500SearchCond cond = dto.getPrSearchCond();
		List<IG500Info> processRecordList = ig500BL.queryProcessRecordEntityList(cond, 0, 0);
		
		dto.setProcessRecordList(processRecordList);
		return dto;
	}
	
	public IGSVC07DTO findSummaryCountForPersonTask(IGSVC07DTO dto) throws BLException {
		IG677SearchCond cond = dto.getProcessRecordInfoSearchCond();
		if(!"GD".equals(cond.getPrtype())){//如果不是查询工单
			List<IG677Info> processRecordInfoList = ig500BL.searchProcessRecordInfo(cond, 0, 0);
			dto.setProcessRecordInfo(processRecordInfoList);
		}else{//如果是查询工单
			IG933SearchCondImpl gdCond = new IG933SearchCondImpl();
			gdCond.setSfregisterid(cond.getPpuserid());
			gdCond.setSfinstimebegin(cond.getPropentime());
			gdCond.setSfinstimeend(cond.getPrclosetime());
			gdCond.setSfstatus("0002");//已经关闭的
			List<IG933Info> processGdRecordInfoList = ig933BL.searchIG933Info(gdCond, 0, 0);
			dto.setProcessGdRecordInfoList(processGdRecordInfoList);
		}
		return dto;
	}
	
	public IGSVC07DTO getOperationById(IGSVC07DTO dto) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrid(dto.getPrid());
		List<IG500Info> processRecordList = ig500BL.searchIG500Info(cond, 0, 0);
		if(null != processRecordList && processRecordList.size() > 0){
			dto.setProcess(processRecordList.get(0));
			
			dto.setProcessInfo(ig599BL.searchIG599InfosByKey(dto.getPrid()));
			
			//查询该流程关系
			IG512SearchCondImpl prrCond = new IG512SearchCondImpl();
			prrCond.setParprid(dto.getPrid());
			List<IG512Info> processRecordRelationList = ig512BL.searchIG512Info(prrCond,0,0);//主动
			prrCond.setParprid(null);
			prrCond.setCldprid(dto.getPrid());
			processRecordRelationList.addAll(ig512BL.searchIG512Info(prrCond,0,0));//被动
			//按建立时间升序排序
			ig512BL.orderByTimeAsc(processRecordRelationList);
			dto.setProcessRecordRelationList(processRecordRelationList);
		}
		return dto;
	}

	public IGSVC07DTO findSummaryCountForPerson(IGSVC07DTO dto) throws BLException {
		IG160SearchCond cond = dto.getUserProcessCountSearchCond();
		List<IG160Info> userProcessCountList = ig160BL.searchIG160Info(cond, 0, 0);
		dto.setUserProcessCountList(userProcessCountList);
		return dto;
	}
	
	public IGSVC07DTO findSummaryOfYear(IGSVC07DTO dto) throws BLException {
		IG003SearchCond cond = dto.getProcessSummarySearchCond();
		List<IG003Info> processSummaryList = ig003BL.searchIG003Info(cond, 0, 0);
		dto.setProcessSummaryList(processSummaryList);
		return dto;
	}
	
}