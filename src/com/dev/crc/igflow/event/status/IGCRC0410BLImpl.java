package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream.Check;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.risk.bl.task.CheckWorkResultBL;
import com.deliverik.infogovernor.risk.bl.task.CheckworkInfoResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * 功能：指派检查工作。设置检查工作的完成情况为已完成
 * @author 史凯龙   2014-9-9
 */
public class IGCRC0410BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(IGCRC0410BLImpl.class);

	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	private CheckworkInfoResultBL checkworkInfoResultBL;
	
	private IG599BL ig599BL;
	
	private CheckWorkResultBL checkWorkResultBL;
	
	/** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** 风险检查信息BL */
	protected RiskCheckResultBL riskCheckResultBL;
    
	/** 执行工作 */
	private String STATUSNAME_ZXGZ = "执行工作";

	
	/**
	 * @param checkworkInfoResultBL the checkworkInfoResultBL to set
	 */
	public void setCheckworkInfoResultBL(CheckworkInfoResultBL checkworkInfoResultBL) {
		this.checkworkInfoResultBL = checkworkInfoResultBL;
	}

	/**
	 * @param checkWorkResultBL the checkWorkResultBL to set
	 */
	public void setCheckWorkResultBL(CheckWorkResultBL checkWorkResultBL) {
		this.checkWorkResultBL = checkWorkResultBL;
	}

	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	

	/**
	 * @param ig599bl the ig599BL to set
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	/** 后处理 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** 前处理 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========指派工作流程部门审批前处理设置参与者处理开始========");

		    //日志参数信息设定
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //封装流程状态名称
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        setNextPoint(bean);
	        
	        	        
			log.debug("========指派工作流程部门审批前处理设置参与者处理结束========");
	}
	
	/**
	 * 设置下一个节点
	 * @param bean
	 */
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub

		//
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "人员");
		String result = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "检查结果");
		String resultCommont = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "结果说明");
		String ret = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "附件");
//		attachmentBL
		String resultABC = "";
		if("正常".equals(result)){
			resultABC = "A";
		}else if("存在问题".equals(result)){
			resultABC = "B";
		}else if("存在重大问题".equals(result)){
			resultABC = "C";
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String dateStr = format.format(date);
		
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	
        	CheckworkInfoResultSearchCondImpl cond = new CheckworkInfoResultSearchCondImpl();
        	cond.setRcrid(Integer.parseInt(rcrid));
        	//查询出检查任务关联资产表，期待求出检查任务   //肯定只有一条，因为这个表中，一条检查工作只能对应一条检查任务
        	List<CheckworkInfoResultInfo> info = checkworkInfoResultBL.searchCheckworkInfoResult(cond, 0, 0);
        	
        	if(info!=null && info.size()>0){
        		//查出检查任务
        		CheckWorkResultInfo cwrInfo =  checkWorkResultBL.searchCheckWorkResultByPK(info.get(0).getCwrid());
        		
        		CheckworkInfoResultSearchCondImpl cond2 = new CheckworkInfoResultSearchCondImpl();
        		
        		cond2.setCwrid(cwrInfo.getCwrid());
        		//查询关联表，这里肯定有多条，总数既是该条检查任务对应检查工作的数量
        		List<CheckworkInfoResultInfo> info2 = checkworkInfoResultBL.searchCheckworkInfoResult(cond2, 0, 0);
        		
        		Integer[] rcrid_in = new Integer[info2.size()];
				for(int i =0;i<info2.size();i++){
					rcrid_in[i] = info2.get(i).getRcrid();
				}
				//插入进度
				Integer rate = 0;
				
				RiskCheckResultSearchCondImpl rcrsCond = new RiskCheckResultSearchCondImpl();
				rcrsCond.setRcrid_in(rcrid_in);
				//查询出总的数量
				int sum = this.riskCheckResultBL.getSearchCountForRate(rcrsCond);
				//设置处理时间为空的数量，既是未处理的
				rcrsCond.setRcrrealtime_isNull("1");
				//查询出已经需要处理的工作数量，既是未处理的数量
				int count = this.riskCheckResultBL.getSearchCountForRate(rcrsCond);
				//计算出已处理完成的数量
				rate = (int) (((1-(double)(count-1) /(double)sum))*100);
				
				CheckWorkResultInfo cwrinfo = this.checkWorkResultBL.searchCheckWorkResultByPK(info.get(0).getCwrid());
				CheckWorkResultTB tb = (CheckWorkResultTB)cwrinfo;
				//如果进度为100,则该任务已完成
				if(rate == 100){
					Date time  = new Date();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					tb.setCwrrealtime(format1.format(time));
				}else if(rate >100){
					rate = 100;
					Date time  = new Date();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					tb.setCwrrealtime(format1.format(time));
				}else if (rate < 100) {// 如果进度小于100,则该任务未完成
					tb.setCwrrealtime("");
				}
				//将进度重新插入到该检查任务上
				tb.setCwrrate(rate.toString());
				this.checkWorkResultBL.updateCheckWorkResult(tb);
        	}
        	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
        	ig599Cond.setPrid(bean.getLogInfo().getPrid());
        	ig599Cond.setPivarname("附件");
        	
        	List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
        	
        	
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setRcrtestmode("已完成");
        		rcrTB.setRcrresult(resultABC);
        		rcrTB.setRcrcomment(resultCommont);
        		rcrTB.setRcrrealtime(dateStr);
        		if(ig599InfoList!=null && ig599InfoList.size()>0){
        			rcrTB.setRcrattch(ig599InfoList.get(0).getPiattkey());        			
        		}
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }
        
        //计算进度
		
	}
}