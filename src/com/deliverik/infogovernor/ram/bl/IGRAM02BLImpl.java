package com.deliverik.infogovernor.ram.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.infogovernor.ram.bl.task.AssessmentScoreVWBL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCondImpl;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
 * 风险检查业务逻辑实现
 *
 */

public class IGRAM02BLImpl extends BaseBLImpl implements IGRAM02BL {

	static Log log = LogFactory.getLog(IGRAM02BLImpl.class);

	/** 风险检查信息BL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;
	
	/** 流程BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 流程BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**
	 * assessmentScoreBL设定
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}
	
	/**
	 * workFlowOperationBL设定
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * workFlowDefinitionBL设定
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 风险评估历史评分查询
	 * 
	 * @param dto 检索条件
	 * @return 检索结果列表
	 */
	public IGRAM02DTO searchAssessmentScoreHistory(IGRAM02DTO dto)
			throws BLException {
		//评估项目保存map
		Map<String,List<IG007Info>> prjMap = new LinkedHashMap<String,List<IG007Info>>();
		
		log.debug("================评估打分评估项和分类查询处理开始===================");
		//获取评估项
		List<IG007Info> prjList = new ArrayList<IG007Info>();
		IG007SearchCondImpl ig007SearchCond = new IG007SearchCondImpl();
		ig007SearchCond.setPdid(dto.getPdid());
		prjList = workFlowDefinitionBL.searchProcessInfoDef(ig007SearchCond);
				//searchProcessInfoDefByCond(ig007SearchCond);
		//查询所有的评分分类
		List <String> typePrjList = new ArrayList<String>();
		for (IG007Info info : prjList){
			if(info.getPidunit() != null && !typePrjList.contains(info.getPidunit())){
				typePrjList.add(info.getPidunit());
			}
		}
		//组装prjMap
		
		for(String info : typePrjList){
			List <IG007Info> typePrjsList = new ArrayList<IG007Info>();
			for(IG007Info prjinfo :prjList){
				if( info.equals(prjinfo.getPidunit())){
					typePrjsList.add(prjinfo);
				}
			}
			prjMap.put(info,typePrjsList );
		}
		log.debug("================评估打分评估项和分类查询处理结束===================");
		log.debug("================评估打分参与人查询处理开始===================");
		//评分参与人员查询
		IG337SearchCondImpl ig337Cond = new IG337SearchCondImpl();
		ig337Cond.setPrid(Integer.parseInt(dto.getPrid()));
		//评估打分状态
		ig337Cond.setPpstatus("X");
		List<IG337Info> ig337List = workFlowOperationBL.searchProcessParticipants(ig337Cond);
		 //ig337BL.searchIG337InfoRun(ig337Cond);
		log.debug("================评估打分参与人查询处理结束===================");
		
		List<AssessmentScoreVWInfo> scoreList=new ArrayList<AssessmentScoreVWInfo>();
		//给未打分的人一个默认值 0
		List<IG007Info> removeList = new ArrayList<IG007Info>();
		for (IG007Info info : prjList){
			if(info.getPidunit() == null){
				removeList.add(info);
			}
		}
		prjList.removeAll(removeList);
		
		for (IG337Info info :ig337List){
			AssessmentScoreVWSearchCondImpl cond = new AssessmentScoreVWSearchCondImpl();
			cond.setPrid(Integer.parseInt(dto.getPrid()));
			cond.setUserid(info.getPpuserid());
			//查询指定流程的评分记录
			List<AssessmentScoreVWInfo> list = assessmentScoreVWBL.searchAssessmentScore(cond);
			if(list.size()>0){
				for(AssessmentScoreVWInfo as:list){
					scoreList.add(as);
				}
			}else{
				for(IG007Info cd:prjList){
					//此人没有评分则添加虚假对象
					AssessmentScoreVW as1 = new AssessmentScoreVW();
					as1.setPidid(cd.getPidid());
					as1.setPiid(cd.getPiid());
					as1.setPivarlabel(cd.getPidlabel());
					as1.setUserid(info.getPpuserid());
					as1.setPpivalue("0");
					as1.setPpicommect("");
					scoreList.add(as1);
				}
			}
		}
		dto.setPrjMap(prjMap);
		dto.setPpList(ig337List);
		dto.setHistoryScoreList(scoreList);
		return dto;
	}



}
